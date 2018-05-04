package com.hxminco.mock.ioc.c;

import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayUtil;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.hxminco.mock.ext.config.MyConfig;
import com.hxminco.mock.ext.config.QRUtil;
import com.hxminco.mock.ext.config.TenpayUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by spiderman on 2018/2/1.
 */
@Controller
public class WxPayController {

    private static Logger logger = LoggerFactory.getLogger(WxPayController.class);

    @RequestMapping(value = "/getWxPayCode")
    public void getWxPayCode(HttpServletRequest request, HttpServletResponse response) {
        MyConfig config = null;
        try {
            config = MyConfig.getInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        WXPay wxpay = new WXPay(config);
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
        Map<String, String> parameters = new HashMap<>();
        parameters.put("body", "IphoneX");// 商品名称
        /** 当前时间 yyyyMMddHHmmss */
        String currTime = TenpayUtil.getCurrTime();
        /** 8位日期字符串 */
        String strTime = currTime.substring(8, currTime.length());
        /** 四位随机数 */
        String strRandom = TenpayUtil.buildRandom(4) + "";
        /** 订单号 */
        parameters.put("out_trade_no", strTime + strRandom);
        /** 订单金额以分为单位，只能为整数 */
        parameters.put("total_fee", "1");
        parameters.put("product_id", "12");   //商品ID
        parameters.put("device_info", "WEB");    //设备号
        parameters.put("fee_type", "CNY");    //标价币种(默认人民币)
        /** 客户端本地ip */
        parameters.put("spbill_create_ip", "123.12.12.123");//request.getRemoteAddr()
        /** 支付回调地址 */
        parameters.put("notify_url", "https://www.yuwana.cn/pay/pay_callback");//basePath + "getWxPayNotify.html"
        /** 支付方式为扫码支付 */
        parameters.put("trade_type", "NATIVE");
        /** 生成xml结构的数据，用于统一下单请求的xml请求数据 */
        Map<String, String> result = null;
        String codeUrl = null;
        try {
            result = wxpay.unifiedOrder(parameters);
            if("SUCCESS".equals(result.get("return_code")) && "SUCCESS".equals(result.get("result_code"))){
                codeUrl = result.get("code_url");
                logger.info("返回的二维码url：{}", codeUrl);
            }else{
                String msg = result.get("err_code_des")==null?result.get("return_msg"):result.get("err_code_des");
                logger.error(msg);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (codeUrl == null || "".equals(codeUrl))
            return;
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        int width = 300;
        int height = 300;
        String format = "gif";
        Map hints = new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8"); //设置字符集编码类型
        BitMatrix bitMatrix = null;
        try {
            bitMatrix = multiFormatWriter.encode(codeUrl, BarcodeFormat.QR_CODE, width, height, hints);
            QRUtil.writeToStream(bitMatrix, format, response.getOutputStream());
        } catch (WriterException e1) {
            logger.error(e1.getMessage(), e1);
        }catch (Exception e2){
            logger.error(e2.getMessage(),e2);
        }
    }

    @RequestMapping(value = "/getWxPayNotify")
    public void getWxPayNotify(HttpServletRequest request, HttpServletResponse response){
        String notifyData = "";
        try {
            InputStream is = request.getInputStream();
            StringBuffer sb = new StringBuffer();
            String s;
            BufferedReader in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            while ((s = in.readLine()) != null) {
                sb.append(s);
            }
            in.close();
            is.close();

            notifyData = sb.toString();
            MyConfig config = MyConfig.getInstance();
            WXPay wxpay = new WXPay(config);
            Map<String, String> notifyMap = WXPayUtil.xmlToMap(notifyData);  // 转换成map
            String out_trade_no = notifyMap.get("out_trade_no");
            if (wxpay.isPayResultNotifySignatureValid(notifyMap)) {
                if ("SUCCESS".equals(notifyMap.get("result_code"))) {
                    // 这里是支付成功
                    //////////执行自己的业务逻辑////////////////
                    String mch_id = notifyMap.get("mch_id");
                    String openid = notifyMap.get("openid");
                    String is_subscribe = notifyMap.get("is_subscribe");

                    String bank_type = notifyMap.get("bank_type");
                    String total_fee = notifyMap.get("total_fee");
                    String transaction_id = notifyMap.get("transaction_id");

                    System.out.println("mch_id:" + mch_id);
                    System.out.println("openid:" + openid);
                    System.out.println("is_subscribe:" + is_subscribe);
                    System.out.println("out_trade_no:" + out_trade_no);
                    System.out.println("total_fee:" + total_fee);
                    System.out.println("bank_type:" + bank_type);
                    System.out.println("transaction_id:" + transaction_id);
                    logger.info("支付成功");
                    // 签名正确
                    // 进行处理。
                    // 注意特殊情况：订单已经退款，但收到了支付结果成功的通知，不应把商户侧订单状态从退款改成支付成功
                } else {
                    logger.error("支付失败,错误信息：" + notifyMap.get("err_code") + "-----订单号：：：" + out_trade_no + "*******支付失败时间：：：：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                }
                OutputStream outputStream = null;
                try {
                    outputStream = response.getOutputStream();
                    outputStream.flush();
                    outputStream.write(setXML("SUCCESS", "").getBytes());
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    try {
                        outputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                //------------------------------
                //处理业务完毕
                //------------------------------
            } else {
                // 签名错误，如果数据里没有sign字段，也认为是签名错误
                logger.error("签名匹配失败,支付失败");
            }
            logger.info("微信支付返回的通知为：" + notifyMap);
        } catch (Exception e) {

        }
    }



    public static String setXML(String return_code, String return_msg) {
        return "<xml><return_code><![CDATA[" + return_code
                + "]]></return_code><return_msg><![CDATA[" + return_msg
                + "]]></return_msg></xml>";
    }
}

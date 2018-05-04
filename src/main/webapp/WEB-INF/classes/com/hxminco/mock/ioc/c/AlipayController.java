package com.hxminco.mock.ioc.c;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.hxminco.mock.comm.utils.AlipayNotify;
import com.hxminco.mock.ext.config.AlipayConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by spiderman on 2018/1/26.
 */
@RequestMapping("/pay")
@Controller
public class AlipayController {
    private static final Logger logger = LoggerFactory.getLogger(AlipayController.class);
    @RequestMapping(value = "/goPay.html")
    public void pay(HttpServletResponse httpResponse) {
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type); //获得初始化的AlipayClient
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        alipayRequest.setBizContent("{" +
                "    \"out_trade_no\":\"20150320010101004\"," +
                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                "    \"total_amount\":88.88," +
                "    \"subject\":\"Iphone6 16G\"," +
                "    \"body\":\"Iphone6 16G\"," +
                "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\"," +
                "    \"extend_params\":{" +
                "    \"sys_service_provider_id\":\"2088511833207846\"" +
                "    }" +
                "  }");//填充业务参数
        String form = "";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + AlipayConfig.charset);
        try {
            httpResponse.getWriter().write(form);
            httpResponse.getWriter().flush();
            httpResponse.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value="/notify_url.html",method = RequestMethod.POST)
    public void notify_url(HttpServletRequest request,HttpServletResponse response) throws IOException {
        logger.info("支付宝app支付进入回调");
        Map<String, String> params = new HashMap<>();
        Map requestParams = request.getParameterMap();
        for (Iterator it = requestParams.keySet().iterator(); it.hasNext(); ) {
            String name = (String) it.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            try {
                valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            params.put(name, valueStr);
        }
        logger.info("原生支付宝支付回调打印的参数：" + params.toString());
        String msg = "";
        String trade_status = null;
        try {
            trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        try {
            boolean isSign = AlipaySignature.rsaCheckV1(params,AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
            if (isSign) {

                if ("WAIT_BUYER_PAY".equals(trade_status)) {
                    msg = "交易创建，等待买家付款";
                    trade_status = "USERPAYING";
                    logger.info(msg);
                } else if ("TRADE_CLOSED".equals(trade_status)) {
                    msg = "未付款交易超时关闭，或支付完成后全额退款";
                    logger.info(msg);
                    trade_status = "PAYCLOSED";
                } else if ("TRADE_SUCCESS".equals(trade_status)) {
                    msg = "交易支付成功";
                    logger.info(msg);
                    trade_status = "SUCCESS";
                } else if ("TRADE_FINISHED".equals(trade_status)) {
                    msg = "交易结束，不可退款";
                    logger.info(msg);
                    trade_status = "PAYFINISHED";
                }

            } else {
                msg = "系统验签出错";
                logger.error(msg);
                trade_status = "ERROR";
                response.getWriter().write("FAIL");
            }
        } catch (AlipayApiException e) {
            msg = "系统验签异常";
            logger.error(msg,e);
            trade_status = "ERROR";
            try {
                response.getWriter().write("FAIL");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        if ("USERPAYING".equals(trade_status)) {
              logger.info("支付中");
            // 支付中
        } else if ("SUCCESS".equals(trade_status)) {
              logger.info("支付成功");
            try {
                //TODO
                response.getWriter().write("SUCCESS");
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 支付成功
        } else if ("PAYFINISHED".equals(trade_status)) {
            logger.info("交易完成");
            // 交易完成
        } else if ("TRADE_CLOSED".equals(trade_status)) {
            logger.info("交易结束");
            // 交易结束
        }
    }

    @RequestMapping("returnUrl")
    public ModelAndView returnUrl(HttpServletRequest request,HttpServletResponse response){
        ModelAndView mv = new ModelAndView("redirect:/meeting/info");
        Map<String,String> params = new HashMap<>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            try {
                valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            params.put(name, valueStr);
        }

        //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
        //商户订单号
        String out_trade_no = request.getParameter("out_trade_no");

        //支付宝交易号
        String trade_no = request.getParameter("trade_no");

        //交易状态
        String trade_status = request.getParameter("trade_status");

        String meetingId = request.getParameter("extra_common_param");
        mv.addObject("meetingId", meetingId);

        //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//

        //计算得出通知验证结果
        boolean verify_result = false;
        try {
            verify_result = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        PrintWriter out = null;
        if(verify_result){//验证成功
            if(trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")){
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //如果有做过处理，不执行商户的业务程序

                //TODO
            }
            try {
                out = response.getWriter();
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.println("验证成功<br />");
        }else{
            out.println("验证失败");
        }
        return mv;
    }
}
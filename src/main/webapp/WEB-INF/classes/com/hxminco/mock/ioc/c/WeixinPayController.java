package com.hxminco.mock.ioc.c;

import com.google.zxing.WriterException;
import com.hxminco.mock.ioc.s.WxPayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * Created by spiderman on 2018/1/31.
 */
@Controller
public class WeixinPayController {
    private static Logger log = LoggerFactory.getLogger(WeixinPayController.class);

    @Autowired
    WxPayService wxPayService;

    @RequestMapping(value = "/WxPayUnifiedorder.html", method = RequestMethod.GET)
    @ResponseBody
    public void wxPayUnifiedorder(String out_trade_no,HttpServletResponse response) throws Exception{
        HashMap<String,Object> map = new HashMap<>();
        String codeUrl = wxPayService.weixin_pay(out_trade_no);
        try {
            wxPayService.encodeQrcode(codeUrl, response);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/wxNotify.html", method = RequestMethod.POST)
    @ResponseBody
    public void wxNotify(HttpServletRequest request,HttpServletResponse response) throws Exception{
        System.out.println("支付回调方法开始！");
        HashMap<String,Object> map = new HashMap<>();
        wxPayService.weixin_notify(request, response);
        System.out.println("支付回调方法结束！");
    }
}

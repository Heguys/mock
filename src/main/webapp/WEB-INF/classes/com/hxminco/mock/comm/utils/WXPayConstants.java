package com.hxminco.mock.comm.utils;

/**
 * 常量
 */
public class WXPayConstants {

    public enum SignType {
        MD5, HMACSHA256
    }

    public static final String DOMAIN_API = "api.mch.weixin.qq.com";
    public static final String DOMAIN_API2 = "api2.mch.weixin.qq.com";
    public static final String DOMAIN_APIHK = "apihk.mch.weixin.qq.com";
    public static final String DOMAIN_APIUS = "apius.mch.weixin.qq.com";


    public static final String FAIL     = "FAIL";
    public static final String SUCCESS  = "SUCCESS";
    public static final String HMACSHA256 = "HMAC-SHA256";
    public static final String MD5 = "MD5";

    public static final String FIELD_SIGN = "sign";
    public static final String FIELD_SIGN_TYPE = "sign_type";

    public static final String MICROPAY_URL_SUFFIX     = "/pay/micropay";
    public static final String UNIFIEDORDER_URL_SUFFIX = "/pay/unifiedorder";
    public static final String ORDERQUERY_URL_SUFFIX   = "/pay/orderquery";
    public static final String REVERSE_URL_SUFFIX      = "/secapi/pay/reverse";
    public static final String CLOSEORDER_URL_SUFFIX   = "/pay/closeorder";
    public static final String REFUND_URL_SUFFIX       = "/secapi/pay/refund";
    public static final String REFUNDQUERY_URL_SUFFIX  = "/pay/refundquery";
    public static final String DOWNLOADBILL_URL_SUFFIX = "/pay/downloadbill";
    public static final String REPORT_URL_SUFFIX       = "/payitil/report";
    public static final String SHORTURL_URL_SUFFIX     = "/tools/shorturl";
    public static final String AUTHCODETOOPENID_URL_SUFFIX = "/tools/authcodetoopenid";

    // sandbox
    public static final String SANDBOX_MICROPAY_URL_SUFFIX     = "/sandboxnew/pay/micropay";
    public static final String SANDBOX_UNIFIEDORDER_URL_SUFFIX = "/sandboxnew/pay/unifiedorder";
    public static final String SANDBOX_ORDERQUERY_URL_SUFFIX   = "/sandboxnew/pay/orderquery";
    public static final String SANDBOX_REVERSE_URL_SUFFIX      = "/sandboxnew/secapi/pay/reverse";
    public static final String SANDBOX_CLOSEORDER_URL_SUFFIX   = "/sandboxnew/pay/closeorder";
    public static final String SANDBOX_REFUND_URL_SUFFIX       = "/sandboxnew/secapi/pay/refund";
    public static final String SANDBOX_REFUNDQUERY_URL_SUFFIX  = "/sandboxnew/pay/refundquery";
    public static final String SANDBOX_DOWNLOADBILL_URL_SUFFIX = "/sandboxnew/pay/downloadbill";
    public static final String SANDBOX_REPORT_URL_SUFFIX       = "/sandboxnew/payitil/report";
    public static final String SANDBOX_SHORTURL_URL_SUFFIX     = "/sandboxnew/tools/shorturl";
    public static final String SANDBOX_AUTHCODETOOPENID_URL_SUFFIX = "/sandboxnew/tools/authcodetoopenid";

    public static final String appid = "XXXXXX";//在微信开发平台登记的app应用
    public static final String appsecret = "XXXXXXXXX";
    public static final String partner = "XXXXXXXXX";//商户号
    public static final String partnerkey ="XXXXXXXXXXXXXXXXXXXXXXXXXXXXX";//不是商户登录密码，是商户在微信平台设置的32位长度的api秘钥，
    public static final String createOrderURL="https://api.mch.weixin.qq.com/pay/unifiedorder";
    public static final String backUri="http://XXXXXXXX/api/weixin/topay.jhtml";//微信支付下单地址
    public static final String notify_url="http://XXXXXXXXXX/api/weixin/notify.jhtml";//异步通知地址
}


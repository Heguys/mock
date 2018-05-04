package com.hxminco.mock.ext.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。 
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016091000480861";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCsZViCA1Wn/v5FIr0QDlcxvxymt/jYl1O9LHPYj3iQ0bo7eSWJU0C8pZbhy399GP33TSRB19Ix+lYvs52NclYLNbFWPXDxrCw5O6lDCYQoeBXTHjpop5zC2IXTOomLx2kcl6Xf263/iZ7KvOkBYf/znb0nUok/OXl3Fe0YTiWnvCEvrGaqXYc2JKdHaHyJT1u/nIFnFrNPG57Ra0e0VZoI1BkOj4smcUGkve1G9mxRDzKkD0NuP9cCBYAGb+eGNdCgtuW/eY/shABRP/gnc63GzPLo3rE5y56cmHZPPEBmsZdnRHDCbxWzG/cCzJVeHQb18bwY+JYjIClfTn3VWglpAgMBAAECggEAeYxO9gPh3bvEjPwsLujdg16KleV6V0OCsAtqdlLZn8mvM4V7+LGxIBDkK7jt30bCsR07pgzDz6cAI0vRlsv5bJfju7lAK7THzWaKNZC9FEduo9ZZOjaLKTm+SSqpldr3+kfVlNrveA8Q3UKKSgZNjvc1SUdBK0mboWHdM9jNZc/vAu1Jjr7WFWEaIHGGuWLBtrS30ZeI3Zn+jt62IHsT8F5KcJnU3nO2l2qW0Bp8uzfW0v6/YSySql6Wg5n89Hc1i40kTnTLDlg2sg5E2jNxwHh7KTOfe68wLcpTXKYXKvWJbKfBMIG/g42hOq8/ZkBNkuh0/isxPz80tmFkg28sAQKBgQDf5+eUJ9+8iiFQUE9mzAAWZjdOy6E2li7f6T4gAiKBTUebYd2UD9ij+H7iec3rwiAfgANP64UfFUgroL+dhyO7COHHGVHWmKJ1hXi/+t7n5vgrWEgw3OmFgkcoRCpGe42TkiqWhxXK6stpGV+zAciZy7I7wFdetpbSTS1WT/qcgQKBgQDFG0/aZLRhjgzWp5ueYUs+GCrIli1VYUoQv7EobpAJwqIwD7LWg+4zttJYlrZP8DwZ48mLE6LEyLnvIuiltS8558wUKdu5mS7XC6Qqovm0xZ5owtyVDdjoUK5/RjzrhkrgwXzFBEGse9dfdGxEzwxxROs3r/t/qrfYcyrDBtWY6QKBgEIZQOkg2FDdajY+byJGqOPz6vHs9TubHF1nirqCRtNrD++T9YinIOpPCo4rLRojJb6G2PN38MWbT8HpY4fKhEbLuXNAS0ORrawJ6fqqwbEuIycQmccrABk0u3LspJpIESR2avIjENDlfYUaQ4EhzqlwU76F6oUAXAfbVr37QF2BAoGBAK3kLIzF74VpZtYxRE90EoeTlpskMpZyoH8qPscm05hox+GS1/n8prelAOn6/JiFnuBQX8x85Eqrs63PpGQc9q8lWpwnWZviErrRoGGlKptbBSfzUduGPeim1Wufsbsv3Ptwd/zwhmf/UcD621HRQG7lmIamkUDOgidJY15vtx2RAoGACES4Pjdfna+ZEbelCU+SOlMAQfVydVbrSY3dOEnO9NGFSVYG6eZMcq3gs4QMsVspglY7SK/o+OjaoJEOij+Svig9nJQLATD0wPoHHaDh1J8AMeO4vwUSVxFJfJjW3xWnLck9sTA+m22TsL+e7EXuemCbasotOzhOj346WntN40U=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyui+GkKupOQROzmETJIRq8ZLOwl/HhE7BBzJ/9HI6w9T8NmvxV9qrtGKIbedR5u5yFOh5/9MlS1WyN9FdG3rjPd7dXGA2pZoEhLnP3DaMsblJiAzx2lVjiGyPCr4pOniMZpxtdbc8anvtWbby4ftY4xSh1FPLuP10GctNJdLk2q2jbZw/SkwRP955Ib40eATs/gj0IU+Fiiwcy8XMMwh7adBca8ya2MXOmWs9619JSOI7rIVxCYrPtBQM5uXrpyvq42w8s4L9P6NYd6rqnj/j8voyTtA8DMJIZ4O3bQITj0oOa0PN7FfhS5B+IUqrRHXGkB5aIqmO+I3xjMEsLP+sQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://1d97760t58.iask.in/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://1d97760t58.iask.in/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";

    public static String partner = "2088902523819159";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


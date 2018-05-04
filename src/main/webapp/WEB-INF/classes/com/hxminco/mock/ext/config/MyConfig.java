package com.hxminco.mock.ext.config;

import com.github.wxpay.sdk.WXPayConfig;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by spiderman on 2018/2/1.
 */
public class MyConfig implements WXPayConfig {

    private byte[] certData;
    private static MyConfig INSTANCE;

    private MyConfig() throws Exception{
        String certPath = "D://CERT/common/apiclient_cert.p12";
        File file = new File(certPath);
        InputStream certStream = new FileInputStream(file);
        this.certData = new byte[(int) file.length()];
        certStream.read(this.certData);
        certStream.close();
    }

    public static MyConfig getInstance() throws Exception{
        if (INSTANCE == null) {
            synchronized (MyConfig.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MyConfig();
                }
            }
        }
        return INSTANCE;
    }
    @Override
    public String getAppID() {
        return "wxab8acb865bb1637e";
    }

    @Override
    public String getMchID() {
        return "11473623";
    }

    @Override
    public String getKey() {
        return "2ab9071b06b9f739b950ddb41db2690d";
    }

    @Override
    public InputStream getCertStream() {
        ByteArrayInputStream certBis;
        certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }

    @Override
    public int getHttpConnectTimeoutMs() {
        return 6*1000;
    }

    @Override
    public int getHttpReadTimeoutMs() {
        return 8*1000;
    }


}

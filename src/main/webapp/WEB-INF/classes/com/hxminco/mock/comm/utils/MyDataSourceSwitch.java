package com.hxminco.mock.comm.utils;

/**
 * Created by Employee on 2017/8/11.
 */
public class MyDataSourceSwitch {
    private static ThreadLocal<String> key = new ThreadLocal<>();
    public static String getKey() {
        return key.get();
    }
    public static void setKey(String key_in) {
        key.set(key_in);
    }
}

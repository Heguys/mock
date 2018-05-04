package com.hxminco.mock.comm.utils;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by Employee on 2017/8/11.
 */
public class MyRoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        System.err.println("datasource-key:" + MyDataSourceSwitch.getKey());
        return MyDataSourceSwitch.getKey();
    }
}

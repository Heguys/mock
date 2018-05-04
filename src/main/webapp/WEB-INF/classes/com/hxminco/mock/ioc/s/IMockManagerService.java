package com.hxminco.mock.ioc.s;

import com.hxminco.mock.comm.entry.MockManager;

/**
 * Created by spiderman on 2018/1/18.
 */
public interface IMockManagerService {
    MockManager updateMockManager(String s, String account, String name, String institutionUid, boolean administrator);
}

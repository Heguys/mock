package com.hxminco.mock.ioc.d;

import com.hxminco.mock.comm.entry.MockManager;

public interface MockManagerMapper {
    int insert(MockManager record);

    int insertSelective(MockManager record);
    
    int updateByPrimaryKeySelective(MockManager record);

    MockManager selectByPrimaryKey(String managerId);

    MockManager selectByAccount(String account);
}
package com.hxminco.mock.ioc.d;

import com.hxminco.mock.comm.entry.UnionpayZmData;

public interface UnionpayZmDataMapper {
    int deleteByPrimaryKey(String uid);

    int insert(UnionpayZmData record);

    int insertSelective(UnionpayZmData record);

    UnionpayZmData selectByPrimaryKey(String uid);

    int updateByPrimaryKeySelective(UnionpayZmData record);

    int updateByPrimaryKey(UnionpayZmData record);
}
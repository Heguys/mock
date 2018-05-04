package com.hxminco.mock.ioc.d;

import com.hxminco.mock.comm.entry.SyncWorkClass;

import java.util.List;

public interface SyncWorkClassMapper {
    int deleteByPrimaryKey(Integer code);

    int insert(SyncWorkClass record);

    int insertSelective(SyncWorkClass record);

    SyncWorkClass selectByPrimaryKey(Integer code);

    int updateByPrimaryKeySelective(SyncWorkClass record);

    int updateByPrimaryKey(SyncWorkClass record);

    List<SyncWorkClass> selectAll();
}
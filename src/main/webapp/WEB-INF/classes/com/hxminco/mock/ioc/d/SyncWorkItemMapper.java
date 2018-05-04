package com.hxminco.mock.ioc.d;

import com.hxminco.mock.comm.entry.SyncWorkItem;

import java.util.List;

public interface SyncWorkItemMapper {
    int deleteByPrimaryKey(Integer code);

    int insert(SyncWorkItem record);

    int insertSelective(SyncWorkItem record);

    SyncWorkItem selectByPrimaryKey(Integer code);

    int updateByPrimaryKeySelective(SyncWorkItem record);

    int updateByPrimaryKey(SyncWorkItem record);

    List<SyncWorkItem> selectByWorkClassCode(Integer workClassCode);
}
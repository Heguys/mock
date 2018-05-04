package com.hxminco.mock.ioc.d;

import com.hxminco.mock.comm.entry.SyncMajorBase;

public interface SyncMajorBaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SyncMajorBase record);

    int insertSelective(SyncMajorBase record);

    SyncMajorBase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SyncMajorBase record);

    int updateByPrimaryKey(SyncMajorBase record);
}
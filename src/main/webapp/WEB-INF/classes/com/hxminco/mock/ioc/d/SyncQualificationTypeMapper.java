package com.hxminco.mock.ioc.d;

import com.hxminco.mock.comm.entry.SyncQualificationType;

import java.util.List;

public interface SyncQualificationTypeMapper {
    int deleteByPrimaryKey(Integer code);

    int insert(SyncQualificationType record);

    int insertSelective(SyncQualificationType record);

    SyncQualificationType selectByPrimaryKey(Integer code);

    int updateByPrimaryKeySelective(SyncQualificationType record);

    int updateByPrimaryKey(SyncQualificationType record);

    List<SyncQualificationType> selectAll();
}
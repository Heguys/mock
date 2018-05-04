package com.hxminco.mock.ioc.d;

import com.hxminco.mock.comm.entry.SyncUnitTypeQualification;

import java.util.List;

public interface SyncUnitTypeQualificationMapper {
    int deleteByPrimaryKey(Integer code);

    int insert(SyncUnitTypeQualification record);

    int insertSelective(SyncUnitTypeQualification record);

    SyncUnitTypeQualification selectByPrimaryKey(Integer code);

    int updateByPrimaryKeySelective(SyncUnitTypeQualification record);

    int updateByPrimaryKey(SyncUnitTypeQualification record);

    List<SyncUnitTypeQualification> selectAll();
}
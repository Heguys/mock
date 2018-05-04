package com.hxminco.mock.ioc.d;

import com.hxminco.mock.comm.entry.SyncEvidenceType;

import java.util.List;

public interface SyncEvidenceTypeMapper {
    int deleteByPrimaryKey(Integer code);

    int insert(SyncEvidenceType record);

    int insertSelective(SyncEvidenceType record);

    SyncEvidenceType selectByPrimaryKey(Integer code);

    int updateByPrimaryKeySelective(SyncEvidenceType record);

    int updateByPrimaryKey(SyncEvidenceType record);

    List<SyncEvidenceType> selectAll();
}
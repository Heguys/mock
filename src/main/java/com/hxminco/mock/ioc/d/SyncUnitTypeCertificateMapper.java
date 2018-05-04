package com.hxminco.mock.ioc.d;

import com.hxminco.mock.comm.entry.SyncUnitTypeCertificate;

import java.util.List;

public interface SyncUnitTypeCertificateMapper {
    int deleteByPrimaryKey(Integer code);

    int insert(SyncUnitTypeCertificate record);

    int insertSelective(SyncUnitTypeCertificate record);

    SyncUnitTypeCertificate selectByPrimaryKey(Integer code);

    int updateByPrimaryKeySelective(SyncUnitTypeCertificate record);

    int updateByPrimaryKey(SyncUnitTypeCertificate record);

    List<SyncUnitTypeCertificate> selectAll();
}
package com.hxminco.mock.ioc.d;

import com.hxminco.mock.comm.entry.SyncMajor;
import org.apache.ibatis.annotations.Param;

public interface SyncMajorMapper {
    int deleteByPrimaryKey(String id);

    int insert(SyncMajor record);

    int insertSelective(SyncMajor record);

    SyncMajor selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SyncMajor record);

    int updateByPrimaryKey(SyncMajor record);

    SyncMajor selectByQualificationTypeCodeAndWorkClassCodeAndWorkItemCode(@Param("qualificationTypeCode") int qualificationTypeCode,
                                                                           @Param("workClassCode") int workClassCode,
                                                                           @Param("workItemCode") int workItemCode);

    SyncMajor selectByQualificationTypeCodeAndEvidenceTypeCodeAndUnitTypeCode(@Param("qualificationTypeCode") int qualificationTypeCode,
                                                                              @Param("evidenceTypeCode") int evidenceTypeCode,
                                                                              @Param("unitTypeCode") int unitTypeCode);
}
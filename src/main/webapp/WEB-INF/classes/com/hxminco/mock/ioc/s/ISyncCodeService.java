package com.hxminco.mock.ioc.s;

import com.hxminco.mock.comm.entry.*;

import java.util.List;

/**
 * Created by spiderman on 2018/1/12.
 */
public interface ISyncCodeService {
    List<SyncQualificationType> getSyncQualificationTypeList();

    List<SyncWorkClass> getSyncWorkClassList();

    List<SyncWorkItem> getSyncWorkItemList(Integer assignCode2);

    SyncMajor selectByQualificationTypeCodeAndWorkClassCodeAndWorkItemCode(int assignCode1, int assignCode2, int assignCode3);

    List<SyncEvidenceType> getSyncEvidenceTypeList();

    SyncMajor selectByQualificationTypeCodeAndEvidenceTypeCodeAndUnitTypeCode(int assignCode1, int assignCode2, int i);

    List<SyncUnitTypeQualification> getSyncUnitTypeQualificationList();

    List<SyncUnitTypeCertificate> getSyncUnitTypeCertificateList();
}

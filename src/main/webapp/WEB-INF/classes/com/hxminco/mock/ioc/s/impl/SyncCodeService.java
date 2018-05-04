package com.hxminco.mock.ioc.s.impl;

import com.hxminco.mock.comm.entry.*;
import com.hxminco.mock.ioc.d.*;
import com.hxminco.mock.ioc.s.ISyncCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by spiderman on 2018/1/12.
 */
@Service
public class SyncCodeService implements ISyncCodeService {
    @Autowired
    SyncEvidenceTypeMapper evidenceTypeMapper;
    @Autowired
    SyncMajorBaseMapper majorBaseMapper;
    @Autowired
    SyncMajorMapper majorMapper;
    @Autowired
    SyncQualificationTypeMapper qualificationTypeMapper;
    @Autowired
    SyncUnitTypeCertificateMapper unitTypeCertificateMapper;
    @Autowired
    SyncUnitTypeQualificationMapper unitTypeQualificationMapper;
    @Autowired
    SyncWorkClassMapper workClassMapper;
    @Autowired
    SyncWorkItemMapper workItemMapper;
    
    @Override
    public List<SyncQualificationType> getSyncQualificationTypeList() {
        return qualificationTypeMapper.selectAll();
    }

    @Override
    public List<SyncWorkClass> getSyncWorkClassList() {
        return workClassMapper.selectAll();
    }

    @Override
    public List<SyncWorkItem> getSyncWorkItemList(Integer workClassCode) {
        return workItemMapper.selectByWorkClassCode(workClassCode);
    }

    @Override
    public SyncMajor selectByQualificationTypeCodeAndWorkClassCodeAndWorkItemCode(int qualificationTypeCode, int workClassCode, int workItemCode) {
        return majorMapper.selectByQualificationTypeCodeAndWorkClassCodeAndWorkItemCode(qualificationTypeCode,workClassCode,workItemCode);
    }

    @Override
    public List<SyncEvidenceType> getSyncEvidenceTypeList() {
        return evidenceTypeMapper.selectAll();
    }

    @Override
    public SyncMajor selectByQualificationTypeCodeAndEvidenceTypeCodeAndUnitTypeCode(int qualificationTypeCode,int evidenceTypeCode, int unitTypeCode) {
        return majorMapper.selectByQualificationTypeCodeAndEvidenceTypeCodeAndUnitTypeCode(qualificationTypeCode,evidenceTypeCode,unitTypeCode);
    }

    @Override
    public List<SyncUnitTypeQualification> getSyncUnitTypeQualificationList() {
        return unitTypeQualificationMapper.selectAll();
    }

    @Override
    public List<SyncUnitTypeCertificate> getSyncUnitTypeCertificateList() {
        return unitTypeCertificateMapper.selectAll();
    }
}

package com.hxminco.mock.comm.entry;

public class SyncMajor {
    private String id;

    private String parentId;

    private String majorId;

    private String name;

    private Integer qualificationTypeCode;

    private Integer evidenceTypeCode;

    private Integer unitTypeCode;

    private Integer workClassCode;

    private Integer workItemCode;

    private Integer paperSource;

    public SyncMajor(String id, String parentId, String majorId, String name, Integer qualificationTypeCode, Integer evidenceTypeCode, Integer unitTypeCode, Integer workClassCode, Integer workItemCode, Integer paperSource) {
        this.id = id;
        this.parentId = parentId;
        this.majorId = majorId;
        this.name = name;
        this.qualificationTypeCode = qualificationTypeCode;
        this.evidenceTypeCode = evidenceTypeCode;
        this.unitTypeCode = unitTypeCode;
        this.workClassCode = workClassCode;
        this.workItemCode = workItemCode;
        this.paperSource = paperSource;
    }

    public SyncMajor() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId == null ? null : majorId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getQualificationTypeCode() {
        return qualificationTypeCode;
    }

    public void setQualificationTypeCode(Integer qualificationTypeCode) {
        this.qualificationTypeCode = qualificationTypeCode;
    }

    public Integer getEvidenceTypeCode() {
        return evidenceTypeCode;
    }

    public void setEvidenceTypeCode(Integer evidenceTypeCode) {
        this.evidenceTypeCode = evidenceTypeCode;
    }

    public Integer getUnitTypeCode() {
        return unitTypeCode;
    }

    public void setUnitTypeCode(Integer unitTypeCode) {
        this.unitTypeCode = unitTypeCode;
    }

    public Integer getWorkClassCode() {
        return workClassCode;
    }

    public void setWorkClassCode(Integer workClassCode) {
        this.workClassCode = workClassCode;
    }

    public Integer getWorkItemCode() {
        return workItemCode;
    }

    public void setWorkItemCode(Integer workItemCode) {
        this.workItemCode = workItemCode;
    }

    public Integer getPaperSource() {
        return paperSource;
    }

    public void setPaperSource(Integer paperSource) {
        this.paperSource = paperSource;
    }
}
package com.hxminco.mock.comm.entry;

import java.util.Date;

public class SyncPaper {
    private String id;

    private String planId;

    private String planName;

    private String majorId;

    private Integer assessmentNature;

    private Integer duration;

    private Integer sumMark;

    private Integer passMark;

    private Integer status;

    private Date createDate;

    private Integer paperNums;

    public SyncPaper(String id, String planId, String planName, String majorId, Integer assessmentNature, Integer duration, Integer sumMark, Integer passMark, Integer status, Date createDate, Integer paperNums) {
        this.id = id;
        this.planId = planId;
        this.planName = planName;
        this.majorId = majorId;
        this.assessmentNature = assessmentNature;
        this.duration = duration;
        this.sumMark = sumMark;
        this.passMark = passMark;
        this.status = status;
        this.createDate = createDate;
        this.paperNums = paperNums;
    }

    public SyncPaper() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId == null ? null : planId.trim();
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName == null ? null : planName.trim();
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId == null ? null : majorId.trim();
    }

    public Integer getAssessmentNature() {
        return assessmentNature;
    }

    public void setAssessmentNature(Integer assessmentNature) {
        this.assessmentNature = assessmentNature;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getSumMark() {
        return sumMark;
    }

    public void setSumMark(Integer sumMark) {
        this.sumMark = sumMark;
    }

    public Integer getPassMark() {
        return passMark;
    }

    public void setPassMark(Integer passMark) {
        this.passMark = passMark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getPaperNums() {
        return paperNums;
    }

    public void setPaperNums(Integer paperNums) {
        this.paperNums = paperNums;
    }
}
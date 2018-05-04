package com.hxminco.mock.comm.entry;

import java.util.Date;

public class MockKnowledge {
    private String id;

    private Date createdTime;

    private String createdUser;

    private Date updatedTime;

    private String updatedUser;

    private Double version;

    private Boolean assessmentAgain;

    private Boolean assessmentChange;

    private Boolean assessmentFirst;

    private String majorId;

    private Integer sortIndex;

    private String title;

    public MockKnowledge(String id, Date createdTime, String createdUser, Date updatedTime, String updatedUser, Double version, Boolean assessmentAgain, Boolean assessmentChange, Boolean assessmentFirst, String majorId, Integer sortIndex, String title) {
        this.id = id;
        this.createdTime = createdTime;
        this.createdUser = createdUser;
        this.updatedTime = updatedTime;
        this.updatedUser = updatedUser;
        this.version = version;
        this.assessmentAgain = assessmentAgain;
        this.assessmentChange = assessmentChange;
        this.assessmentFirst = assessmentFirst;
        this.majorId = majorId;
        this.sortIndex = sortIndex;
        this.title = title;
    }

    public MockKnowledge() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser == null ? null : createdUser.trim();
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getUpdatedUser() {
        return updatedUser;
    }

    public void setUpdatedUser(String updatedUser) {
        this.updatedUser = updatedUser == null ? null : updatedUser.trim();
    }

    public Double getVersion() {
        return version;
    }

    public void setVersion(Double version) {
        this.version = version;
    }

    public Boolean getAssessmentAgain() {
        return assessmentAgain;
    }

    public void setAssessmentAgain(Boolean assessmentAgain) {
        this.assessmentAgain = assessmentAgain;
    }

    public Boolean getAssessmentChange() {
        return assessmentChange;
    }

    public void setAssessmentChange(Boolean assessmentChange) {
        this.assessmentChange = assessmentChange;
    }

    public Boolean getAssessmentFirst() {
        return assessmentFirst;
    }

    public void setAssessmentFirst(Boolean assessmentFirst) {
        this.assessmentFirst = assessmentFirst;
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId == null ? null : majorId.trim();
    }

    public Integer getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
}
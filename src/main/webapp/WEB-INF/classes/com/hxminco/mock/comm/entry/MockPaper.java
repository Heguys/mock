package com.hxminco.mock.comm.entry;

import java.util.Date;

public class MockPaper {
    private String id;

    private Date createdTime;

    private String createdUser;

    private Date updatedTime;

    private String updatedUser;

    private Double version;

    private Integer assessmentNature;

    private Integer duration;

    private String majorId;

    private Integer passmark;

    private Boolean randomOptionSort;

    private Boolean randomQuestionSort;
    /**
     * 试卷是否启用
     */
    private Integer status;

    private Integer summark;

    private String title;

    private MockMajor mockMajor;

    private Integer paperOrder;

    public MockPaper(String id, Date createdTime, String createdUser, Date updatedTime, String updatedUser, Double version, Integer assessmentNature, Integer duration, String majorId, Integer passmark, Boolean randomOptionSort, Boolean randomQuestionSort, Integer status, Integer summark, String title) {
        this.id = id;
        this.createdTime = createdTime;
        this.createdUser = createdUser;
        this.updatedTime = updatedTime;
        this.updatedUser = updatedUser;
        this.version = version;
        this.assessmentNature = assessmentNature;
        this.duration = duration;
        this.majorId = majorId;
        this.passmark = passmark;
        this.randomOptionSort = randomOptionSort;
        this.randomQuestionSort = randomQuestionSort;
        this.status = status;
        this.summark = summark;
        this.title = title;
    }

    public MockPaper() {
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

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId == null ? null : majorId.trim();
    }

    public Integer getPassmark() {
        return passmark;
    }

    public void setPassmark(Integer passmark) {
        this.passmark = passmark;
    }

    public Boolean getRandomOptionSort() {
        return randomOptionSort;
    }

    public void setRandomOptionSort(Boolean randomOptionSort) {
        this.randomOptionSort = randomOptionSort;
    }

    public Boolean getRandomQuestionSort() {
        return randomQuestionSort;
    }

    public void setRandomQuestionSort(Boolean randomQuestionSort) {
        this.randomQuestionSort = randomQuestionSort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSummark() {
        return summark;
    }

    public void setSummark(Integer summark) {
        this.summark = summark;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public MockMajor getMockMajor() {
        return mockMajor;
    }

    public void setMockMajor(MockMajor mockMajor) {
        this.mockMajor = mockMajor;
    }

    public Integer getPaperOrder() {
        return paperOrder;
    }

    public void setPaperOrder(Integer paperOrder) {
        this.paperOrder = paperOrder;
    }
}
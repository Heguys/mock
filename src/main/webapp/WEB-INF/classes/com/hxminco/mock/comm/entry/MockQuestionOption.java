package com.hxminco.mock.comm.entry;

import java.util.Date;

public class MockQuestionOption {
    private String id;

    private Date createdTime;

    private String createdUser;

    private Date updatedTime;

    private String updatedUser;

    private Double version;

    private String optionContent;

    private Boolean correct;

    private String questionId;

    private Integer sortIndex;

    public MockQuestionOption(String id, Date createdTime, String createdUser, Date updatedTime, String updatedUser, Double version, String optionContent, Boolean correct, String questionId, Integer sortIndex) {
        this.id = id;
        this.createdTime = createdTime;
        this.createdUser = createdUser;
        this.updatedTime = updatedTime;
        this.updatedUser = updatedUser;
        this.version = version;
        this.optionContent = optionContent;
        this.correct = correct;
        this.questionId = questionId;
        this.sortIndex = sortIndex;
    }

    public MockQuestionOption() {
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

    public String getOptionContent() {
        return optionContent;
    }

    public void setOptionContent(String optionContent) {
        this.optionContent = optionContent == null ? null : optionContent.trim();
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId == null ? null : questionId.trim();
    }

    public Integer getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }

    public void updateBaseInfo(String account) {
        Date now = new Date();
        if (createdUser == null || createdUser.equals("")) {
            createdUser = account;
        }
        if (createdTime == null) {
            createdTime = now;
        }
        updatedUser = account;
        updatedTime = now;
    }
}
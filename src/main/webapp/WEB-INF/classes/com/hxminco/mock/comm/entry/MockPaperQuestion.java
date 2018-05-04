package com.hxminco.mock.comm.entry;

import java.util.Date;

public class MockPaperQuestion {
    private String id;

    private Date createdTime;

    private String createdUser;

    private Date updatedTime;

    private String updatedUser;

    private Double version;

    private Double score;

    private Integer sortIndex;

    private String paperId;

    private String questionId;

    private MockQuestion mockQuestion;

    public MockPaperQuestion(String id, Date createdTime, String createdUser, Date updatedTime, String updatedUser, Double version, Double score, Integer sortIndex, String paperId, String questionId) {
        this.id = id;
        this.createdTime = createdTime;
        this.createdUser = createdUser;
        this.updatedTime = updatedTime;
        this.updatedUser = updatedUser;
        this.version = version;
        this.score = score;
        this.sortIndex = sortIndex;
        this.paperId = paperId;
        this.questionId = questionId;
    }

    public MockPaperQuestion() {
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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId == null ? null : paperId.trim();
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId == null ? null : questionId.trim();
    }

    public MockQuestion getMockQuestion() {
        return mockQuestion;
    }

    public void setMockQuestion(MockQuestion mockQuestion) {
        this.mockQuestion = mockQuestion;
    }
}
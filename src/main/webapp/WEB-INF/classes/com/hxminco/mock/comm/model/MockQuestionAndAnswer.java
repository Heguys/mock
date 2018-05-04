package com.hxminco.mock.comm.model;

import java.util.Date;

public class MockQuestionAndAnswer {
    private String id;

    private Date createdTime;

    private String createdUser;

    private Date updatedTime;

    private String updatedUser;

    private Double version;

    private Boolean assessmentAgain;

    private Boolean assessmentChange;

    private Boolean assessmentFirst;

    private String questionContent;

    private Integer difficulty;

    private Boolean judgeCorrect;

    private String knowledgeId;

    private String majorId;

    private Integer questionType;

    private Double score;

    private Integer source;

    private String answerId;

    private String optionContent;

    private Boolean correct;

    private Integer sortIndex;

    private  String paperId;

    private  Integer paperOrder;

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

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent == null ? null : questionContent.trim();
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public Boolean getJudgeCorrect() {
        return judgeCorrect;
    }

    public void setJudgeCorrect(String judgeCorrect) {
        if("对".equals(judgeCorrect)){
            this.judgeCorrect = true;
        }else{
            this.judgeCorrect = false;
        }

    }

    public String getKnowledgeId() {
        return knowledgeId;
    }

    public void setKnowledgeId(String knowledgeId) {
        this.knowledgeId = knowledgeId == null ? null : knowledgeId.trim();
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId == null ? null : majorId.trim();
    }

    public Integer getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }


    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

    public String getOptionContent() {
        return optionContent;
    }

    public void setOptionContent(String optionContent) {
        this.optionContent = optionContent;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
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
        this.paperId = paperId;
    }

    public void setJudgeCorrect(Boolean judgeCorrect) {
        this.judgeCorrect = judgeCorrect;
    }

    public Integer getPaperOrder() {
        return paperOrder;
    }

    public void setPaperOrder(Integer paperOrder) {
        this.paperOrder = paperOrder;
    }
}
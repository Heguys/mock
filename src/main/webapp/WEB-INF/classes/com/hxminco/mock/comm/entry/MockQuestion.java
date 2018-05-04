package com.hxminco.mock.comm.entry;

import com.hxminco.mock.comm.utils.MockConstants;

import java.util.Date;
import java.util.List;

public class MockQuestion {
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

    private List<MockQuestionOption> mockQuestionOptions;

    public MockQuestion(String id, Date createdTime, String createdUser, Date updatedTime, String updatedUser, Double version, Boolean assessmentAgain, Boolean assessmentChange, Boolean assessmentFirst, String questionContent, Integer difficulty, Boolean judgeCorrect, String knowledgeId, String majorId, Integer questionType, Double score, Integer source) {
        this.id = id;
        this.createdTime = createdTime;
        this.createdUser = createdUser;
        this.updatedTime = updatedTime;
        this.updatedUser = updatedUser;
        this.version = version;
        this.assessmentAgain = assessmentAgain;
        this.assessmentChange = assessmentChange;
        this.assessmentFirst = assessmentFirst;
        this.questionContent = questionContent;
        this.difficulty = difficulty;
        this.judgeCorrect = judgeCorrect;
        this.knowledgeId = knowledgeId;
        this.majorId = majorId;
        this.questionType = questionType;
        this.score = score;
        this.source = source;
    }

    public MockQuestion() {
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

    public void setJudgeCorrect(Boolean judgeCorrect) {
        this.judgeCorrect = judgeCorrect;
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

    public List<MockQuestionOption> getMockQuestionOptions() {
        return mockQuestionOptions;
    }

    public void setMockQuestionOptions(List<MockQuestionOption> mockQuestionOptions) {
        this.mockQuestionOptions = mockQuestionOptions;
    }

    /**
     * 单选题
     *
     * @return
     */
    public boolean isChoiceSingle() {
        return MockConstants.QUESTION_TYPE_CHOICE_SINGLE == getQuestionType();
    }

    /**
     * 多选题
     *
     * @return
     */
    public boolean isChoiceMulti() {
        return MockConstants.QUESTION_TYPE_CHOICE_MULTI == getQuestionType();
    }

    /**
     * 判断题
     *
     * @return
     */
    public boolean isChoiceJudge() {
        return MockConstants.QUESTION_TYPE_JUDGE == getQuestionType();
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
    /**
     * 正确答案
     *
     * @return
     */
}
package com.hxminco.mock.comm.entry;

import java.util.Date;

public class MockStudentAnswer {
    private String answerId;

    private String answer;

    private Date answerTime;

    private Boolean correct;

    private String examId;

    private Boolean judged;

    private String questionId;

    private Double score;

    public MockStudentAnswer(String answerId, String answer, Date answerTime, Boolean correct, String examId, Boolean judged, String questionId, Double score) {
        this.answerId = answerId;
        this.answer = answer;
        this.answerTime = answerTime;
        this.correct = correct;
        this.examId = examId;
        this.judged = judged;
        this.questionId = questionId;
        this.score = score;
    }

    public MockStudentAnswer() {
        super();
    }

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId == null ? null : answerId.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Date getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Date answerTime) {
        this.answerTime = answerTime;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId == null ? null : examId.trim();
    }

    public Boolean getJudged() {
        return judged;
    }

    public void setJudged(Boolean judged) {
        this.judged = judged;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId == null ? null : questionId.trim();
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
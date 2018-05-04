package com.hxminco.mock.comm.model;

import java.util.Date;

/**
 * Created by spiderman on 2017/12/26.
 */
public class ExamPageModel {

    private String examId;

    private String title;

    private Integer examStatus;

    private Date examDate;

    private Double examScore;

    private Integer timeLeft;

    public ExamPageModel(String examId, String title, Integer examStatus, Date examDate, Double examScore) {
        this.examId = examId;
        this.title = title;
        this.examStatus = examStatus;
        this.examDate = examDate;
        this.examScore = examScore;
    }

    public ExamPageModel() {
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getExamStatus() {
        return examStatus;
    }

    public void setExamStatus(Integer examStatus) {
        this.examStatus = examStatus;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public Double getExamScore() {
        return examScore;
    }

    public void setExamScore(Double examScore) {
        this.examScore = examScore;
    }

    public long getExamRemainMins(Integer duration) {
        Date now = new Date();
        long miniSeconds = getExamDate().getTime() + duration * 60000 - now.getTime();
        if(miniSeconds < 0){
            miniSeconds = 0;
        }
        return miniSeconds / 1000 / 60;
    }

    public Integer getTimeLeft() {
        if(examStatus == 2){
            timeLeft = (int)getExamRemainMins(120);
        }else{
            timeLeft = 0;
        }
        return timeLeft;
    }

}

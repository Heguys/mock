package com.hxminco.mock.comm.entry;

import com.hxminco.mock.comm.utils.MockConstants;

import java.util.Calendar;
import java.util.Date;

public class MockStudentExam {
    private String examId;

    private String account;

    private Date examDate;

    private Boolean examPassed;

    private Double examScore;

    private Integer examStatus;

    private Date firstExamDate;

    private Double maxScore;

    private String studentId;

    private String paperId;

    private Boolean deleted;

    private MockPaper mockPaper;

    public MockStudentExam(String examId, String account, Date examDate, Boolean examPassed, Double examScore, Integer examStatus, Date firstExamDate, Double maxScore, String studentId, String paperId, Boolean deleted) {
        this.examId = examId;
        this.account = account;
        this.examDate = examDate;
        this.examPassed = examPassed;
        this.examScore = examScore;
        this.examStatus = examStatus;
        this.firstExamDate = firstExamDate;
        this.maxScore = maxScore;
        this.studentId = studentId;
        this.paperId = paperId;
        this.deleted = deleted;
    }

    public MockStudentExam() {
        super();
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId == null ? null : examId.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public Boolean getExamPassed() {
        return examPassed;
    }

    public void setExamPassed(Boolean examPassed) {
        this.examPassed = examPassed;
    }

    public Double getExamScore() {
        return examScore;
    }

    public void setExamScore(Double examScore) {
        this.examScore = examScore;
    }

    public Integer getExamStatus() {
        return examStatus;
    }

    public void setExamStatus(Integer examStatus) {
        this.examStatus = examStatus;
    }

    public Date getFirstExamDate() {
        return firstExamDate;
    }

    public void setFirstExamDate(Date firstExamDate) {
        this.firstExamDate = firstExamDate;
    }

    public Double getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Double maxScore) {
        this.maxScore = maxScore;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId == null ? null : paperId.trim();
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Date getExamCommitTime() {
        Date commitTime = null;
        if (getExamDate() != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(getExamDate());
            calendar.add(Calendar.MINUTE, getMockPaper().getDuration());
            commitTime = calendar.getTime();
        }
        return commitTime;
    }

    public long getExamRemainSeconds() {
        Date now = new Date();
        long miniSeconds = getExamDate().getTime() + mockPaper.getDuration() * 60000 - now.getTime();
        if(miniSeconds < 0){
            return 0;
        }else{
            return miniSeconds / 1000;
        }
    }
    /**
     * 尚未开始
     *
     * @return
     */
    public boolean isExamStatusTodo() {
        return getExamStatus() == MockConstants.EXAM_STATUS_TODO;
    }

    /**
     * 考试中
     *
     * @return
     */
    public boolean isExamStatusDoing() {
        return getExamStatus() == MockConstants.EXAM_STATUS_DOING;
    }

    /**
     * 已经完成
     *
     * @return
     */
    public boolean isExamStatusCompleted() {
        return getExamStatus() == MockConstants.EXAM_STATUS_COMPLETED;
    }

    public MockPaper getMockPaper() {
        return mockPaper;
    }

    public void setMockPaper(MockPaper mockPaper) {
        this.mockPaper = mockPaper;
    }
}
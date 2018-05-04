package com.hxminco.mock.comm.entry;

import java.util.Date;

public class MockStudent {
    private String studentId;

    private String account;

    private Integer availableMocks;

    private Integer completedMocks;

    private Date createDate;

    private Date latestMockDate;

    private Date latestPurchaseDate;

    private Date latestVisitDate;

    private String name;

    private Integer totalMocks;

    public MockStudent(String studentId, String account, Integer availableMocks, Integer completedMocks, Date createDate, Date latestMockDate, Date latestPurchaseDate, Date latestVisitDate, String name, Integer totalMocks) {
        this.studentId = studentId;
        this.account = account;
        this.availableMocks = availableMocks;
        this.completedMocks = completedMocks;
        this.createDate = createDate;
        this.latestMockDate = latestMockDate;
        this.latestPurchaseDate = latestPurchaseDate;
        this.latestVisitDate = latestVisitDate;
        this.name = name;
        this.totalMocks = totalMocks;
    }

    public MockStudent() {
        super();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public Integer getAvailableMocks() {
        return availableMocks;
    }

    public void setAvailableMocks(Integer availableMocks) {
        this.availableMocks = availableMocks;
    }

    public Integer getCompletedMocks() {
        return completedMocks;
    }

    public void setCompletedMocks(Integer completedMocks) {
        this.completedMocks = completedMocks;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLatestMockDate() {
        return latestMockDate;
    }

    public void setLatestMockDate(Date latestMockDate) {
        this.latestMockDate = latestMockDate;
    }

    public Date getLatestPurchaseDate() {
        return latestPurchaseDate;
    }

    public void setLatestPurchaseDate(Date latestPurchaseDate) {
        this.latestPurchaseDate = latestPurchaseDate;
    }

    public Date getLatestVisitDate() {
        return latestVisitDate;
    }

    public void setLatestVisitDate(Date latestVisitDate) {
        this.latestVisitDate = latestVisitDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getTotalMocks() {
        return totalMocks;
    }

    public void setTotalMocks(Integer totalMocks) {
        this.totalMocks = totalMocks;
    }
}
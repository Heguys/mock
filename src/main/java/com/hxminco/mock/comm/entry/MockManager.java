package com.hxminco.mock.comm.entry;

import java.util.Date;

public class MockManager {
    private String managerId;

    private String account;

    private Date createDate;

    private Date latestVisitDate;

    private String name;

    private Boolean superAdmin;

    private Boolean unitAdmin;

    private String unitUid;

    public MockManager(String managerId, String account, Date createDate, Date latestVisitDate, String name, Boolean superAdmin, Boolean unitAdmin, String unitUid) {
        this.managerId = managerId;
        this.account = account;
        this.createDate = createDate;
        this.latestVisitDate = latestVisitDate;
        this.name = name;
        this.superAdmin = superAdmin;
        this.unitAdmin = unitAdmin;
        this.unitUid = unitUid;
    }

    public MockManager() {
        super();
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId == null ? null : managerId.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public Boolean getSuperAdmin() {
        return superAdmin;
    }

    public void setSuperAdmin(Boolean superAdmin) {
        this.superAdmin = superAdmin;
    }

    public Boolean getUnitAdmin() {
        return unitAdmin;
    }

    public void setUnitAdmin(Boolean unitAdmin) {
        this.unitAdmin = unitAdmin;
    }

    public String getUnitUid() {
        return unitUid;
    }

    public void setUnitUid(String unitUid) {
        this.unitUid = unitUid == null ? null : unitUid.trim();
    }


}
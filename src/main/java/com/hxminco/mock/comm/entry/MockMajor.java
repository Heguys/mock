package com.hxminco.mock.comm.entry;

import java.util.Date;

public class MockMajor {
    private String id;

    private Date createdTime;

    private String createdUser;

    private Date updatedTime;

    private String updatedUser;

    private Double version;

    private Integer assignCode1;

    private Integer assignCode2;

    private Integer assignCode3;

    private String childrenLabel;

    private Boolean globalMajor;

    private String majorId;

    private String name;

    private String parentMajorId;

    private Integer sort;

    private String majorIdPath;

    public MockMajor(String id, Date createdTime, String createdUser, Date updatedTime, String updatedUser, Double version, Integer assignCode1, Integer assignCode2, Integer assignCode3, String childrenLabel, Boolean globalMajor, String majorId, String name, String parentMajorId, Integer sort, String majorIdPath) {
        this.id = id;
        this.createdTime = createdTime;
        this.createdUser = createdUser;
        this.updatedTime = updatedTime;
        this.updatedUser = updatedUser;
        this.version = version;
        this.assignCode1 = assignCode1;
        this.assignCode2 = assignCode2;
        this.assignCode3 = assignCode3;
        this.childrenLabel = childrenLabel;
        this.globalMajor = globalMajor;
        this.majorId = majorId;
        this.name = name;
        this.parentMajorId = parentMajorId;
        this.sort = sort;
        this.majorIdPath = majorIdPath;
    }

    public MockMajor() {
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

    public Integer getAssignCode1() {
        return assignCode1;
    }

    public void setAssignCode1(Integer assignCode1) {
        this.assignCode1 = assignCode1;
    }

    public Integer getAssignCode2() {
        return assignCode2;
    }

    public void setAssignCode2(Integer assignCode2) {
        this.assignCode2 = assignCode2;
    }

    public Integer getAssignCode3() {
        return assignCode3;
    }

    public void setAssignCode3(Integer assignCode3) {
        this.assignCode3 = assignCode3;
    }

    public String getChildrenLabel() {
        return childrenLabel;
    }

    public void setChildrenLabel(String childrenLabel) {
        this.childrenLabel = childrenLabel == null ? null : childrenLabel.trim();
    }

    public Boolean getGlobalMajor() {
        return globalMajor;
    }

    public void setGlobalMajor(Boolean globalMajor) {
        this.globalMajor = globalMajor;
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId == null ? null : majorId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getParentMajorId() {
        return parentMajorId;
    }

    public void setParentMajorId(String parentMajorId) {
        this.parentMajorId = parentMajorId == null ? null : parentMajorId.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getMajorIdPath() {
        return majorIdPath;
    }

    public void setMajorIdPath(String majorIdPath) {
        this.majorIdPath = majorIdPath == null ? null : majorIdPath.trim();
    }
}
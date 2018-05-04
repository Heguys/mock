package com.hxminco.mock.comm.entry;

public class SyncMajorBase {
    private Integer id;

    private String parentId;

    private String majorId;

    private String name;

    public SyncMajorBase(Integer id, String parentId, String majorId, String name) {
        this.id = id;
        this.parentId = parentId;
        this.majorId = majorId;
        this.name = name;
    }

    public SyncMajorBase() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
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
}
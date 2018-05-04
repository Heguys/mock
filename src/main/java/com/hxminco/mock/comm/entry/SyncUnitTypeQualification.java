package com.hxminco.mock.comm.entry;

public class SyncUnitTypeQualification {
    private Integer code;

    private String name;

    public SyncUnitTypeQualification(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public SyncUnitTypeQualification() {
        super();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}
package com.hxminco.mock.comm.entry;

public class SyncUnitTypeCertificate {
    private Integer code;

    private String name;

    public SyncUnitTypeCertificate(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public SyncUnitTypeCertificate() {
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
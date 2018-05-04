package com.hxminco.mock.comm.entry;

public class SyncWorkItem {
    private Integer code;

    private String name;

    private Integer workClassCode;

    public SyncWorkItem(Integer code, String name, Integer workClassCode) {
        this.code = code;
        this.name = name;
        this.workClassCode = workClassCode;
    }

    public SyncWorkItem() {
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

    public Integer getWorkClassCode() {
        return workClassCode;
    }

    public void setWorkClassCode(Integer workClassCode) {
        this.workClassCode = workClassCode;
    }
}
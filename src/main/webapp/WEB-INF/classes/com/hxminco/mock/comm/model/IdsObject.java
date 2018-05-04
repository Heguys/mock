package com.hxminco.mock.comm.model;

import java.util.List;

public class IdsObject {
    private List<String> ids;

    public IdsObject() {
    }

    public IdsObject(List<String> ids) {
        this.ids = ids;
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }
}

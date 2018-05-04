package com.hxminco.mock.ioc.s;

import com.hxminco.mock.comm.entry.MockStudent;
import com.hxminco.mock.comm.model.PageModel;

import java.util.Map;

/**
 * Created by spiderman on 2017/12/22.
 */
public interface IMockStudentService {
    MockStudent updateMockStudent(String s, String account, String name);

    void updateByPrimaryKeySelective(MockStudent student);

    MockStudent selectByPrimaryKey(String studentId);

    PageModel<MockStudent> selectByParams4Page(Map<String, Object> params);
}

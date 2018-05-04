package com.hxminco.mock.ioc.s.impl;

import com.hxminco.mock.comm.entry.MockStudent;
import com.hxminco.mock.comm.model.ExamPageModel;
import com.hxminco.mock.comm.model.PageModel;
import com.hxminco.mock.comm.utils.StringUtil;
import com.hxminco.mock.ioc.d.MockStudentMapper;
import com.hxminco.mock.ioc.s.IMockStudentService;
import net.bnusei.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by spiderman on 2017/12/22.
 */
@Service("mockStudentService")
public class MockStudentService implements IMockStudentService {
    @Autowired
    MockStudentMapper studentMapper;

    @Override
    public MockStudent selectByPrimaryKey(String studentId) {
        MockStudent student = studentMapper.selectByPrimaryKey(studentId);
        return student;
    }

    @Override
    public PageModel<MockStudent> selectByParams4Page(Map<String, Object> params) {
        List<MockStudent> mockStudents = studentMapper.selectByParams4Page(params);
        int count = studentMapper.selectCountByParam4Page(params);
        PageModel<MockStudent> pageModel = new PageModel<>();
        pageModel.setRows(mockStudents);
        pageModel.setTotal(Long.valueOf(count));
        return pageModel;
    }

    @Override
    public void updateByPrimaryKeySelective(MockStudent student) {
        studentMapper.updateByPrimaryKeySelective(student);
    }

    @Override
    public MockStudent updateMockStudent(String studentId, String account, String name) {
            MockStudent mockStudent = null;
            if (Validator.isNotNull(studentId)) {
                mockStudent = studentMapper.selectByPrimaryKey(studentId);
            }
            if (mockStudent == null && Validator.isNotNull(account)) {
                mockStudent = studentMapper.selectByAccount(account);
            }
            Date now = new Date();
            if (mockStudent == null && Validator.isNotNull(account)) {
                mockStudent = new MockStudent();
                mockStudent.setCreateDate(now);
            }
            if (mockStudent != null && Validator.isNotNull(account)) {
                mockStudent.setAccount(account);
            }
            mockStudent.setLatestVisitDate(now);
            mockStudent.setName(name);

            if(Validator.isNotNull(mockStudent.getStudentId())){
                studentMapper.updateByPrimaryKeySelective(mockStudent);
            }else{
                mockStudent.setStudentId(StringUtil.getUUID());
                studentMapper.insertSelective(mockStudent);
            }
            return mockStudent;
    }
}

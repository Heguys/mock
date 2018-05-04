package com.hxminco.mock.ioc.d;

import com.hxminco.mock.comm.entry.MockPaper;
import com.hxminco.mock.comm.entry.MockStudent;

import java.util.List;
import java.util.Map;

public interface MockStudentMapper {
    int deleteByPrimaryKey(String studentId);

    int insert(MockStudent record);

    int insertSelective(MockStudent record);

    MockStudent selectByPrimaryKey(String studentId);

    int updateByPrimaryKeySelective(MockStudent record);

    int updateByPrimaryKey(MockStudent record);

    List<MockPaper> selectByMajorAndAssessmentNatureDoing(Map<String, Object> params);

    List<MockPaper> selectMajorAndAssessmentNatureUnexamedPaper(Map<String, Object> params);

    MockStudent selectByAccount(String account);

    List<MockStudent> selectByParams4Page(Map<String, Object> params);

    int selectCountByParam4Page(Map<String, Object> params);
}
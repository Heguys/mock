package com.hxminco.mock.ioc.d;

import com.hxminco.mock.comm.entry.MockStudentExam;
import com.hxminco.mock.comm.model.ExamPageModel;

import java.util.List;
import java.util.Map;

public interface MockStudentExamMapper {
    int deleteByPrimaryKey(String examId);

    int insert(MockStudentExam record);

    int insertSelective(MockStudentExam record);

    MockStudentExam selectByPrimaryKey(String examId);

    int updateByPrimaryKeySelective(MockStudentExam record);

    int updateByPrimaryKey(MockStudentExam record);

    MockStudentExam selectByStudentIdAndPaperIdDoing(Map<String, Object> params);

    List<ExamPageModel> selectExamPageModelListByStudentId4Page(Map<String, Object> params);

    int selectCountByStudentId4Page(Map<String, Object> params);

    List<MockStudentExam> selectByExamDoing4Page(Map<String, Object> params);
}
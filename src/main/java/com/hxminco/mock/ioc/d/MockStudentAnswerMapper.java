package com.hxminco.mock.ioc.d;

import com.hxminco.mock.comm.entry.MockQuestion;
import com.hxminco.mock.comm.entry.MockStudentAnswer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MockStudentAnswerMapper {
    int deleteByPrimaryKey(String answerId);

    int insert(MockStudentAnswer record);

    int insertSelective(MockStudentAnswer record);

    MockStudentAnswer selectByPrimaryKey(String answerId);

    int updateByPrimaryKeySelective(MockStudentAnswer record);

    int updateByPrimaryKey(MockStudentAnswer record);

    List<MockStudentAnswer> selectListByExamId(String examId);

    MockStudentAnswer selectByExamIdAndQuestionId(@Param("examId") String examId, @Param("questionId") String questionId);

    MockQuestion selectByQuestionId(String questionId);

    Double selectCountScoreByExamId(String examId);
}
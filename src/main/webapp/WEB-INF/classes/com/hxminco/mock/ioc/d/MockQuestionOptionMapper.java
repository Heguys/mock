package com.hxminco.mock.ioc.d;

import com.hxminco.mock.comm.entry.MockQuestion;
import com.hxminco.mock.comm.entry.MockQuestionOption;

import java.util.List;
import java.util.Map;

public interface MockQuestionOptionMapper {
    int deleteByPrimaryKey(String id);

    int insert(MockQuestionOption record);

    int insertSelective(MockQuestionOption record);

    MockQuestionOption selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MockQuestionOption record);

    int updateByPrimaryKey(MockQuestionOption record);

    List<MockQuestionOption> selectCorrectListByQuestionId(String questionId);

    void insertMockQuestionOptionList(Map<String, Object> questionOptionMap);

    void deleteByQuestions(List<MockQuestion> list);
}
package com.hxminco.mock.ioc.d;

import com.hxminco.mock.comm.entry.MockPaperQuestion;
import com.hxminco.mock.comm.entry.MockQuestion;

import java.util.List;
import java.util.Map;

public interface MockQuestionMapper {
    int deleteByPrimaryKey(String id);

    int insert(MockQuestion record);

    int insertSelective(MockQuestion record);

    MockQuestion selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MockQuestion record);

    int updateByPrimaryKey(MockQuestion record);

    void insertMockQuestionList(Map<String, Object> questionMap);

    List<MockQuestion> selectListByPaperQuestions(List<MockPaperQuestion> list);

    void deleteByPaperQuestions(List<MockPaperQuestion> list);
}
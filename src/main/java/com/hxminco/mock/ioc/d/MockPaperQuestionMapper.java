package com.hxminco.mock.ioc.d;

import com.hxminco.mock.comm.entry.MockPaperQuestion;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MockPaperQuestionMapper {
    int deleteByPrimaryKey(String id);

    int insert(MockPaperQuestion record);

    int insertSelective(MockPaperQuestion record);

    MockPaperQuestion selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MockPaperQuestion record);

    int updateByPrimaryKey(MockPaperQuestion record);

    List<MockPaperQuestion> selectListByPaperId(String paperId);

    MockPaperQuestion selectByPaperIdAndQuestionId(@Param("paperId") String paperId, @Param("questionId") String questionId);

    void insertMockPaperQuestionList(Map<String, Object> paperQuestionMap);

    void deleteByPaperId(String paperId);
}
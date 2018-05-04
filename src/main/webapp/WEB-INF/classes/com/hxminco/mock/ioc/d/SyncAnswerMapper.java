package com.hxminco.mock.ioc.d;

import com.hxminco.mock.comm.entry.SyncAnswer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SyncAnswerMapper {
    int deleteByPrimaryKey(String id);

    int insert(SyncAnswer record);

    int insertSelective(SyncAnswer record);

    SyncAnswer selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SyncAnswer record);

    int updateByPrimaryKey(SyncAnswer record);

    List<SyncAnswer> selectByQuestionIdAndIsValid(@Param("questionId") String questionId, @Param("isValid") boolean isValid);

    List<SyncAnswer> selectByQuestionId(String questionId);
}
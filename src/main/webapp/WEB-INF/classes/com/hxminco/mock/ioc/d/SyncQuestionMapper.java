package com.hxminco.mock.ioc.d;

import com.hxminco.mock.comm.entry.SyncQuestion;
import com.hxminco.mock.comm.model.MockQuestionAndAnswer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SyncQuestionMapper {
    int deleteByPrimaryKey(String id);

    int insert(SyncQuestion record);

    int insertSelective(SyncQuestion record);

    SyncQuestion selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SyncQuestion record);

    int updateByPrimaryKey(SyncQuestion record);

    List<SyncQuestion> selectByPaperIdAndPaperOrder(@Param("paperId") String paperId, @Param("paperOrder") int paperOrder);

    List<MockQuestionAndAnswer> selectQuestionListByPaperId(@Param("paperId") String paperId, @Param("paperOrder") Integer paperOrder);
}
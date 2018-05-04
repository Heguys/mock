package com.hxminco.mock.ioc.d;

import com.hxminco.mock.comm.entry.MockKnowledge;

public interface MockKnowledgeMapper {
    int deleteByPrimaryKey(String id);

    int insert(MockKnowledge record);

    int insertSelective(MockKnowledge record);

    MockKnowledge selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MockKnowledge record);

    int updateByPrimaryKey(MockKnowledge record);
}
package com.hxminco.mock.ioc.d;

import com.hxminco.mock.comm.entry.MockPaper;

import java.util.List;
import java.util.Map;

public interface MockPaperMapper {
    int deleteByPrimaryKey(String id);

    int insert(MockPaper record);

    int insertSelective(MockPaper record);

    MockPaper selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MockPaper record);

    int updateByPrimaryKey(MockPaper record);

    List<MockPaper> selectByMajorAndAssessmentNatureDoing(Map<String, Object> params);

    List<MockPaper> selectMajorAndAssessmentNatureUnexamedPaper(Map<String, Object> params);

    int insertMockPaperList(Map<String, Object> paperMap);

    List<MockPaper> selectByParams4Page(Map<String, Object> params);

    int selectCountByParam4Page(Map<String, Object> params);
}
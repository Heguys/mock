package com.hxminco.mock.ioc.s;

import com.hxminco.mock.comm.entry.MockPaper;
import com.hxminco.mock.comm.entry.MockPaperQuestion;
import com.hxminco.mock.comm.entry.MockQuestion;
import com.hxminco.mock.comm.entry.MockQuestionOption;
import java.util.List;
import java.util.Map;

/**
 * Created by Employee on 2017/8/11.
 */
public interface ISyncQuestion2MockQuestionService {
    int insertMockPaperList(List<MockPaper> lstPaper);

    void insertMockQuestionList(List<MockQuestion> lstQuestion);

    void insertMockPaperQuestionList(List<MockPaperQuestion> lstPaperQuestion);

    void insertMockQuestionOptionList(List<MockQuestionOption> lstAnswer);

    public int insertAllPaper(Map<String, Object> mpPaper);
}

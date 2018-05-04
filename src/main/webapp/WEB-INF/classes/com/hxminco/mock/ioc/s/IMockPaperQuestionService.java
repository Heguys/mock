package com.hxminco.mock.ioc.s;

import com.hxminco.mock.comm.entry.MockPaperQuestion;
import com.hxminco.mock.comm.entry.MockQuestion;

import java.util.List;

/**
 * Created by spiderman on 2017/12/22.
 */
public interface IMockPaperQuestionService {

    List<MockPaperQuestion> selectListByPaperId(String paperId);

    void updateMockPaperQuestion(String blank, String paperId, String questionId, double score, Integer sort);
}

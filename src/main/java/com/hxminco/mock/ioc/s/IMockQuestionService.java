package com.hxminco.mock.ioc.s;

import com.hxminco.mock.comm.entry.MockQuestion;

import java.util.List;

/**
 * Created by spiderman on 2017/12/22.
 */
public interface IMockQuestionService {
    MockQuestion updateMockQuestion(String account, String questionId, String majorId, String knowledgeId, String content, int questionType, int difficulty, double score, int source, boolean judgeCorrect, boolean assessmentFirst, boolean assessmentAgain, boolean assessmentChange);
}

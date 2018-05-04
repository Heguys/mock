package com.hxminco.mock.ioc.s.impl;

import com.hxminco.mock.comm.entry.MockQuestion;
import com.hxminco.mock.comm.utils.StringUtil;
import com.hxminco.mock.comm.utils.Validator;
import com.hxminco.mock.ioc.d.MockQuestionMapper;
import com.hxminco.mock.ioc.s.IMockQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by spiderman on 2017/12/22.
 */
@Service
public class MockQuestionService implements IMockQuestionService {
    @Autowired
    MockQuestionMapper questionMapper;

    @Override
    public MockQuestion updateMockQuestion(String account, String questionId, String majorId, String knowledgeId, String content, int questionType, int difficulty, double score, int source, boolean judgeCorrect, boolean assessmentFirst, boolean assessmentAgain, boolean assessmentChange) {
        MockQuestion mockQuestion = null;
        if (Validator.isNotNull(questionId)) {
            mockQuestion = questionMapper.selectByPrimaryKey(questionId);
        }
        if (mockQuestion == null) {
            mockQuestion = new MockQuestion();
        }
        mockQuestion.updateBaseInfo(account);
        mockQuestion.setMajorId(majorId);
        mockQuestion.setKnowledgeId(knowledgeId);
        mockQuestion.setQuestionContent(content);
        mockQuestion.setQuestionType(questionType);
        mockQuestion.setDifficulty(difficulty);
        mockQuestion.setScore(score);
        mockQuestion.setSource(source);
        mockQuestion.setJudgeCorrect(judgeCorrect);
        mockQuestion.setAssessmentFirst(assessmentFirst);
        mockQuestion.setAssessmentAgain(assessmentAgain);
        mockQuestion.setAssessmentChange(assessmentChange);
        if(Validator.isNotNull(mockQuestion.getId())){
            questionMapper.updateByPrimaryKeySelective(mockQuestion);
        }else {
            mockQuestion.setId(StringUtil.getUUID());
            questionMapper.insertSelective(mockQuestion);
        }

        return mockQuestion;
    }
}

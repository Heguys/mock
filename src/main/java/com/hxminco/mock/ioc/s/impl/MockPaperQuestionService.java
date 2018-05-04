package com.hxminco.mock.ioc.s.impl;

import com.hxminco.mock.comm.entry.MockPaper;
import com.hxminco.mock.comm.entry.MockPaperQuestion;
import com.hxminco.mock.comm.entry.MockQuestion;
import com.hxminco.mock.comm.utils.StringUtil;
import com.hxminco.mock.ioc.d.MockPaperMapper;
import com.hxminco.mock.ioc.d.MockPaperQuestionMapper;
import com.hxminco.mock.ioc.d.MockQuestionMapper;
import com.hxminco.mock.ioc.s.IMockPaperQuestionService;
import net.bnusei.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by spiderman on 2017/12/22.
 */
@Service
public class MockPaperQuestionService implements IMockPaperQuestionService {
    @Autowired
    MockPaperQuestionMapper paperQuestionMapper;
    @Autowired
    MockPaperMapper paperMapper;
    @Autowired
    MockQuestionMapper questionMapper;

    @Override
    public List<MockPaperQuestion> selectListByPaperId(String paperId) {
        List<MockPaperQuestion> paperQuestions = paperQuestionMapper.selectListByPaperId(paperId);
        return paperQuestions;
    }

    @Override
    public void updateMockPaperQuestion(String paperQuestionId, String paperId, String questionId, double score, Integer sortIndex) {
        MockPaperQuestion mockPaperQuestion = null;
        if (Validator.isNotNull(paperQuestionId)) {
            mockPaperQuestion = paperQuestionMapper.selectByPrimaryKey(paperQuestionId);
        }
        if (mockPaperQuestion == null && Validator.isNotNull(paperId) && Validator.isNotNull(questionId)) {
            mockPaperQuestion = paperQuestionMapper.selectByPaperIdAndQuestionId(paperId,questionId);
            if (mockPaperQuestion == null) {
                mockPaperQuestion = new MockPaperQuestion();
                mockPaperQuestion.setQuestionId(questionId);
                mockPaperQuestion.setPaperId(paperId);
            }
        }
        if (mockPaperQuestion != null) {
            mockPaperQuestion.setScore(score);
            mockPaperQuestion.setSortIndex(sortIndex);
            if(Validator.isNotNull(mockPaperQuestion.getId())) {
                paperQuestionMapper.updateByPrimaryKeySelective(mockPaperQuestion);
            }else{
                mockPaperQuestion.setId(StringUtil.getUUID());
                paperQuestionMapper.insertSelective(mockPaperQuestion);
            }
        }
    }
}

package com.hxminco.mock.ioc.s.impl;

import com.hxminco.mock.comm.entry.MockQuestion;
import com.hxminco.mock.comm.entry.MockQuestionOption;
import com.hxminco.mock.comm.entry.MockStudentAnswer;
import com.hxminco.mock.comm.entry.MockStudentExam;
import com.hxminco.mock.comm.utils.StringUtil;
import com.hxminco.mock.ioc.d.MockQuestionMapper;
import com.hxminco.mock.ioc.d.MockQuestionOptionMapper;
import com.hxminco.mock.ioc.d.MockStudentAnswerMapper;
import com.hxminco.mock.ioc.s.IMockStudentAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by spiderman on 2017/12/22.
 */
@Service
public class MockStudentAnswerService implements IMockStudentAnswerService {
    @Autowired
    MockStudentAnswerMapper studentAnswerMapper;
    @Autowired
    MockQuestionOptionMapper questionOptionMapper;
    @Autowired
    MockQuestionMapper questionMapper;

    @Override
    public void updateMockStudentAnswer(MockStudentExam studentExam, String questionId, String answer) {
        MockStudentAnswer studentAnswer = null;
        if (studentExam != null) {
            String examId = studentExam.getExamId();
            studentAnswer = studentAnswerMapper.selectByExamIdAndQuestionId(examId, questionId);
            if (studentExam.isExamStatusTodo() || studentExam.isExamStatusDoing()) { // 还未交卷的试卷才能更新答案
                // 第一次选择答案时，初始化一个答案对象，设置默认值
                if (studentAnswer == null) {
                    studentAnswer = new MockStudentAnswer();
                    studentAnswer.setExamId(examId);
                    studentAnswer.setQuestionId(questionId);
                    studentAnswer.setAnswerTime(new Date());

                    studentAnswer.setCorrect(false);
                    studentAnswer.setJudged(false);
                }

                if (!studentAnswer.getJudged()) {
                    studentAnswer.setAnswer(answer);
                }
                studentAnswer.setAnswer(answer);
                judgeMockStudentAnswer(studentExam, studentAnswer);
                if(null == (studentAnswer.getAnswerId())){
                    studentAnswer.setAnswerId(StringUtil.getUUID());
                    studentAnswerMapper.insertSelective(studentAnswer);
                }else {
                    studentAnswerMapper.updateByPrimaryKeySelective(studentAnswer);
                }
            }
        }
    }

    @Override
    public List<MockStudentAnswer> selectListByExamId(String examId) {
        List<MockStudentAnswer> studentAnswers = studentAnswerMapper.selectListByExamId(examId);
        return studentAnswers;
    }

    public void judgeMockStudentAnswer(MockStudentExam studentExam, MockStudentAnswer studentAnswer) {
        if (studentExam.isExamStatusTodo() || studentExam.isExamStatusDoing()) {
            if (studentAnswer != null) {
                MockQuestion mockQuestion = questionMapper.selectByPrimaryKey(studentAnswer.getQuestionId());
                if (mockQuestion != null) {
                    String questionId = mockQuestion.getId();
                    boolean correct = false;
                    List<MockQuestionOption> optionList = questionOptionMapper.selectCorrectListByQuestionId(questionId);
                    if (mockQuestion.isChoiceJudge()) {
                        if (mockQuestion.getJudgeCorrect().booleanValue() == Boolean.valueOf(studentAnswer.getAnswer()).booleanValue()) {
                            // 判断题回答正确
                            correct = true;
                        }
                    } else if (mockQuestion.isChoiceSingle()) {
                        if (optionList.size() == 1 && optionList.get(0).getId().equals(studentAnswer.getAnswer())) {
                            // 单选题回答正确
                            correct = true;
                        }
                    } else if (mockQuestion.isChoiceMulti()) {
                        String[] split = studentAnswer.getAnswer().split(",");
                        List<String> answers = Arrays.asList(split);
                        if (optionList.size() == answers.size()) {
                            correct = true;
                            for (MockQuestionOption option : optionList) {
                                if (answers.contains(option.getId())) {
                                    correct = false;
                                }
                            }
                        }
                    }
                    studentAnswer.setCorrect(correct);
                    if (correct) {
                        studentAnswer.setScore(mockQuestion.getScore());
                    }else {
                        studentAnswer.setScore(0.0);
                    }
                    studentAnswer.setJudged(true);
                }
            }
        }
    }
}

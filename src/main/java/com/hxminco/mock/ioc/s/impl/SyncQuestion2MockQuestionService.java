package com.hxminco.mock.ioc.s.impl;

import com.hxminco.mock.comm.entry.MockPaper;
import com.hxminco.mock.comm.entry.MockPaperQuestion;
import com.hxminco.mock.comm.entry.MockQuestion;
import com.hxminco.mock.comm.entry.MockQuestionOption;
import com.hxminco.mock.comm.utils.StringUtil;
import com.hxminco.mock.ioc.d.MockPaperMapper;
import com.hxminco.mock.ioc.d.MockPaperQuestionMapper;
import com.hxminco.mock.ioc.d.MockQuestionMapper;
import com.hxminco.mock.ioc.d.MockQuestionOptionMapper;
import com.hxminco.mock.ioc.s.ISyncQuestion2MockQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Employee on 2017/8/11.
 */
@Service
public class SyncQuestion2MockQuestionService implements ISyncQuestion2MockQuestionService {
    @Autowired
    private MockPaperMapper mockPaperMapper;
    @Autowired
    private MockPaperQuestionMapper mockPaperQuestionMapper;
    @Autowired
    private MockQuestionMapper mockQuestionMapper;
    @Autowired
    private MockQuestionOptionMapper mockQuestionOptionMapper;;

    @Override
    public int insertMockPaperList(List<MockPaper> lstPaper) {
        int sum = 0;
        List<List<MockPaper>>  lstList = new ArrayList<>();
        StringUtil.splitListTo(lstPaper, lstList, 100);
        Map<String ,Object> paperMap = new HashMap<>();
        for( List<MockPaper> one:lstList){
            paperMap.put("paper",lstPaper);
            int count = mockPaperMapper.insertMockPaperList(paperMap);
            sum = sum + count;
        }
        return sum;
    }

    @Override
    public void insertMockQuestionList(List<MockQuestion> lstQuestion) {
        List<List<MockQuestion>>  lstList = new ArrayList<>();
        StringUtil.splitListTo(lstQuestion, lstList, 100);
        Map<String ,Object> questionMap = new HashMap<>();
        for( List<MockQuestion> one:lstList) {
            questionMap.put("question", one);
            mockQuestionMapper.insertMockQuestionList(questionMap);
        }
    }

    @Override
    public void insertMockPaperQuestionList(List<MockPaperQuestion> lstPaperQuestion) {

        List<List<MockPaperQuestion>>  lstList = new ArrayList<>();
        StringUtil.splitListTo(lstPaperQuestion, lstList, 100);
        Map<String ,Object> paperQuestionMap = new HashMap<>();
        for( List<MockPaperQuestion> one:lstList){
            paperQuestionMap.put("paperQuestion",one);
            mockPaperQuestionMapper.insertMockPaperQuestionList(paperQuestionMap);
        }
    }

    @Override
    public void insertMockQuestionOptionList(List<MockQuestionOption> lstAnswer) {
        List<List<MockQuestionOption>>  lstList = new ArrayList<>();
        StringUtil.splitListTo(lstAnswer, lstList, 100);

        Map<String ,Object> QuestionOptionMap = new HashMap<>();
        for( List<MockQuestionOption> one:lstList){
            QuestionOptionMap.put("questionOption",one);
            mockQuestionOptionMapper.insertMockQuestionOptionList(QuestionOptionMap);
        }
    }

    @Override
    public int insertAllPaper(Map<String, Object> mpPaper) {
        if(mpPaper == null){
            return 0;
        }
        int count = insertMockPaperList((List)mpPaper.get("MockPaper"));
        insertMockQuestionList((List) mpPaper.get("MockQuestion"));
        insertMockQuestionOptionList((List)mpPaper.get("MockQuestionOption"));
        insertMockPaperQuestionList((List)mpPaper.get("MockPaperQuestion"));
        return count;
    }




}

package com.hxminco.mock.ioc.s.impl;

import com.hxminco.mock.comm.entry.MockPaper;
import com.hxminco.mock.comm.entry.SyncAnswer;
import com.hxminco.mock.comm.entry.SyncPaper;
import com.hxminco.mock.comm.entry.SyncQuestion;
import com.hxminco.mock.comm.model.MockQuestionAndAnswer;
import com.hxminco.mock.ioc.d.SyncAnswerMapper;
import com.hxminco.mock.ioc.d.SyncPaperMapper;
import com.hxminco.mock.ioc.d.SyncQuestionMapper;
import com.hxminco.mock.ioc.s.ISyncPaperService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by spiderman on 2018/1/12.
 */
@Service
public class SyncPaperService implements ISyncPaperService {

    @Autowired
    SyncPaperMapper syncPaperMapper;
    @Autowired
    SyncQuestionMapper syncQuestionMapper;
    @Autowired
    SyncAnswerMapper syncAnswerMapper;
    @Override
    public List<SyncPaper> selectSyncPaperList() {
        return syncPaperMapper.selectAll();
    }

    @Override
    public List<SyncQuestion> selectSyncQuestionList(String paperId, int paperOrder) {
        return syncQuestionMapper.selectByPaperIdAndPaperOrder(paperId,paperOrder);
    }

    @Override
    public List<SyncAnswer> selectValidSyncAnswerList(String questionId) {
        boolean isValid = true;
        return syncAnswerMapper.selectByQuestionIdAndIsValid(questionId,isValid);
    }

    @Override
    public List<SyncAnswer> selectSyncAnswerList(String questionId) {
        return syncAnswerMapper.selectByQuestionId(questionId);
    }

    @Override
    public List<MockPaper> selectPaperListByParams(int start, int limit, Map<String, Object> params) {
        List<MockPaper> lstPaper = syncPaperMapper.selectPaperListByParams(new RowBounds(start, limit), params);
        return lstPaper;
    }

    @Override
    public List<MockQuestionAndAnswer> selectQuestionListByPaperId(String paperId, Integer paperOrder) {
        List<MockQuestionAndAnswer> lstQuestion = syncQuestionMapper.selectQuestionListByPaperId(paperId,paperOrder);
        return lstQuestion;
    }
}

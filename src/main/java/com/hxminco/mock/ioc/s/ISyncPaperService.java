package com.hxminco.mock.ioc.s;

import com.hxminco.mock.comm.entry.MockPaper;
import com.hxminco.mock.comm.entry.SyncAnswer;
import com.hxminco.mock.comm.entry.SyncPaper;
import com.hxminco.mock.comm.entry.SyncQuestion;
import com.hxminco.mock.comm.model.MockQuestionAndAnswer;

import java.util.List;
import java.util.Map;

/**
 * Created by spiderman on 2018/1/12.
 */
public interface ISyncPaperService {
    List<SyncPaper> selectSyncPaperList();

    List<SyncQuestion> selectSyncQuestionList(String syncPaperId, int paperOrder);

    List<SyncAnswer> selectValidSyncAnswerList(String syncQuestionId);

    List<SyncAnswer> selectSyncAnswerList(String syncQuestionId);

    List<MockPaper> selectPaperListByParams(int start, int limit, Map<String, Object> params);

    List<MockQuestionAndAnswer> selectQuestionListByPaperId(String id, Integer paperOrder);
}

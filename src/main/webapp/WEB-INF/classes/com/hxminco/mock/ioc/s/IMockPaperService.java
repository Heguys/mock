package com.hxminco.mock.ioc.s;

import com.hxminco.mock.comm.entry.MockPaper;
import com.hxminco.mock.comm.model.PageModel;

import java.util.Map;

/**
 * Created by spiderman on 2017/12/21.
 */
public interface IMockPaperService {
    MockPaper getRandomMajorUnexamedPaper(String majorId, String studentId, Integer assessmentNature);

    MockPaper selectByPrimaryKey(String paperId);

    MockPaper updateMockPaper(String account, String paperId, String majorId, int assessmentNature, String title, int duration, int sumMark, int passMark, boolean randomQuestionSort, boolean randomOptionSort);

    PageModel<MockPaper> selectByParams4Page(Map<String, Object> params);

    void deletePaperAndRelevant(String id);

    void deletePapersAndRelevant(String[] ids);
}

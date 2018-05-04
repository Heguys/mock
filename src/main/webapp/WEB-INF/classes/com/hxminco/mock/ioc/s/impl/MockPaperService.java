package com.hxminco.mock.ioc.s.impl;

import com.hxminco.mock.comm.entry.*;
import com.hxminco.mock.comm.model.PageModel;
import com.hxminco.mock.comm.utils.MockConstants;
import com.hxminco.mock.comm.utils.StringUtil;
import com.hxminco.mock.ioc.d.*;
import com.hxminco.mock.ioc.s.IMockPaperService;
import net.bnusei.util.DateUtil;
import net.bnusei.util.StringPool;
import net.bnusei.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by spiderman on 2017/12/21.
 */
@Service
public class MockPaperService implements IMockPaperService {
    @Autowired
    MockPaperMapper paperMapper;
    @Autowired
    MockMajorMapper majorMapper;
    @Autowired
    MockPaperQuestionMapper paperQuestionMapper;
    @Autowired
    MockQuestionMapper questionMapper;
    @Autowired
    MockQuestionOptionMapper questionOptionMapper;

    @Override
    public MockPaper getRandomMajorUnexamedPaper(String majorId, String studentId, Integer assessmentNature) {
        MockPaper mockPaper = null;
        Map<String, Object> params = new HashMap<>();
        params.put("majorId", majorId);
        params.put("studentId", studentId);
        params.put("assessmentNature", assessmentNature);
        params.put("status", MockConstants.EXAM_STATUS_DOING);
        List<MockPaper> mockPapers = paperMapper.selectByMajorAndAssessmentNatureDoing(params);
        if (!mockPapers.isEmpty()) {
            mockPaper = mockPapers.get(0);
        }
        if (mockPaper == null) {
            List<MockPaper> mockPaperList = paperMapper.selectMajorAndAssessmentNatureUnexamedPaper(params);
            if (!mockPaperList.isEmpty()) {
                Random random = new Random(System.currentTimeMillis());
                int index = 0;
                while (true) {
                    index = random.nextInt(mockPaperList.size());
                    if (index < mockPaperList.size()) {
                        break;
                    }
                }
                mockPaper = mockPaperList.get(index);
            }
        }
        return mockPaper;
    }

    @Override
    public MockPaper selectByPrimaryKey(String paperId) {
        MockPaper paper = paperMapper.selectByPrimaryKey(paperId);
        return paper;
    }

    /**
     * 删除多份试卷及其相对应的问题、选项、问题和试卷对应的关系表
     *
     * @param ids
     */
    @Override
    public void deletePapersAndRelevant(String[] ids) {
        if (ids != null && ids.length > 0) {
            String paperId = null;
            for (int i = 0; i <ids.length ; i++) {
                paperId = ids[i];
                List<MockPaperQuestion> paperQuestions = paperQuestionMapper.selectListByPaperId(paperId);
                if (paperQuestions != null && paperQuestions.size() > 0) {
                    List<MockQuestion> questions = questionMapper.selectListByPaperQuestions(paperQuestions);
                    if (questions != null && questions.size() > 0) {
                        questionOptionMapper.deleteByQuestions(questions);
                    }
                    questionMapper.deleteByPaperQuestions(paperQuestions);
                }
                paperQuestionMapper.deleteByPaperId(paperId);
                paperMapper.deleteByPrimaryKey(paperId);
            }
        }
    }

    /**
     * 删除一份试卷及其相对应的问题、选项、问题和试卷对应的关系表
     *
     * @param paperId
     */

    @Override
    public void deletePaperAndRelevant(String paperId) {
        List<MockPaperQuestion> paperQuestions = paperQuestionMapper.selectListByPaperId(paperId);
        if (paperQuestions != null && paperQuestions.size() > 0) {
            List<MockQuestion> questions = questionMapper.selectListByPaperQuestions(paperQuestions);
            if (questions != null && questions.size() > 0) {
                questionOptionMapper.deleteByQuestions(questions);
            }
            questionMapper.deleteByPaperQuestions(paperQuestions);
        }
        paperQuestionMapper.deleteByPaperId(paperId);
        paperMapper.deleteByPrimaryKey(paperId);
    }

    @Override
    public PageModel<MockPaper> selectByParams4Page(Map<String, Object> params) {
        List<MockPaper> mockPapers = paperMapper.selectByParams4Page(params);
        int count = paperMapper.selectCountByParam4Page(params);
        PageModel<MockPaper> pageModel = new PageModel<>();
        pageModel.setRows(mockPapers);
        pageModel.setTotal(Long.valueOf(count));
        return pageModel;
    }

    @Override
    public MockPaper updateMockPaper(String account, String paperId, String majorId, int assessmentNature, String title, int duration, int sumMark, int passMark, boolean randomQuestionSort, boolean randomOptionSort) {
        MockPaper mockPaper = null;
        if (Validator.isNotNull(paperId)) {
            mockPaper = paperMapper.selectByPrimaryKey(paperId);
        }
        Date now = new Date();
        if (mockPaper == null) {
            mockPaper = new MockPaper();
            mockPaper.setCreatedUser(account);
            mockPaper.setCreatedTime(now);
        }
        mockPaper.setUpdatedUser(account);
        mockPaper.setUpdatedTime(now);

        mockPaper.setMajorId(majorId);
        mockPaper.setAssessmentNature(assessmentNature);

        if (Validator.isNull(title)) {
            StringBuilder titleBuilder = new StringBuilder();
            MockMajor mockMajor = majorMapper.selectByMajorId(mockPaper.getMajorId());
            if (mockMajor != null) {
                titleBuilder.append(mockMajor.getName()).append(StringPool.SPACE);
            }

            //titleBuilder.append(messageSource.getMessage("paper.field.assessmentNature." + assessmentNature,
            //        new String[0], "", Locale.CHINA));
            titleBuilder.append(StringPool.SPACE);
            titleBuilder.append(DateUtil.date2Str(new Date()));
            title = titleBuilder.toString();
        }
        mockPaper.setTitle(title);

        mockPaper.setDuration(duration);
        mockPaper.setSummark(sumMark);
        mockPaper.setPassmark(passMark);
        mockPaper.setRandomQuestionSort(randomQuestionSort);
        mockPaper.setRandomOptionSort(randomOptionSort);
        if (Validator.isNotNull(mockPaper.getId())) {
            paperMapper.updateByPrimaryKeySelective(mockPaper);
        } else {
            mockPaper.setId(StringUtil.getUUID());
            paperMapper.insertSelective(mockPaper);
        }
        return mockPaper;
    }
}

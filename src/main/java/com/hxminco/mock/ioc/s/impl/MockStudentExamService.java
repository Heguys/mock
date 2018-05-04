package com.hxminco.mock.ioc.s.impl;

import com.hxminco.mock.comm.entry.MockPaper;
import com.hxminco.mock.comm.entry.MockStudent;
import com.hxminco.mock.comm.entry.MockStudentExam;
import com.hxminco.mock.comm.model.ExamPageModel;
import com.hxminco.mock.comm.model.PageModel;
import com.hxminco.mock.comm.utils.MockConstants;
import com.hxminco.mock.comm.utils.Validator;
import com.hxminco.mock.ioc.d.MockPaperMapper;
import com.hxminco.mock.ioc.d.MockStudentAnswerMapper;
import com.hxminco.mock.ioc.d.MockStudentExamMapper;
import com.hxminco.mock.ioc.d.MockStudentMapper;
import com.hxminco.mock.ioc.s.IMockStudentExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by spiderman on 2017/12/22.
 */
@Service
public class MockStudentExamService implements IMockStudentExamService {
    @Autowired
    MockStudentExamMapper studentExamMapper;
    @Autowired
    MockStudentAnswerMapper studentAnswerMapper;
    @Autowired
    MockPaperMapper paperMapper;
    @Autowired
    MockStudentMapper studentMapper;

    @Override
    public PageModel<ExamPageModel> selectByStudentId4Page(Map<String, Object> params) {
        List<ExamPageModel> examPageModels = studentExamMapper.selectExamPageModelListByStudentId4Page(params);
        int count = studentExamMapper.selectCountByStudentId4Page(params);
        PageModel<ExamPageModel> pageModel = new PageModel<>();
        pageModel.setRows(examPageModels);
        pageModel.setTotal(Long.valueOf(count));
        return pageModel;
    }

    @Override
    public void commitMockStudentExam(String examId,MockStudent student) {
        MockStudentExam studentExam = null;
        MockPaper paper = null;
        if (Validator.isNotNull(examId)) {
            studentExam = studentExamMapper.selectByPrimaryKey(examId);
            paper = paperMapper.selectByPrimaryKey(studentExam.getPaperId());
        }
        if (studentExam != null && (studentExam.getExamStatus() == MockConstants.EXAM_STATUS_TODO
                || studentExam.getExamStatus() == MockConstants.EXAM_STATUS_DOING)) {
            if (studentExam.getExamDate() == null) {
                studentExam.setExamDate(studentExam.getFirstExamDate());
            }
            if (studentExam.getExamDate() == null) {
                studentExam.setExamDate(new Date());
            }
            Double dbsScore = studentAnswerMapper.selectCountScoreByExamId(examId);
            double score = 0;
            if (dbsScore != null) {
                score = dbsScore.doubleValue();
            }
            studentExam.setExamScore(score);
            if(score >= paper.getPassmark()){
                studentExam.setExamPassed(true);
            }else{
                studentExam.setExamPassed(false);
            }
            studentExam.setExamStatus(MockConstants.EXAM_STATUS_COMPLETED);
            studentExamMapper.updateByPrimaryKeySelective(studentExam);
            if (student != null) {
            student.setCompletedMocks((student.getCompletedMocks()==null?0:student.getCompletedMocks()) + 1);
            student.setAvailableMocks((student.getAvailableMocks()==null?0:student.getCompletedMocks()) - 1);
            studentMapper.updateByPrimaryKeySelective(student);
            }

        }
    }

    @Override
    public List<MockStudentExam> selectByExamDoing4Page(Map<String, Object> params) {
        List<MockStudentExam> studentExams = studentExamMapper.selectByExamDoing4Page(params);
        return studentExams;
    }

    @Override
    public MockStudentExam selectByPrimaryKey(String examId) {
        MockStudentExam studentExam = studentExamMapper.selectByPrimaryKey(examId);
        return studentExam;
    }

    @Override
    public MockStudentExam selectByStudentIdAndPaperIdDoing(String studentId, String paperId, int examStatusDoing) {
        Map<String, Object> params = new HashMap<>();
        params.put("studentId",studentId);
        params.put("paperId",paperId);
        params.put("status",examStatusDoing);
        MockStudentExam studentExam = studentExamMapper.selectByStudentIdAndPaperIdDoing(params);
        return studentExam;
    }

    @Override
    public void insertSelective(MockStudentExam studentExam) {
        studentExamMapper.insertSelective(studentExam);
    }
}

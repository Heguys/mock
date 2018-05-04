package com.hxminco.mock.ioc.s;

import com.hxminco.mock.comm.entry.MockStudent;
import com.hxminco.mock.comm.entry.MockStudentExam;
import com.hxminco.mock.comm.model.ExamPageModel;
import com.hxminco.mock.comm.model.PageModel;

import java.util.List;
import java.util.Map;

/**
 * Created by spiderman on 2017/12/22.
 */
public interface IMockStudentExamService {
    MockStudentExam selectByStudentIdAndPaperIdDoing(String studentId, String paperId, int examStatusDoing);

    void insertSelective(MockStudentExam studentExam);

    MockStudentExam selectByPrimaryKey(String examId);

    void commitMockStudentExam(String examId, MockStudent student);

    PageModel<ExamPageModel> selectByStudentId4Page(Map<String, Object> params);

    List<MockStudentExam> selectByExamDoing4Page(Map<String, Object> params);
}

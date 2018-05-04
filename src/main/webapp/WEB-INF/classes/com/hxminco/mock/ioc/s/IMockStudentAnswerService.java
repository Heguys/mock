package com.hxminco.mock.ioc.s;

import com.hxminco.mock.comm.entry.MockStudentAnswer;
import com.hxminco.mock.comm.entry.MockStudentExam;

import java.util.List;

/**
 * Created by spiderman on 2017/12/22.
 */
public interface IMockStudentAnswerService {
    List<MockStudentAnswer> selectListByExamId(String examId);

    void updateMockStudentAnswer(MockStudentExam studentExam, String questionId, String answer);
}

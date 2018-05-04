package com.hxminco.mock.ext.task;

import com.hxminco.mock.comm.entry.MockPaper;
import com.hxminco.mock.comm.entry.MockStudent;
import com.hxminco.mock.comm.entry.MockStudentExam;
import com.hxminco.mock.comm.utils.MockConstants;
import com.hxminco.mock.ioc.s.IMockStudentExamService;
import com.hxminco.mock.ioc.s.IMockStudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class AutoCommitExamTask {
	private static final Logger logger = LoggerFactory.getLogger(AutoCommitExamTask.class);

	@Autowired
	IMockStudentExamService studentExamService;
	@Autowired
	IMockStudentService studentService;

	@Scheduled(fixedDelay = 60000)
	public void work() {
		if (logger.isInfoEnabled()) {
			logger.info("work() - start");
		}
		int page = 0;
		int size = 5;
		Date now = new Date();
		Calendar startCalendar = Calendar.getInstance();
		while (true) {
			Map<String,Object> params = new HashMap<>();
			params.put("start",page*size);
			params.put("limit",size);
			params.put("status",MockConstants.EXAM_STATUS_DOING);
			List<MockStudentExam> studentExams = studentExamService.selectByExamDoing4Page(params);
			if (studentExams.size() == 0) {
				break;
			}
			boolean haveCommitted = false;
			for (MockStudentExam mockStudentExam : studentExams) {
				MockPaper mockPaper = mockStudentExam.getMockPaper();
				Date startDate = mockStudentExam.getExamDate();
				if (startDate != null) {
					startCalendar.setTime(startDate);
					startCalendar.add(Calendar.MINUTE, mockPaper.getDuration());
					if (startCalendar.getTime().before(now)) {
						// 应该交卷
						haveCommitted = true;
						MockStudent student = studentService.selectByPrimaryKey(mockStudentExam.getStudentId());
						studentExamService.commitMockStudentExam(mockStudentExam.getExamId(), student);
					}
				}
			}
			if (!haveCommitted) {
				page++;
			}
		}
		if (logger.isInfoEnabled()) {
			logger.info("work() - end");
		}
	}
}

package com.hxminco.mock.ioc.c;

import com.hxminco.mock.comm.entry.*;
import com.hxminco.mock.comm.model.MockQuestionAndAnswer;
import com.hxminco.mock.comm.utils.MockConstants;
import com.hxminco.mock.comm.utils.MyDataSourceSwitch;
import com.hxminco.mock.comm.utils.StringUtil;
import com.hxminco.mock.ioc.s.*;
import net.bnusei.util.StringPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;


@Controller
@RequestMapping("/migrate")
public class DataMigrateController extends BaseController{
	@Autowired
	private IMockMajorService mockMajorService;
	@Autowired
	private IMockPaperService mockPaperService;
	@Autowired
	private IMockPaperQuestionService mockPaperQuestionService;
	@Autowired
	private IMockQuestionService mockQuestionService;
	@Autowired
	private IMockQuestionOptionService mockQuestionOptionService;
	@Autowired
	private ISyncCodeService syncCodeService;
	@Autowired
	private ISyncPaperService syncPaperService;
	@Autowired
	ISyncQuestion2MockQuestionService syncQuestion2MockQuestionService;

/**
	 * 移植考核对象码表
	 * 
	 * @param request
	 * @param response
	 */

	@RequestMapping(value = "/major.ajax")
	public void migrateMajor(HttpServletRequest request, HttpServletResponse response) {
		String userId = request.getRemoteUser();
		String id = null;
		List<SyncQualificationType> qualificationTypeList = syncCodeService.getSyncQualificationTypeList();
		List<MockMajor> mockMajorList = new ArrayList<>();
		for (SyncQualificationType qualificationType : qualificationTypeList) {
			String majorId = StringPool.BLANK;
			String parentMajorId = StringPool.BLANK;
			String name = qualificationType.getName();
			boolean globalMajor = true;
			int assignCode1 = qualificationType.getCode() == null ? 0 : qualificationType.getCode();
			int assignCode2 = 0;
			int assignCode3 = 0;
			String childrenLabel = null;
			if (assignCode1 == 0) {
				childrenLabel = "作业类别";
			} else {
				childrenLabel = "取证类型";
			}
			mockMajorList.add(mockMajorService.updateMockMajor(userId, id, majorId, parentMajorId, name, globalMajor,
					assignCode1, assignCode2, assignCode3, childrenLabel));
		}

		for (MockMajor mockMajor : mockMajorList) {
			String parentMajorId = mockMajor.getMajorId();
			if (mockMajor.getAssignCode1() == 0) {
				// 特种作业人员
				List<SyncWorkClass> workClassList = syncCodeService.getSyncWorkClassList();
				List<MockMajor> childMockMajorList = new ArrayList<>();
				for (SyncWorkClass workClass : workClassList) {
					String majorId = StringPool.BLANK;
					String name = workClass.getName();
					boolean globalMajor = true;
					int assignCode1 = mockMajor.getAssignCode1();
					int assignCode2 = workClass.getCode() == null ? 0 : workClass.getCode();
					int assignCode3 = 0;
					String childrenLabel = "准操项目";
					childMockMajorList.add(mockMajorService.updateMockMajor(userId, id, majorId, parentMajorId, name,
							globalMajor, assignCode1, assignCode2, assignCode3, childrenLabel));
				}

				for (MockMajor childMockMajor : childMockMajorList) {
					parentMajorId = childMockMajor.getMajorId();
					List<SyncWorkItem> workItemList = syncCodeService
							.getSyncWorkItemList(childMockMajor.getAssignCode2());
					for (SyncWorkItem workItem : workItemList) {
						String majorId = StringPool.BLANK;
						String name = workItem.getName();
						boolean globalMajor = true;
						int assignCode1 = childMockMajor.getAssignCode1();
						int assignCode2 = childMockMajor.getAssignCode2();
						int assignCode3 = workItem.getCode() == null ? 0 : workItem.getCode();
						String childrenLabel = StringPool.BLANK;

						SyncMajor syncMajor = syncCodeService
								.selectByQualificationTypeCodeAndWorkClassCodeAndWorkItemCode(assignCode1, assignCode2,
										assignCode3);
						if (syncMajor != null) {
							majorId = syncMajor.getMajorId();
						}

						mockMajorService.updateMockMajor(userId, id, majorId, parentMajorId, name, globalMajor,
								assignCode1, assignCode2, assignCode3, childrenLabel);
					}
				}
			} else {
				// 另外两类
				List<SyncEvidenceType> evidenceTypeList = syncCodeService.getSyncEvidenceTypeList();
				for (SyncEvidenceType evidenceType : evidenceTypeList) {
					String majorId = StringPool.BLANK;
					String name = evidenceType.getName();
					boolean globalMajor = true;
					int assignCode1 = mockMajor.getAssignCode1();
					int assignCode2 = evidenceType.getCode() == null ? 0 : evidenceType.getCode();
					int assignCode3 = 0;
					String childrenLabel = "单位类型";
					if (assignCode2 > 2) {
						// 没有子节点了
						SyncMajor syncMajor = syncCodeService
								.selectByQualificationTypeCodeAndEvidenceTypeCodeAndUnitTypeCode(assignCode1, assignCode2,
										0);
						if (syncMajor != null) {
							majorId = syncMajor.getMajorId();
						}
					}
					MockMajor oneMockMajor = mockMajorService.updateMockMajor(userId, id, majorId, parentMajorId, name,
							globalMajor, assignCode1, assignCode2, assignCode3, childrenLabel);
					if (oneMockMajor.getAssignCode2() == 1) {
						// 安全生产合格证
						List<SyncUnitTypeQualification> qualificationList = syncCodeService
								.getSyncUnitTypeQualificationList();
						for (SyncUnitTypeQualification qualification : qualificationList) {
							majorId = StringPool.BLANK;
							name = qualification.getName();
							assignCode3 = qualification.getCode() == null ? 0 : qualification.getCode();
							childrenLabel = StringPool.BLANK;
							SyncMajor syncMajor = syncCodeService
									.selectByQualificationTypeCodeAndEvidenceTypeCodeAndUnitTypeCode(assignCode1,
											assignCode2, assignCode3);
							if (syncMajor != null) {
								majorId = syncMajor.getMajorId();
							}

							mockMajorService.updateMockMajor(userId, id, majorId, oneMockMajor.getMajorId(), name,
									globalMajor, assignCode1, assignCode2, assignCode3, childrenLabel);
						}
					} else if (oneMockMajor.getAssignCode2() == 2) {
						// 安全生产培训合格证
						// 安全生产合格证
						List<SyncUnitTypeCertificate> certificateList = syncCodeService
								.getSyncUnitTypeCertificateList();
						for (SyncUnitTypeCertificate certificate : certificateList) {
							majorId = StringPool.BLANK;
							name = certificate.getName();
							assignCode3 = certificate.getCode() == null ? 0 : certificate.getCode();
							childrenLabel = StringPool.BLANK;
							SyncMajor syncMajor = syncCodeService
									.selectByQualificationTypeCodeAndEvidenceTypeCodeAndUnitTypeCode(assignCode1,
											assignCode2, assignCode3);
							if (syncMajor != null) {
								majorId = syncMajor.getMajorId();
							}

							mockMajorService.updateMockMajor(userId, id, majorId, oneMockMajor.getMajorId(), name,
									globalMajor, assignCode1, assignCode2, assignCode3, childrenLabel);
						}
					}
				}
			}
		}
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/plain");
			response.getWriter().write("completed");
		} catch (IOException e) {
		}
	}

/**
	 * 移植试卷F
	 * 
	 * @param request
	 * @param response
	 */

	@RequestMapping(value = "/paper.ajax")
	public void migratePaper(HttpServletRequest request, HttpServletResponse response) {
		String account = request.getRemoteUser();
		List<SyncPaper> syncPaperList = syncPaperService.selectSyncPaperList();

		boolean randomQuestionSort = false;
		boolean randomOptionSort = false;

		boolean assessmentFirst = true;
		boolean assessmentAgain = true;
		boolean assessmentChange = true;

		String knowledgeId = null;
		int source = MockConstants.QUESTION_SOURCE_CENTRAL;

		String optionId = null;

		for (SyncPaper syncPaper : syncPaperList) {
			String syncPaperId = syncPaper.getId();
			String majorId = syncPaper.getMajorId();
			String title = syncPaper.getPlanName();
			int assessmentNature = syncPaper.getAssessmentNature();
			int duration = syncPaper.getDuration();
			int sumMark = syncPaper.getSumMark();
			int passMark = syncPaper.getPassMark();

			int paperNums = syncPaper.getPaperNums();

			for (int paperOrder = 1; paperOrder <= paperNums; paperOrder++) {
				String paperId = null;
				MockPaper mockPaper = mockPaperService.updateMockPaper(account, paperId, majorId, assessmentNature,
						title, duration, sumMark, passMark, randomQuestionSort, randomOptionSort);
				paperId = mockPaper.getId();

				List<SyncQuestion> syncQuestionList = syncPaperService.selectSyncQuestionList(syncPaperId, paperOrder);
				for (SyncQuestion syncQuestion : syncQuestionList) {
					String syncQuestionId = syncQuestion.getId();
					String questionId = null;

					String content = syncQuestion.getDescription();
					int questionType = syncQuestion.getQuestionTypeCode();
					int difficulty = syncQuestion.getDifficultyLevelCode();
					double score = syncQuestion.getScore();

					boolean judgeCorrect = false;
					if (MockConstants.QUESTION_TYPE_JUDGE == questionType) {
						List<SyncAnswer> validSyncAnswerList = syncPaperService.selectValidSyncAnswerList(syncQuestionId);
						if (validSyncAnswerList.size() == 1) {
							judgeCorrect = validSyncAnswerList.get(0).getDescription().equals("对");
						}
					}
					// 保存试题
					MockQuestion mockQuestion = this.mockQuestionService.updateMockQuestion(account, questionId,
							majorId, knowledgeId, content, questionType, difficulty, score, source, judgeCorrect,
							assessmentFirst, assessmentAgain, assessmentChange);
					questionId = mockQuestion.getId();

					if (MockConstants.QUESTION_TYPE_JUDGE != questionType) {
						// 选择题选项
						List<SyncAnswer> syncAnswerList = syncPaperService.selectSyncAnswerList(syncQuestionId);

						int i = 0;
						for (SyncAnswer syncAnswer : syncAnswerList) {
							this.mockQuestionOptionService.updateMockQuestionOption(account, optionId, questionId,
									syncAnswer.getDescription(), syncAnswer.getIsValid(), ++i);
						}
					}

					// 试卷是试题的关联表
					this.mockPaperQuestionService.updateMockPaperQuestion(StringPool.BLANK, paperId, questionId, score,
							syncQuestion.getSort());
				}
			}
		}
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/plain");
			response.getWriter().write("completed");
		} catch (IOException e) {
		}
	}

/**
	 * 移植考核对象码表
	 * 
	 * @param request
	 * @param response
	 */

	@RequestMapping(value = "/major/path.ajax")
	public void checkMajorPath(HttpServletRequest request, HttpServletResponse response) {
		this.mockMajorService.checkMajorPath();
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/plain");
			response.getWriter().write("completed");
		} catch (IOException e) {
		}
	}

	@ResponseBody
	@RequestMapping("/question2MockQuestion.ajax")
	public Object qbQuestion2MockQuestion(@RequestParam("majorId") String majorId, @RequestParam("numberPaper") Integer numberPaper,Integer assessmentNature) {
		start();
		MyDataSourceSwitch.setKey("1");
		Map<String, Object> params = new HashMap<>();
		params.put("majorId", majorId);
		params.put("assessmentNature", assessmentNature);
		List<MockPaper> lstPapers = syncPaperService.selectPaperListByParams(0, numberPaper, params);
		if(lstPapers == null || lstPapers.size()<=0){
			success(false);
			param("error", "没有该考核对象的试题");
			return end();
		}
		Map<String, Object> mpBuffers = new HashMap<>();
		mpBuffers.put("MockPaper", lstPapers);

		List<MockQuestion> lstMockQuestions = new ArrayList<>();
		List<MockQuestionOption> lstMockOptions = new ArrayList<>();
		List<MockPaperQuestion> lstMockPaperQuestions = new ArrayList<>();
		mpBuffers.put("MockQuestion", lstMockQuestions);
		mpBuffers.put("MockQuestionOption", lstMockOptions);
		mpBuffers.put("MockPaperQuestion", lstMockPaperQuestions);
		for (MockPaper one : lstPapers) {
			List<MockQuestionAndAnswer> lstQuestionAndAnswers = syncPaperService.selectQuestionListByPaperId(one.getId(),one.getPaperOrder());
			one.setId(StringUtil.getUUID());
			if (lstQuestionAndAnswers != null && lstQuestionAndAnswers.size() > 0) {
				String oneQAId = "";
				MockQuestion tempQuestion = null;
				MockPaperQuestion tempPaperQuestion = null;
				int index = 0;
				for (MockQuestionAndAnswer oneQA : lstQuestionAndAnswers) {
					String questionId = oneQA.getId();
					int questionType = oneQA.getQuestionType();
					boolean isValid = oneQA.getCorrect();
					//设置答题信息与问题-试题关联
					if (!questionId.equals(oneQAId)) {
						index = 1;
						oneQAId = questionId;
						tempQuestion = new MockQuestion();
						tempQuestion.setId(oneQA.getId());
						tempQuestion.setAssessmentAgain(true);
						tempQuestion.setAssessmentChange(true);
						tempQuestion.setAssessmentFirst(true);
						tempQuestion.setUpdatedTime(new Date());
						tempQuestion.setCreatedTime(new Date());
						tempQuestion.setCreatedUser(oneQA.getCreatedUser());
						tempQuestion.setUpdatedUser(oneQA.getUpdatedUser());
						tempQuestion.setVersion(oneQA.getVersion());
						tempQuestion.setQuestionContent(oneQA.getQuestionContent());
						tempQuestion.setDifficulty(oneQA.getDifficulty());
						tempQuestion.setMajorId(one.getMajorId());
						tempQuestion.setQuestionType(oneQA.getQuestionType());
						tempQuestion.setScore(oneQA.getScore());
						tempQuestion.setSource(oneQA.getSource());
						lstMockQuestions.add(tempQuestion);

						tempPaperQuestion = new MockPaperQuestion();
						tempPaperQuestion.setUpdatedTime(new Date());
						tempPaperQuestion.setCreatedTime(new Date());
						tempPaperQuestion.setCreatedUser(oneQA.getCreatedUser());
						tempPaperQuestion.setUpdatedUser(oneQA.getUpdatedUser());
						tempPaperQuestion.setVersion(oneQA.getVersion());
						tempPaperQuestion.setQuestionId(oneQA.getId());
						tempPaperQuestion.setPaperId(one.getId());
						tempPaperQuestion.setSortIndex(oneQA.getSortIndex());
						tempPaperQuestion.setId(StringUtil.getUUID());
						lstMockPaperQuestions.add(tempPaperQuestion);

					}

					if (questionType != 3) {
						//设置选项信息
						MockQuestionOption tempOption = new MockQuestionOption();
						tempOption.setId(oneQA.getAnswerId());
						tempOption.setCorrect(oneQA.getCorrect());
						tempOption.setCreatedUser(oneQA.getCreatedUser());
						tempOption.setUpdatedUser(oneQA.getUpdatedUser());
						tempOption.setOptionContent(oneQA.getOptionContent());
						tempOption.setSortIndex(index);
						tempOption.setVersion(oneQA.getVersion());
						tempOption.setQuestionId(oneQA.getId());
						lstMockOptions.add(tempOption);
					} else {
						if (isValid) {
							tempQuestion.setJudgeCorrect("对".equals(oneQA.getOptionContent()) ? true : false);
						}
					}
					index++;
				}
			}
		}
		MyDataSourceSwitch.setKey("2");
		try {
			int count = syncQuestion2MockQuestionService.insertAllPaper(mpBuffers);
			success(true);
			param("message", "成功导入"+count+"套试题！");
		} catch (Exception e) {
			success(false);
			if(e instanceof DuplicateKeyException){
				param("error", "试题导入出现重复！");
			}else{
				param("error", "试题导入出错！");
			}
		}
		return end();
	}

	@RequestMapping("/toMigratePage.html")
	public String toMigratePage(){

		return "manager/paper_migrate";
	}

}

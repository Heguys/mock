package com.hxminco.mock.ioc.c;

import com.hxminco.mock.comm.entry.*;
import com.hxminco.mock.comm.utils.MockConstants;
import com.hxminco.mock.comm.utils.StringUtil;
import com.hxminco.mock.comm.utils.Validator;
import com.hxminco.mock.ioc.s.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by spiderman on 2017/12/21.
 */
@Controller
@RequestMapping("/student")
public class ExamController extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(ExamController.class);
    @Autowired
    IMockPaperService paperService;
    @Autowired
    IMockQuestionService questionService;
    @Autowired
    IMockPaperQuestionService paperQuestionService;
    @Autowired
    IMockStudentService studentService;
    @Autowired
    IMockStudentExamService studentExamService;
    @Autowired
    IMockStudentAnswerService studentAnswerService;

    @RequestMapping("/getExamPaper.html")
    public String getExamPaper(){
        return "paper";
    }

    @RequestMapping("/examPage.html")
    public String toExamPage(HttpSession session,String paperId,String examId,Model model){
        MockStudent student = (MockStudent) session.getAttribute(MockConstants.STUDENT_SESSION_KEY);
        MockStudentExam studentExam = null;
        MockPaper mockPaper = null;
        if(Validator.isNull(paperId) && Validator.isNotNull(examId)){
           studentExam = studentExamService.selectByPrimaryKey(examId);
            mockPaper = studentExam.getMockPaper();
       }else {
           studentExam = studentExamService.selectByStudentIdAndPaperIdDoing(student.getStudentId(), paperId, MockConstants.EXAM_STATUS_DOING);
           if (studentExam == null) {
               studentExam = new MockStudentExam();
               studentExam.setStudentId(student.getStudentId());
               studentExam.setFirstExamDate(new Date());
               studentExam.setExamId(StringUtil.getUUID());
               studentExam.setExamDate(new Date());
               studentExam.setPaperId(paperId);
               studentExam.setAccount(student.getAccount());
               studentExam.setExamStatus(MockConstants.EXAM_STATUS_DOING);
               studentExam.setDeleted(false);
               studentExamService.insertSelective(studentExam);
               mockPaper = paperService.selectByPrimaryKey(paperId);
               studentExam.setMockPaper(mockPaper);
           }else{
               mockPaper = studentExam.getMockPaper();
           }
       }
        model.addAttribute("mockPaper",mockPaper);
        model.addAttribute("mockMajor",mockPaper.getMockMajor());
        session.setAttribute("studentExam",studentExam);
        return "exam";
    }

    @ResponseBody
    @RequestMapping("/startExam.ajax")
    public Object startExam(HttpSession session){
        MockStudentExam studentExam = (MockStudentExam)session.getAttribute("studentExam");
        start();
        String paperId = studentExam.getPaperId();
        List<MockPaperQuestion> paperQuestions = paperQuestionService.selectListByPaperId(paperId);
        List<MockStudentAnswer> studentAnswers = studentAnswerService.selectListByExamId(studentExam.getExamId());
        long timeInt = studentExam.getExamRemainSeconds();
        param("studentAnswers",studentAnswers);
        param("paperQuestions",paperQuestions);
        param("timeInt", timeInt);
        success(true);
        return end();
    }

    /**
     * 保存答案
     *
     */
    @ResponseBody
    @RequestMapping(value = "/answer.ajax" ,method = RequestMethod.POST)
    public Object answerQuestion(String examId,String answer,String questionId) {
        MockStudentExam studentExam = studentExamService.selectByPrimaryKey(examId);
        String msg = "";
        start();
        if (studentExam == null) {
            msg = "不存在这个考试";
            error(msg);
        } else if (studentExam.isExamStatusCompleted()) {
            msg = "考试已经交卷了";
            error(msg);
        } else {
            try {
                studentAnswerService.updateMockStudentAnswer(studentExam, questionId,answer);
                success(true);
            } catch (Exception e) {
                msg="保存试题答案出现了未知错误!";
                success(false);
                error(msg);
                logger.error(e.getMessage(),e);
            }
        }
        return end();
    }

    /**
     * 交卷
     * @param examId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/commit.ajax")
    public Object commitMockStudentExam(HttpSession session,String examId) {
        MockStudent student = (MockStudent) session.getAttribute(MockConstants.STUDENT_SESSION_KEY);
        String msg = "";
        start();
        MockStudentExam studentExam = studentExamService.selectByPrimaryKey(examId);
        if (studentExam == null) {
            msg = "不存在这个考试";
            error(msg);
            success(false);
            return end();
        } else if (studentExam.isExamStatusCompleted()) {
            msg = "考试已经交卷了";
            error(msg);
            success(false);
            return end();
        } else {
            try {
                studentExamService.commitMockStudentExam(examId, student);
                success(true);
                message("试卷提交成功!");
            } catch (Exception e) {
                success(false);
                error("试卷提交失败!");
                logger.error(e.getMessage(),e);
            }
        }
        return end();
    }
}

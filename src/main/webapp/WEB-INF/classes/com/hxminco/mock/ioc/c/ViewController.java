package com.hxminco.mock.ioc.c;

import com.hxminco.mock.comm.entry.*;
import com.hxminco.mock.comm.model.ExamPageModel;
import com.hxminco.mock.comm.model.PageModel;
import com.hxminco.mock.comm.utils.MockConstants;
import com.hxminco.mock.ioc.s.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by spiderman on 2017/12/26.
 */
@Controller
@RequestMapping("/student")
public class ViewController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(ViewController.class);
    @Autowired
    IMockStudentExamService studentExamService;
    @Autowired
    IMockPaperService paperService;
    @Autowired
    IMockQuestionService questionService;
    @Autowired
    IMockStudentAnswerService studentAnswerService;
    @Autowired
    IMockPaperQuestionService paperQuestionService;


    @RequestMapping("/toExamListPage.html")
    public Object toExamListPage(){
        return "papers";
    }

    @ResponseBody
    @RequestMapping("/getStudentExamList.ajax")
    public Object getStudentExamList(HttpSession session,Integer limit,@RequestParam(value="offset",defaultValue ="0")Integer offset){
        MockStudent mockStudent = (MockStudent)session.getAttribute(MockConstants.STUDENT_SESSION_KEY);
        Map<String, Object> params = new HashMap<>();
        params.put("studentId",mockStudent.getStudentId());
        params.put("start",offset);
        params.put("limit",limit);
        PageModel<ExamPageModel> examPageModel =  studentExamService.selectByStudentId4Page(params);
        return examPageModel;
    }

    @RequestMapping(value = "/toViewPage.html")
    public String String(HttpSession session,Model model,String examId) {
        MockStudent mockStudent = (MockStudent)session.getAttribute(MockConstants.STUDENT_SESSION_KEY);
        MockStudentExam studentExam = studentExamService.selectByPrimaryKey(examId);
        MockPaper mockPaper = paperService.selectByPrimaryKey(studentExam.getPaperId());
        model.addAttribute("mockPaper", mockPaper);
        model.addAttribute("mockMajor", mockPaper.getMockMajor());
        model.addAttribute("studentExam", studentExam);
        return "view";
    }

    @ResponseBody
    @RequestMapping(value = "/examView.ajax")
    public Object getHistoryExamQuestions(String examId) {
        start();
        MockStudentExam studentExam = studentExamService.selectByPrimaryKey(examId);
        MockPaper mockPaper = paperService.selectByPrimaryKey(studentExam.getPaperId());
        List<MockPaperQuestion> paperQuestions = paperQuestionService.selectListByPaperId(studentExam.getPaperId());
        List<MockStudentAnswer> studentAnswers = studentAnswerService.selectListByExamId(studentExam.getExamId());
        param("studentAnswers",studentAnswers);
        param("mockPaper", mockPaper);
        param("studentExam", studentExam);
        param("paperQuestions", paperQuestions);
        success(true);
        return end();
    }
}

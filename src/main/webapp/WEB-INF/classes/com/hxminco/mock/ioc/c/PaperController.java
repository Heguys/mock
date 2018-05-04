package com.hxminco.mock.ioc.c;

import com.hxminco.mock.comm.entry.MockPaper;
import com.hxminco.mock.comm.entry.MockStudent;
import com.hxminco.mock.comm.utils.MockConstants;
import com.hxminco.mock.ioc.s.IMockPaperService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by spiderman on 2017/12/21.
 */
@Controller
@RequestMapping("/paper")
public class PaperController extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(PaperController.class);
    @Autowired
    IMockPaperService mockPaperService;


    @ResponseBody
    @RequestMapping("/getMockPaper.ajax")
    public Object getRandomExamPaper(HttpSession session,String majorId,Integer assessmentNature){
        start();
        MockStudent mockStudent = (MockStudent)session.getAttribute(MockConstants.STUDENT_SESSION_KEY);
        MockPaper mockPaper = null;
        try {
            mockPaper = mockPaperService.getRandomMajorUnexamedPaper(majorId, mockStudent.getStudentId(), assessmentNature);
            List<MockPaper> list = new ArrayList<>();
            if(mockPaper != null){
                list.add(mockPaper);
            }
            param("rows",list);
            success(true);
        } catch (Exception e) {
            e.printStackTrace();
            success(false);
            logger.error(e.getMessage());
        }
        return end();
    }
}

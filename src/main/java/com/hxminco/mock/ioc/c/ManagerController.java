package com.hxminco.mock.ioc.c;

import com.hxminco.mock.comm.entry.MockPaper;
import com.hxminco.mock.comm.entry.MockStudent;
import com.hxminco.mock.comm.model.PageModel;
import com.hxminco.mock.comm.utils.MockConstants;
import com.hxminco.mock.ioc.s.IMockManagerService;
import com.hxminco.mock.ioc.s.IMockPaperService;
import com.hxminco.mock.ioc.s.IMockStudentService;
import net.bnusei.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by spiderman on 2018/1/18.
 */
@Controller
@RequestMapping("/manager")
public class ManagerController extends BaseController {
    @Autowired
    IMockManagerService mockManagerService;
    @Autowired
    private IMockStudentService mockStudentService;
    @Autowired
    private IMockPaperService mockPaperService;

    @RequestMapping("/index")
    public String index(HttpServletRequest request, HttpServletResponse response) {
        if (Validator.isNotNull(MockConstants.URI_MANAGER_AUTO_REDIRECT_TO)) {
            try {
                response.sendRedirect(request.getContextPath() + MockConstants.URI_MANAGER_AUTO_REDIRECT_TO);
            } catch (IOException e) {
            }
            return null;
        } else {
            return "/manager/paper_list";
        }
    }

    @RequestMapping("student/list.html")
    public String toStudentListPage(){

        return "manager/student_list";
    }

    @RequestMapping("paper/list.html")
    public String toPaperListPage(){

        return "manager/paper_list";
    }

    @ResponseBody
    @RequestMapping("student/getStudentList.ajax")
    public Object getStudentList(Integer limit,@RequestParam(value="offset",defaultValue ="0")Integer offset){
        Map<String, Object> params = new HashMap<>();
        params.put("start",offset);
        params.put("limit",limit);
        PageModel<MockStudent> mockStudentPage = mockStudentService.selectByParams4Page(params);
        return mockStudentPage;
    }

    @ResponseBody
    @RequestMapping("paper/getPaperList.ajax")
    public Object getPaperList(@RequestParam(value="limit",defaultValue ="15")int limit,@RequestParam(value="offset",defaultValue ="0")Integer offset,
                               String majorId,String assessmentNature){
        Map<String, Object> params = new HashMap<>();
        params.put("start",offset);
        params.put("limit",limit);
        params.put("majorId",majorId);
        params.put("assessmentNature",assessmentNature);
        PageModel<MockPaper> mockPaperPage = mockPaperService.selectByParams4Page(params);
        return mockPaperPage;
    }

    @ResponseBody
    @RequestMapping("/paper/delete.ajax")
    public Object deletePaper(String id){
        start();
        try {
            mockPaperService.deletePaperAndRelevant(id);
            success(true);
            param("message","删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            success(false);
            error("删除失败!");
        }
        return end();
    }
    @ResponseBody
    @RequestMapping(value="/paper/deletePapers.ajax",method= RequestMethod.POST)
    public Object deletePapers(@RequestParam(value="ids[]") String[] ids){
        start();
        try {
            mockPaperService.deletePapersAndRelevant(ids);
            success(true);
            param("message","删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            success(false);
            error("删除失败!");
        }
        return end();
    }
}

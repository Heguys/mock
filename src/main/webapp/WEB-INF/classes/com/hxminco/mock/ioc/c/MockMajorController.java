package com.hxminco.mock.ioc.c;

import com.hxminco.mock.comm.entry.MockMajor;
import com.hxminco.mock.ioc.s.IMockMajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by cyn on 16/6/4.
 */
@RequestMapping("/mockmajor")
@Controller
public class MockMajorController {

    @Autowired
    private IMockMajorService mockMajorService;

    @RequestMapping("/page.html")
    public String demoPage(ModelMap model){
        return "mockmajorList";
    }

    @RequestMapping("/getListByPid.ajax")
    @ResponseBody
        public Object getListByPId(@RequestParam("pId") String pId) {
        return mockMajorService.selectByParentId(pId);
    }

    @RequestMapping("/question.html")
      public String majorPage(ModelMap model){
        return "mockquestionList";
    }

    @ResponseBody
    @RequestMapping("/getMajorList.ajax")
    public Object getMajorInfo(@RequestParam(value="assignCode1",defaultValue ="0") Integer assignCode1){

        List<MockMajor> lstMajors = mockMajorService.getAllMajor(assignCode1);
        return lstMajors;
    }

}

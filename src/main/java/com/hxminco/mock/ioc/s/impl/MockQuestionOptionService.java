package com.hxminco.mock.ioc.s.impl;

import com.hxminco.mock.comm.entry.MockQuestion;
import com.hxminco.mock.comm.entry.MockQuestionOption;
import com.hxminco.mock.comm.utils.StringUtil;
import com.hxminco.mock.ioc.d.MockQuestionMapper;
import com.hxminco.mock.ioc.d.MockQuestionOptionMapper;
import com.hxminco.mock.ioc.s.IMockQuestionOptionService;
import net.bnusei.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by spiderman on 2018/1/12.
 */
@Service
public class MockQuestionOptionService implements IMockQuestionOptionService {
    @Autowired
    MockQuestionOptionMapper questionOptionMapper;
    @Autowired
    MockQuestionMapper questionMapper;

    @Override
    public MockQuestionOption updateMockQuestionOption(String account, String optionId, String questionId, String description, String isValid, int sortIndex) {
        boolean correct = "1".equals(isValid);
        MockQuestionOption option = null;
        if (Validator.isNotNull(optionId)) {
            option = questionOptionMapper.selectByPrimaryKey(optionId);
        }
        if (option == null) {
            option = new MockQuestionOption();
            option.updateBaseInfo(account);
            option.setQuestionId(questionId);
        } else {
            questionId = option.getQuestionId();
        }
        option.setOptionContent(description);
        option.setCorrect(correct);
        option.setSortIndex(sortIndex);
        if(Validator.isNotNull(optionId)) {
            questionOptionMapper.updateByPrimaryKeySelective(option);
        }else{
            option.setId(StringUtil.getUUID());
            questionOptionMapper.insertSelective(option);
        }
        optionId = option.getId();

        // 如果是单选，可能需要修改其他选项是否正确的信息
        if (correct) {
            MockQuestion mockQuestion = questionMapper.selectByPrimaryKey(questionId);
            if (mockQuestion != null && mockQuestion.isChoiceSingle()) {
                List<MockQuestionOption> optionList = questionOptionMapper.selectCorrectListByQuestionId(questionId);
                for (MockQuestionOption oneOption : optionList) {
                    if (oneOption.getCorrect() && !oneOption.getId().equals(optionId)) {
                        oneOption.setCorrect(false);
                        questionOptionMapper.updateByPrimaryKeySelective(oneOption);
                    }
                }
            }
        }
        return option;
    }
}

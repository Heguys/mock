package com.hxminco.mock.ioc.s;

import com.hxminco.mock.comm.entry.MockQuestionOption;

/**
 * Created by spiderman on 2018/1/12.
 */
public interface IMockQuestionOptionService {
    MockQuestionOption updateMockQuestionOption(String account, String optionId, String questionId, String description, String isValid, int i);
}

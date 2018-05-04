package com.hxminco.mock.ioc.s.impl;

import com.hxminco.mock.comm.entry.MockManager;
import com.hxminco.mock.comm.utils.StringUtil;
import com.hxminco.mock.ioc.d.MockManagerMapper;
import com.hxminco.mock.ioc.s.IMockManagerService;
import net.bnusei.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by spiderman on 2018/1/18.
 */
@Service("mockManagerService")
public class MockManagerService implements IMockManagerService {
    @Autowired
    MockManagerMapper managerMapper;
    @Override
    public MockManager updateMockManager(String managerId, String account, String name, String unitUid, boolean unitAdmin) {
        MockManager mockManager = null;
        if (Validator.isNotNull(managerId)) {
            mockManager = managerMapper.selectByPrimaryKey(managerId);
        }
        if (mockManager == null && Validator.isNotNull(account)) {
            mockManager = managerMapper.selectByAccount(account);
        }
        Date now = new Date();
        if (mockManager == null && Validator.isNotNull(account)) {
            mockManager = new MockManager();
            mockManager.setCreateDate(now);
        }
        if (mockManager != null && Validator.isNotNull(account)) {
            mockManager.setAccount(account);
        }
        mockManager.setLatestVisitDate(now);
        mockManager.setName(name);
        mockManager.setUnitUid(unitUid);
        mockManager.setUnitAdmin(unitAdmin);
        if(Validator.isNotNull(mockManager.getManagerId())){
            managerMapper.updateByPrimaryKeySelective(mockManager);
        }else {
            mockManager.setManagerId(StringUtil.getUUID());
            managerMapper.insertSelective(mockManager);
        }
        return mockManager;
    }
}

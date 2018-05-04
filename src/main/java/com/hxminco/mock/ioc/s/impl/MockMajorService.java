package com.hxminco.mock.ioc.s.impl;

import com.hxminco.mock.comm.entry.MockMajor;
import com.hxminco.mock.comm.utils.StringUtil;
import com.hxminco.mock.ioc.d.MockMajorMapper;
import com.hxminco.mock.ioc.s.IMockMajorService;
import net.bnusei.util.StringPool;
import net.bnusei.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by spiderman on 2017/12/21.
 */
@Service
public class MockMajorService implements IMockMajorService {


    @Autowired
    private MockMajorMapper mockMajorMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return mockMajorMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MockMajor record) {
        return mockMajorMapper.insert(record);
    }

    @Override
    public int insertSelective(MockMajor record) {
        return mockMajorMapper.insertSelective(record);
    }

    @Override
    public MockMajor selectByPrimaryKey(String id) {
        return mockMajorMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(MockMajor record) {
        return mockMajorMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MockMajor record) {
        return mockMajorMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<MockMajor> selectByParentId(String pId) {
        return mockMajorMapper.selectByParentId(pId);
    }

    @Override
    public MockMajor selectByMajorId(String majorId){
        return mockMajorMapper.selectByMajorId(majorId);
    }

    public List<MockMajor> getAllMajor(Integer assignCode1){
        List<MockMajor> lstMajors = mockMajorMapper.selectAllMajor(assignCode1);
        return lstMajors;
    }

    @Override
    public MockMajor updateMockMajor(String userId, String id, String majorId, String parentMajorId, String name, boolean globalMajor, int assignCode1, int assignCode2, int assignCode3, String childrenLabel) {
        MockMajor mockMajor = null;
        if (Validator.isNotNull(id)) {
            mockMajor = mockMajorMapper.selectByPrimaryKey(id);
        }
        if (mockMajor == null && Validator.isNotNull(majorId)) {
            mockMajor = mockMajorMapper.selectByMajorId(majorId);
        }
        if (mockMajor == null) {
            List<MockMajor> majorList = mockMajorMapper.selectByParentMajorIdAndName(parentMajorId, name);
            if (!majorList.isEmpty()) {
                mockMajor = majorList.get(0);
                for (int i = 1; i < majorList.size(); i++) {
                    mockMajorMapper.deleteByPrimaryKey(majorList.get(i).getId());
                }
            }
        }
        if (mockMajor == null) {
            mockMajor = new MockMajor();
            if (Validator.isNull(majorId)) {
                majorId = StringUtil.getUUID();
            }
            mockMajor.setMajorId(majorId);
            mockMajor.setCreatedTime(new Date());
            mockMajor.setCreatedUser(userId);
            mockMajor.setParentMajorId(parentMajorId);
        }

        mockMajor.setName(name);
        mockMajor.setGlobalMajor(globalMajor);
        mockMajor.setAssignCode1(assignCode1);
        mockMajor.setAssignCode2(assignCode2);
        mockMajor.setAssignCode3(assignCode3);
        mockMajor.setChildrenLabel(childrenLabel);
        if(Validator.isNotNull(mockMajor.getId())){
            mockMajorMapper.updateByPrimaryKey(mockMajor);
        }else{
            mockMajor.setId(StringUtil.getUUID());
            mockMajorMapper.insertSelective(mockMajor);
        }
        return mockMajor;
    }

    @Override
    public void checkMajorPath() {
        List<MockMajor> allMajorList = new ArrayList<MockMajor>();

        List<MockMajor> mockMajorList = this.mockMajorMapper.selectByParentId(StringPool.BLANK);
        allMajorList.addAll(mockMajorList);
        int index = 0;
        while (index < allMajorList.size()) {
            MockMajor mockMajor = allMajorList.get(index);
            mockMajorList = mockMajorMapper.selectByParentId(mockMajor.getMajorId());
            if (!mockMajorList.isEmpty()) {
                allMajorList.addAll(mockMajorList);
            }
            if (Validator.isNull(mockMajor.getMajorIdPath())) {
                StringBuilder path = new StringBuilder();
                MockMajor parentMajor = null;
                if (Validator.isNotNull(mockMajor.getParentMajorId())) {
                    parentMajor = mockMajorMapper.selectByMajorId(mockMajor.getParentMajorId());
                }
                if (parentMajor != null) {
                    path.append(parentMajor.getMajorIdPath()).append(StringPool.DASH);
                }
                path.append(mockMajor.getMajorId());
                mockMajor.setMajorIdPath(path.toString());
                if(Validator.isNotNull(mockMajor.getId())) {
                    mockMajorMapper.updateByPrimaryKeySelective(mockMajor);
                }else{
                    mockMajor.setId(StringUtil.getUUID());
                    mockMajorMapper.insertSelective(mockMajor);
            }
            index++;
        }
    }
    }
}

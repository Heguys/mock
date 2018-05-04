package com.hxminco.mock.ioc.s;

import com.hxminco.mock.comm.entry.MockMajor;

import java.util.List;

/**
 * Created by spiderman on 2017/12/21.
 */
public interface IMockMajorService {

    int deleteByPrimaryKey(String id);

    int insert(MockMajor record);

    int insertSelective(MockMajor record);

    MockMajor selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MockMajor record);

    int updateByPrimaryKey(MockMajor record);

    List<MockMajor> selectByParentId(String pId);

    MockMajor selectByMajorId(String majorId);

    List<MockMajor> getAllMajor(Integer assignCode1);

    MockMajor updateMockMajor(String userId, String id, String majorId, String parentMajorId, String name, boolean globalMajor, int assignCode1, int assignCode2, int assignCode3, String childrenLabel);

    void checkMajorPath();
}

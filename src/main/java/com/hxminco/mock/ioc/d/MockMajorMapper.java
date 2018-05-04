package com.hxminco.mock.ioc.d;

import com.hxminco.mock.comm.entry.MockMajor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MockMajorMapper {
    int deleteByPrimaryKey(String id);

    int insert(MockMajor record);

    int insertSelective(MockMajor record);

    MockMajor selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MockMajor record);

    int updateByPrimaryKey(MockMajor record);

    List<MockMajor> selectByParentId(String pId);

    MockMajor selectByMajorId(String majorId);

    List<MockMajor> selectAllMajor(Integer assignCode1);

    List<MockMajor> selectByParentMajorIdAndName(@Param("parentMajorId") String parentMajorId, @Param("name") String name);
}
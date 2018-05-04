package com.hxminco.mock.ioc.d;

import com.hxminco.mock.comm.entry.MockPaper;
import com.hxminco.mock.comm.entry.SyncPaper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface SyncPaperMapper {
    int deleteByPrimaryKey(String id);

    int insert(SyncPaper record);

    int insertSelective(SyncPaper record);

    SyncPaper selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SyncPaper record);

    int updateByPrimaryKey(SyncPaper record);

    List<SyncPaper> selectAll();

    List<MockPaper> selectPaperListByParams(RowBounds rowBounds, Map<String, Object> params);
}
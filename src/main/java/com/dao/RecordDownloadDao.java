package com.dao;

import com.model.DownloadRecord;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordDownloadDao {
    /**
     * 添加新下载记录
     * @param downloadRecord
     */
    @Select("insert into download (userId,songId) values(#{userId},#{songId})")
    void insert(DownloadRecord downloadRecord);

    /**
     * 获取所有用户的下载记录
     * @return
     */
    @Select("select * from download")
    List<DownloadRecord> selectAll();
}

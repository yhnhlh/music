package com.dao;

import com.model.PlayRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordPlayDao {

    /***
     * 添加新的播放记录
     * @param
     */

    @Insert("insert into play(userId,songId) values(#{userId},#{songId})")
    void insert(PlayRecord playRecord);

    /**
     * 查询所有用户的播放记录
     * @return
     */
    @Select("select * from play")
    List<PlayRecord> selectAll();
}

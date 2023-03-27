package com.dao;

import com.model.Like;
import com.model.Review;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewDao {
    /**
     * 插入评论信息
     * @param review
     * 评论对象
     * @return
     * 若插入成功返回1,否则返回0,即返回受影响的行数
     */
    @Insert("insert into review (userId,songId,review) values(#{userId},#{songId},#{review})")
    int insert(Review review);

    /**
     * 查询当前歌曲的精彩评论信息
     * @param songId
     * 当前歌曲Id
     * @return
     * 如果没有，返回null
     */
    @Select("select * from review where songId=#{songId}")
    List<Review> selectHotReview(int songId);

    /**
     * 查询歌曲的最新评论
     * @param songId 歌曲的Id
     * @return
     */
    @Select("SELECT * FROM `review` WHERE songId=#{songId} order by reviewId desc LIMIT 1")
    Review selectReview(int songId);





}

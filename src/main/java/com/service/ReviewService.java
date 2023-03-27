package com.service;

import com.model.Review;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ReviewService {
    /**
     * 添加评论并返回是否成功
     * @param request
     * HttpServletRequest
     * @param songId
     * 歌曲Id
     * @param review
     * 评论信息
     * @return
     * 如果添加成功，返回true
     */
    boolean addReview(HttpServletRequest request, int songId, String review);
    /**
     * 获取当前歌曲的精彩评论，并加上是否被当前用户点赞的标记
     * @param request
     * HttpServletRequest
     * @param songId
     * 歌曲Id
     * @return
     * 评论信息列表
     */
    List<Review> getHotReviewBySongId(HttpServletRequest request, int songId);


    /**
     * 查询歌曲的最新评论
     * @param songId
     * @return
     */
    Review selectSongReview(int songId);
}

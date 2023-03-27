package com.service;

import com.model.Song;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface TrendingRecService {
    /**
     * 获取当下热门的，带上当前用户是否收藏的标记的音乐推荐
     * @param request
     * HttpServletRequest
     * @return
     * 若曲库中没有任何歌曲，则返回null
     */
    List<Song> getSongWithCollectionFlag(HttpServletRequest request);
}

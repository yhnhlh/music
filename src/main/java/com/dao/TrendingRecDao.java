package com.dao;

import com.model.Collection;
import com.model.Song;
import com.model.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrendingRecDao {


    /**
     * 获取热门音乐推荐列表
     * @return
     * 若曲库中没有任何歌曲，则返回null
     */
    @Select("select * from trending,song where trending.songId=song.songId order by trendingCoefficient desc")
    List<Song> getTrendingSong();

    /**
     * 获取当前用户的收藏列表
     * @param user
     * 当前用户
     * @return
     * 若该用户没有任何收藏，则返回null
     */
    @Select("select * from collection where userId=#{userId}")
    List<Collection> getCollection(User user);
}

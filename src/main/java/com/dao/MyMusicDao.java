package com.dao;

import com.model.Song;
import com.model.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyMusicDao {
    /**
     * 查询当前用户收藏的歌曲信息列表
     * @param user
     * @return
     */
    @Select("select * from collection,song where userId=#{userId} and collection.songId=song.songId")
    public List<Song> selectCollectedSong(User user);
    /**
     * 查询当前用户最近的播放列表
     * @param user
     * @return
     */
    @Select("select * from song where songId in\n" +
            "\t\t(select distinct songId from play where userId=#{userId})")
    public List<Song> selectMyRecentSong(User user);
}

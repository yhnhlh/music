package com.dao;

import com.model.Song;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewTrackOnShelfDao {

    /**
     * 查询当前新歌曲
     * @return
     * 若没有新歌曲，则返回null
     */
    @Select("select * from song order by songId desc limit 50")
    List<Song> selectNewSong();
}

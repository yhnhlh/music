package com.dao;

import com.model.Song;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongDao {

    /**
     * 查询歌曲信息，根据其Name
     * @param songName
     * @return
     */

    @Select("select * from song where songName= #{songName} ")
    Song selectSongByName(String songName);

    /**
     * 获取所有歌曲信息
     * @return
     * 若没有，则返回null
     */
    @Select("select * from song")
    List<Song> selectAllSong();

    /**
     * 删除歌曲
     * @param songId
     * @return
     *若成功，返回1
     *
     */
    @Delete("delete from song where songId= #{songId}")
    int deleteSongById(int songId);

    /**
     * 更新歌曲
     * @param songId
     * @param songName
     * @param songAddress
     * @return
     *若成功，返回1
     *
     */
    @Update("update song set songName=#{songName},songAddress=#{songAddress} where songId=#{songId}")
    int updateSong(@Param("songId") int songId,@Param("songName") String songName,@Param("songAddress") String songAddress);

    /***
     * 插入单纯的歌曲(歌曲名称|歌曲地址)
     * @param songName
     * @param songAddress
     * @return
     * 若插入成功返回1,否则返回0,即返回受影响的行数
     */
    @Insert("insert into song(songName,songAddress) values(#{songName},#{songAddress})")
    int insertOnlySong(String songName,String songAddress);

}

package com.service;

import com.model.Song;

import java.util.List;

public interface SongService {
    /**
     * 查询歌曲信息，根据其Name
     * @param songName
     * @return
     */
    Song selectSongByName(String songName);

    /**
     * 获取所有歌曲信息
     * @return
     * 若没有，则返回null
     */
    List<Song> selectAllSong();

    /**
     * 删除歌曲
     * @param songId
     * @return
     *若成功，返回1
     *
     */
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
    int updateSong(int songId,String songName,String songAddress);

    /***
     * 插入单纯的歌曲(歌曲名称|歌曲地址)
     * @param songName
     * @param songAdress
     * @return
     * 若插入成功返回1,否则返回0,即返回受影响的行数
     */
    int insertOnlySong(String songName,String songAdress);
}

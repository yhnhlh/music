package com.service.impl;

import com.dao.SongDao;
import com.model.Song;
import com.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("songService")
public class SongServiceImpl implements SongService {
    @Autowired
    private SongDao songDao;
    @Override
    public Song selectSongByName(String songName) {
        Song song = songDao.selectSongByName(songName);
        return song;
    }

    @Override
    public List<Song> selectAllSong() {
        return songDao.selectAllSong();
    }

    @Override
    public int deleteSongById(int songId) {
        return songDao.deleteSongById(songId);
    }

    @Override
    public int updateSong(int songId, String songName, String songAddress) {
        return songDao.updateSong(songId,songName,songAddress);
    }

    @Override
    public int insertOnlySong(String songName, String songAdress) {
        return songDao.insertOnlySong(songName,songAdress);
    }
}

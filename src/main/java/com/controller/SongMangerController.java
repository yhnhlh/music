package com.controller;

import com.model.Song;
import com.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Controller
public class SongMangerController {
    @Autowired
    SongService songService;
    @RequestMapping("songManager.do")
    protected void SongManger(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String flag = req.getParameter("flag");
        if("addSong".equals(flag)){
            this.addSong(req,resp);
        }else if("findSong".equals(flag)){
            this.findSong(req,resp);
        }else if("preUpdate".equals(flag)){
            this.preUpdate(req,resp);
        }else if("modifySong".equals(flag)){
            this.modifySong(req,resp);
        }else if ("findSongs".equals(flag)){
            this.findSongs(req,resp);
        }else{
            this.dropSong(req,resp);
        }
    }
    /**
     * 处理查询单个用户请求
     */
    private void findSong(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String songName = req.getParameter("songName");
        Song song = songService.selectSongByName(songName);
        System.out.println(song);
        List<Song> songList=new ArrayList<>();
        songList.add(song);
        req.setAttribute("songList",songList);
        req.getRequestDispatcher("songList.jsp").forward(req,resp);
    }

    /**
     * 处理查询所有用户请求
     */
    private void findSongs(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        List<Song> songList = songService.selectAllSong();
        req.setAttribute("songList",songList);
        req.getRequestDispatcher("songList.jsp").forward(req,resp);

    }

    /**
     * 预更新查询
     */
    private void preUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String songName = req.getParameter("songName");
        Song song = songService.selectSongByName(songName);
        req.setAttribute("song",song);
        System.out.println(song);
        req.getRequestDispatcher("songUpdate.jsp").forward(req,resp);
    }

    /**
     * 处理更新用户请求
     */
    private void modifySong(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String songId = req.getParameter("songId");
        String songName = req.getParameter("songName");
        String songAddress = req.getParameter("songAddress");
        int i = songService.updateSong(Integer.parseInt(songId), songName, songAddress);
        if(i>0){
            req.getRequestDispatcher("ok.jsp").forward(req,resp);
        }
    }
    /**
     * 处理删除用户的请求
     */
    private  void dropSong(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String songId = req.getParameter("songId");
        int i = songService.deleteSongById(Integer.parseInt(songId));
        if(i>0){
            req.getRequestDispatcher("ok.jsp").forward(req,resp);
        }
    }
    /**
     * 处理添加用户的请求
     */
    private void addSong(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String songName = req.getParameter("songName");
        String songAddress = req.getParameter("songAddress");
        int i = songService.insertOnlySong(songName, songAddress);
        if(i>0){
            req.getRequestDispatcher("ok.jsp").forward(req,resp);
        }
    }
}

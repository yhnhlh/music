package com.controller;


import com.model.Song;
import com.service.MyMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class MyMusicPageController {
    @Autowired
    MyMusicService myMusicService;
    @RequestMapping("myMusicPage.do")
    public void MyMusicPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String flag = req.getParameter("flag");
        if("recentFrameLoad".equals(flag)){
            this.recentFrameLoad(req,resp);
        }else if("collectedFrameLoad".equals(flag)){
            this.collectedFrameLoad(req,resp);
        }
    }
    private void recentFrameLoad(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Song> myRecentPlayList=myMusicService.getMyRecentPlayListWithCollectionFlag(req);
        req.setAttribute("myRecentPlayList",myRecentPlayList);
        System.out.println("111");
        req.getRequestDispatcher("recentFrame.jsp").forward(req,resp);

    }

    private void collectedFrameLoad(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Song> myCollectionList=myMusicService.getMyCollectionWithCollectionFlag(req);
        req.setAttribute("myCollectionList",myCollectionList);
        req.getRequestDispatcher("collectedFrame.jsp").forward(req,resp);
    }
}

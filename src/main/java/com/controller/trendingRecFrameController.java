package com.controller;

import com.model.Song;
import com.service.TrendingRecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class trendingRecFrameController {
    @Autowired
    TrendingRecService trendingRecService;
    @RequestMapping("trendingRecFrame.do")
    public void TrendingRecFrame(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Song> trendingSongList=trendingRecService.getSongWithCollectionFlag(req);
        req.setAttribute("trendingSongList",trendingSongList);
        req.getRequestDispatcher("trendingRecFrame.jsp").forward(req,resp);
    }
}

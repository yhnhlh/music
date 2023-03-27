package com.controller;

import com.model.Song;
import com.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class SearchController {
    @Autowired
    private SearchService searchService;
    @RequestMapping("searchFrameLoad.do")
    public void Search(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        String keyWord=req.getParameter("keyWord");
        List<Song> searchSongList = searchService.getSearchSongWithCollectionFlag(req, keyWord);
        req.setAttribute("searchSongList",searchSongList);
        req.getRequestDispatcher("searchFrame.jsp").forward(req,resp);
    }
}

package com.controller;

import com.model.Song;
import com.service.RankingPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class RankingPageController {
    @Autowired
    private RankingPageService rankingPageService;
    @RequestMapping("rankingFrameLoad.do")
    public void RankingPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Song> weekRankingList=rankingPageService.getRankWithCollectionFlag(req,1);
        List<Song> monthRankingList=rankingPageService.getRankWithCollectionFlag(req,2);
        req.setAttribute("weekRankingList",weekRankingList);
        req.setAttribute("monthRankingList",monthRankingList);
        req.setAttribute("oneDayOneWord","游鱼出听");
        req.getRequestDispatcher("rankingFrame.jsp").forward(req,resp);
    }

}

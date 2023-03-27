package com.controller;

import com.model.Review;
import com.service.RecordPlayService;
import com.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class playPageController {
    @Autowired
    RecordPlayService recordPlayService;
    @Autowired
    ReviewService reviewService;
    @RequestMapping("play.do")
    public void playPage(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        String songAddress = req.getParameter("songAddress");
        String songName=req.getParameter("songName");
        String songId=req.getParameter("songId");
        List<Review> hotReviews = reviewService.getHotReviewBySongId(req, Integer.parseInt(songId));
        req.setAttribute("songAddress",songAddress);
        req.setAttribute("songName",songName);
        req.setAttribute("songId",songId);
        req.setAttribute("hotReviews",hotReviews);
        req.getRequestDispatcher("play2.jsp").forward(req,resp);

        //增加新的播放记录
        recordPlayService.recordPlay(req,Integer.parseInt(songId));
    }
    @RequestMapping("reviewList.do")
    public void reviewList(HttpServletRequest req, HttpServletResponse resp,String songId)throws ServletException, IOException {
        List<Review> hotReviews = reviewService.getHotReviewBySongId(req, Integer.parseInt(songId));
        req.setAttribute("hotReviews",hotReviews);
        req.getRequestDispatcher("play2.jsp").forward(req,resp);
    }
}

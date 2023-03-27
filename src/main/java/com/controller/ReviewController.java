package com.controller;
import com.alibaba.fastjson.JSON;
import com.model.Review;
import com.service.ReviewService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @GetMapping(value = "review.do")
    @ResponseBody
    public String review(HttpServletRequest request, int songId, String review) {
        boolean isAdded=reviewService.addReview(request,songId,review);
        Review review1 = reviewService.selectSongReview(songId);
        String s = JSON.toJSONString(review1);
        System.out.println(s);
        return  s;
    }
}

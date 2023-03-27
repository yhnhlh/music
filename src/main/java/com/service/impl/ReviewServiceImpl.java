package com.service.impl;

import com.dao.ReviewDao;
import com.model.Review;
import com.model.User;
import com.service.ReviewService;
import com.utils.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service("reviewService")
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewDao reviewDao;
    @Override
    public boolean addReview(HttpServletRequest request, int songId, String review) {
        boolean isInsertSuccessful = false;
        User user = Request.getUserFromHttpServletRequest(request);
        Review review1=new Review(user.getUserId(),songId,review);
        int insert = reviewDao.insert(review1);
        if(insert>0){
            isInsertSuccessful=true;
        }
        return isInsertSuccessful;
    }

    @Override
    public List<Review> getHotReviewBySongId(HttpServletRequest request, int songId) {
        return reviewDao.selectHotReview(songId);
    }

    @Override
    public Review selectSongReview(int songId) {
        return reviewDao.selectReview(songId);
    }
}

package com.dao;

import com.model.Review;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

// Junit使用Spring的方式运行代码，即自动创建Spring容器
@RunWith(SpringJUnit4ClassRunner.class)
// Spring容器创建时读取的配置文件或配置类
// 配置类写法 @ContextConfiguration(classes = 配置类.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class ReviewTest {
    @Autowired
    private ReviewDao reviewDao;
    @Test
    public void test1(){
//        Review review = new Review(1, 3, "哈哈哈");
//        reviewDao.insert(review);
//
//        List<Review> reviews = reviewDao.selectHotReviewWithLikeNumber(3);
//        reviews.forEach(System.out::println);

//        List<Review> reviews = reviewDao.selectNewReviewWithLikeNumber(3);
//        reviews.forEach(System.out::println);
//
//        int a[]={17};
//        reviewDao.deleteByIds(a);



    }
}

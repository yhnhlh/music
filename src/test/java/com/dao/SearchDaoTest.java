package com.dao;

import com.model.Review;
import com.model.Song;
import com.model.User;
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
public class SearchDaoTest {
    @Autowired
    private SearchDao searchDao;

    @Autowired
    private NewTrackOnShelfDao newTrackOnShelfDao;
    @Autowired
    UserDao userDao;

    @Test
    public void test1(){
        List<Song> songs = searchDao.selectSongLikeKeyword("喜欢");
        songs.forEach(System.out::println);

        List<Review> reviews = searchDao.selectReviewLikeKeyword("精彩");
        reviews.forEach(System.out::println);

//        List<User> users = searchDao.selectUserLikeKeyword("大", 15);
//        System.out.println(users.get(0));
//        List<Song> songs = newTrackOnShelfDao.selectNewSong();
//        songs.forEach(System.out::println);

    }
    @Test
    public void test2(){
//        User user=new User();
//        user.setEmail("admin@qq.com");
//        user.setPassword("admin");
//        User user1 = userDao.selectByUser(user);
//        System.out.println(user1);
//      userDao.insert("aaa","aa","aa");


    }
}

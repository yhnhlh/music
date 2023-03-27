package com.service;

import com.dao.*;
import com.model.*;
import com.service.impl.UserServiceImpl;
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
public class UserServiceTest {

    @Autowired()
    private UserService userService;



    @Autowired
    private TrendingRecDao trendingRecDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private SongDao songDao;

    @Autowired
    private MyMusicDao myMusicDao;

    @Autowired
    private RecordPlayDao recordPlayDao;

    @Test
    public void test1(){
//        List<User> allRecords = userService.getAllRecords();
//        allRecords.forEach(System.out::println);
//        List<Song> trendingSong = trendingRecDao.getTrendingSong();
//        trendingSong.forEach(System.out::println);

//        Role role = userDao.selectRoleByUserId(2011227);
//        System.out.println(role.getRoleName());

//        User user = userDao.selectByEmail("admin@qq.com");
//        System.out.println(user);

        User user=new User();
        user.setEmail("aaa.");
        user.setPassword("asas");
        user.setUserName("asas");


//        int i = songDao.selectCoefficientById(1);
//        System.out.println(i);

//        List<Song> trendingSong = trendingRecDao.getTrendingSong();
//        trendingSong.forEach(System.out::println);

//            user.setUserId(1);
//        List<Collection> collection = trendingRecDao.getCollection(user);
//        System.out.println(collection.get(0).getSongId());


//        User user = new User();
//        user.setUserId(1);
//        List<Song> songs = myMusicDao.selectCollectedSong(user);
//        songs.forEach(System.out::println);

//        List<Song> songs = myMusicDao.selectMyRecentSong(user);
//        songs.forEach(System.out::println);

//
//        List<PlayRecord> playRecords = recordPlayDao.selectAll();
//        playRecords.forEach(System.out::println);



    }


}

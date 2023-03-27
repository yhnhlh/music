package com.dao;

import com.model.Song;
import com.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

// Junit使用Spring的方式运行代码，即自动创建Spring容器
@RunWith(SpringJUnit4ClassRunner.class)
// Spring容器创建时读取的配置文件或配置类
// 配置类写法 @ContextConfiguration(classes = 配置类.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class PersonalRecDaoTest {
    @Autowired
    PersonalRecDao personalRecDao;

    @Test
    public void test(){
//        User user = new User();
//        user.setUserId(1);
//        List<Song> songs = personalRecDao.selectPersonalRecFromA(user);
//        songs.forEach(System.out::println);

        Song song1 = new Song();
        song1.setSongId(2);
        List<Song> songList=new ArrayList<>();
        songList.add(song1);
//        personalRecDao.insertListIntoRecA(songList,1);
        personalRecDao.insertListIntoRecB(songList,1);

    }
}

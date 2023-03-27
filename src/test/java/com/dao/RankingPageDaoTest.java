package com.dao;

import com.model.Song;
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
public class RankingPageDaoTest {
    @Autowired
    private RankingPageDao rankingPageDao;
    @Test
    public void Test1(){
//        List<Song> songs = rankingPageDao.selectRecentMonthRanking();
//        songs.forEach(System.out::println);

        List<Song> songs = rankingPageDao.selectRecentWeekRanking();
        songs.forEach(System.out::println);
    }

}

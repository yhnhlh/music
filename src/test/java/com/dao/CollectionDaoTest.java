package com.dao;

import com.model.Collection;
import com.model.PlayRecord;
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
public class CollectionDaoTest {

    @Autowired
    private CollectionDao collectionDao;
    @Autowired
    private RecordPlayDao recordPlayDao;
    @Test
    public void test1(){
//        Collection collection = new Collection(2, 3);
//        Collection collection1 = collectionDao.selectByCollection(collection);
//        System.out.println(collection1);

//        List<Collection> collections = collectionDao.selectAll();
//        collections.forEach(System.out::println);
        PlayRecord playRecord=new PlayRecord();
        playRecord.setSongId(7);
        playRecord.setUserId(1);
        recordPlayDao.insert(playRecord);
    }
    @Test
    public void test2(){
//        Collection collection = new Collection(2, 3);
//        Collection collection1 = collectionDao.selectByCollection(collection);
//        System.out.println(collection1);

        List<Collection> collections = collectionDao.selectAll();
        collections.forEach(System.out::println);
    }
}

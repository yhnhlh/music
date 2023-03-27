package com.service.impl;


import com.dao.MyMusicDao;
import com.dao.TrendingRecDao;
import com.dao.UserDao;

import com.model.Collection;
import com.model.Song;
import com.model.User;
import com.service.MyMusicService;
import com.utils.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service("myMusicService")
public class MyMusicServiceImpl implements MyMusicService {
    @Autowired
    private MyMusicDao myMusicDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private TrendingRecDao trendingRecDao;

    @Override
    public List<Song> getMyCollectionWithCollectionFlag(HttpServletRequest request) {
        List<Song> myCollectionList = new ArrayList<>();
        User user = Request.getUserFromHttpServletRequest(request);
        myCollectionList =myMusicDao.selectCollectedSong(user);
        //为该用户收藏的歌曲加上标记
        if(myCollectionList!=null) {
            for(Song t:myCollectionList) {
                t.setWhetherCollected(true);
            }
        }
        return myCollectionList;

    }

    @Override
    public List<Song> getMyRecentPlayListWithCollectionFlag(HttpServletRequest request) {
        List<Song> myRecentPalyList = new ArrayList<Song>();
        List<Collection> collectionList=new ArrayList<>();
        User user = Request.getUserFromHttpServletRequest(request);
        myRecentPalyList=myMusicDao.selectMyRecentSong(user);
        collectionList = trendingRecDao.getCollection(user);
        //加上收藏标记
        if(collectionList!=null&&myRecentPalyList!=null) { ;
            for(Song t:myRecentPalyList) {
                for (Collection c:collectionList){
                    if(t.getSongId()==c.getSongId()){
                        t.setWhetherCollected(true);
                    }
                }
            }
        }
        return myRecentPalyList;
    }
}

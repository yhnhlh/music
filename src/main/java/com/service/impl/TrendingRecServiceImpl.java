package com.service.impl;


import com.dao.TrendingRecDao;

import com.model.Collection;
import com.model.Song;
import com.model.User;
import com.service.TrendingRecService;
import com.utils.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service("trendingRecService")
public class TrendingRecServiceImpl implements TrendingRecService {
    @Autowired
    private TrendingRecDao trendingRecDao;
    @Override
    public List<Song> getSongWithCollectionFlag(HttpServletRequest request) {
        User user = Request.getUserFromHttpServletRequest(request);
        List<Song> trendingRecList=new ArrayList<Song>();
        List<Collection> collectionList=new ArrayList<Collection>();
        trendingRecList=trendingRecDao.getTrendingSong();
        collectionList=trendingRecDao.getCollection(user);
    //在热门推荐列表中给已经被该用户收藏的歌曲加上标记
        if(collectionList!=null && trendingRecList!=null) {
            for(Collection c:collectionList) {
                for(Song t:trendingRecList) {
                    if(c.getSongId()==t.getSongId()) {
                        t.setWhetherCollected(true);
                    }
                }
            }
        }
        return trendingRecList;

    }
}

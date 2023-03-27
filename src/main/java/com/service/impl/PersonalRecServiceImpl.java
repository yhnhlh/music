package com.service.impl;


import com.dao.NewTrackOnShelfDao;
import com.dao.PersonalRecDao;
import com.dao.TrendingRecDao;

import com.model.Collection;
import com.model.Song;
import com.model.User;
import com.service.PersonalRecService;
import com.utils.Constants;
import com.utils.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service("personalRecService")
public class PersonalRecServiceImpl implements PersonalRecService {
    @Autowired
    private TrendingRecDao trendingRecDao;
    @Autowired
    private PersonalRecDao personalRecDao;
    @Autowired
    private NewTrackOnShelfDao newTrackOnShelfDao;
    @Override
    public List<Song> getPersonalDailyRecWithCollectionFlag(HttpServletRequest request) {
        List<Song> personalRecList = new ArrayList<Song>();
        List<Collection> collectionList = new ArrayList<Collection>();
        User user = Request.getUserFromHttpServletRequest(request);
        collectionList = trendingRecDao.getCollection(user);
        personalRecList=selectPersonalRec(user);
        // 在个性化列表中给已经被该用户收藏的歌曲加上标记
        if (collectionList != null && personalRecList != null) {
            for (Collection c : collectionList) {
                for (Song t : personalRecList) {
                    if (c.getSongId() == t.getSongId()) {
                        t.setWhetherCollected(true);
                    }
                }
            }
        }
        return personalRecList;
    }

    private List<Song> selectPersonalRec(User user) {
        if(user==null) return null;
        List<Song> personalRecList = new ArrayList<Song>();
        if(Constants.isFromA) {
            personalRecList=personalRecDao.selectPersonalRecFromA(user);
        }else {
            personalRecList=personalRecDao.selectPersonalRecFromB(user);
        }
        return personalRecList;
    }
    @Override
    public void initializePersonalRecList(HttpServletRequest request) {
        User user = Request.getUserFromHttpServletRequest(request);
        List<Song> initialRecListA = new ArrayList<Song>();
        List<Song> initialRecListB = new ArrayList<Song>();
        //从新歌中随机获取10首，作为初始化列表
        initialRecListA=newTrackOnShelfDao.selectNewSong();
        for(int i=0;i<40;i++) {
            int len=initialRecListA.size();
            Random random=new Random();
            int index=random.nextInt(len);
            if(i<10) {
                initialRecListB.add(initialRecListA.get((index+1)%len));
            }
            initialRecListA.remove(index);
        }
        //批量插入
        if(Constants.isFromA) {
            personalRecDao.insertListIntoRecA(initialRecListA,user.getUserId());
        }else {
            personalRecDao.insertListIntoRecB(initialRecListB,user.getUserId());
        }

    }


}

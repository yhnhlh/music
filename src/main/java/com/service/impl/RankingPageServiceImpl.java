package com.service.impl;

import com.dao.RankingPageDao;
import com.dao.TrendingRecDao;

import com.model.Collection;
import com.model.Song;
import com.model.User;

import com.service.RankingPageService;
import com.utils.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service("rankingPageService")
public class RankingPageServiceImpl implements RankingPageService {
    @Autowired
    private RankingPageDao rankingPageDao;
    @Autowired
    private TrendingRecDao trendingRecDao;
    @Override
    public List<Song> getRankWithCollectionFlag(HttpServletRequest request, int mode) {
        List<Song> rankingPageList = new ArrayList<Song>();
        List<Collection> collectionList = new ArrayList<Collection>();
        User user = Request.getUserFromHttpServletRequest(request);
        collectionList=trendingRecDao.getCollection(user);
        if(mode==1) {
            rankingPageList=rankingPageDao.selectRecentWeekRanking();
        }else if(mode==2){
            rankingPageList=rankingPageDao.selectRecentMonthRanking();
        }else {
            //保留便于扩展
            rankingPageList=rankingPageDao.selectRecentMonthRanking();
        }
        // 在个性化列表中给已经被该用户收藏的歌曲加上标记
        if (collectionList != null && rankingPageList != null) {
            for (Collection c : collectionList) {
                for (Song t : rankingPageList) {
                    if (c.getSongId() == t.getSongId()) {
                        t.setWhetherCollected(true);
                    }
                }
            }
        }
        return rankingPageList;
    }
}

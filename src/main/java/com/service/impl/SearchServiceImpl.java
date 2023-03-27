package com.service.impl;

import com.dao.SearchDao;
import com.dao.TrendingRecDao;
import com.model.Collection;
import com.model.Song;
import com.model.User;
import com.service.SearchService;
import com.utils.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
@Service("searchService")
public class SearchServiceImpl implements SearchService {
    @Autowired
    private SearchDao searchDao;
    @Autowired
    private TrendingRecDao trendingRecDao;
    @Override
    public List<Song> getSearchSongWithCollectionFlag(HttpServletRequest request, String keyword) {
        keyword="%"+keyword+"%";
        List<Song> searchSongList=new ArrayList<Song>();
        List<Collection> collectionList=new ArrayList<Collection>();
        User user = Request.getUserFromHttpServletRequest(request);
        collectionList=trendingRecDao.getCollection(user);
        searchSongList=searchDao.selectSongLikeKeyword(keyword);

        //在搜索结果列表中给已经被该用户收藏的歌曲加上标记
        if(collectionList!=null && searchSongList!=null) {
            for(Collection c:collectionList) {
                for(Song t:searchSongList) {
                    if(c.getSongId()==t.getSongId()) {
                        t.setWhetherCollected(true);
                    }
                }
            }
        }
        return searchSongList;
    }
}

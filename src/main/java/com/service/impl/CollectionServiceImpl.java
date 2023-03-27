package com.service.impl;

import com.dao.CollectionDao;
import com.model.Collection;
import com.model.User;
import com.service.CollectionService;
import com.utils.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service("collectionService")
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    private CollectionDao collectionDao;
    @Override
    public boolean collectionChange(HttpServletRequest request, int songId) {

        boolean isCurCollected=true;
        User user = Request.getUserFromHttpServletRequest(request);
        Collection collection1=new Collection();
        collection1.setSongId(songId);
        collection1.setUserId(user.getUserId());
        Collection collection = collectionDao.selectByCollection(collection1);
        if(collection==null) {
            //该歌曲没有被收藏
            isCurCollected=false;
            //添加收藏
            collectionDao.insert(collection1);
        }else {
            System.out.println("取消收藏"+user.getUserId());
            //已经被收藏，则取消收藏
            collectionDao.deleteById(user.getUserId(),songId);
            System.out.println("111111");
        }
        //返回改变后的收藏状态
        System.out.println("111");
        System.out.println(!isCurCollected+" ");
        return !isCurCollected;
    }
}

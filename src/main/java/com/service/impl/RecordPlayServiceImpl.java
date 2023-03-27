package com.service.impl;

import com.dao.RecordPlayDao;
import com.model.PlayRecord;
import com.model.User;
import com.service.RecordPlayService;
import com.utils.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service("recordPlayService")
public class RecordPlayServiceImpl implements RecordPlayService {
    @Autowired
    RecordPlayDao recordPlayDao;
    @Override
    public void recordPlay(HttpServletRequest request, int songId) {
        User user = Request.getUserFromHttpServletRequest(request);
        PlayRecord playRecord=new PlayRecord();
        playRecord.setUserId(user.getUserId());
        playRecord.setSongId(songId);
        recordPlayDao.insert(playRecord);
    }
}

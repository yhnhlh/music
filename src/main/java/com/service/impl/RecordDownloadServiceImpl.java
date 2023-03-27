package com.service.impl;

import com.dao.RecordDownloadDao;
import com.model.DownloadRecord;
import com.model.User;
import com.service.RecordDownloadService;
import com.utils.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service("recordDownloadService")
public class RecordDownloadServiceImpl implements RecordDownloadService {
    @Autowired
    private RecordDownloadDao recordDownloadDao;
    @Override
    public void recordDownload(HttpServletRequest request, int songId) {
        User user = Request.getUserFromHttpServletRequest(request);
        if(user==null){
            return;
        }
        DownloadRecord downloadRecord=new DownloadRecord();
        downloadRecord.setUserId(user.getUserId());
        downloadRecord.setSongId(songId);
        recordDownloadDao.insert(downloadRecord);
    }
}

package com.controller;

import com.service.RecordDownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

@Controller
public class DownloadController {
    @Autowired
    private RecordDownloadService recordDownloadService;
    @RequestMapping("download.do")
    public void Download(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        int songId=Integer.parseInt(req.getParameter("songId"));
        String songAddress=req.getParameter("songAddress");
        String songName=req.getParameter("songName");
        //对于登录用户，记录其下载记录
        recordDownloadService.recordDownload(req,songId);
        resp.setContentType("audio/mp3");
        resp.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(System.currentTimeMillis()+songName+".mp3", "utf8"));
        BufferedOutputStream out = new BufferedOutputStream(resp.getOutputStream());
        InputStream bis=null;
        if(songAddress.contains("http")) {
            //在另外服务器的文件
            URL url = new URL(songAddress);
            URLConnection uc = url.openConnection();
            bis=new BufferedInputStream(uc.getInputStream());
        }else {
            //在服务器内部的文件
            songAddress=req.getSession().getServletContext().getRealPath(songAddress);
            bis = new BufferedInputStream(new FileInputStream(new File(songAddress)));
        }
        int len = 0;
        byte[] temp=new byte[1024];
        while((len = bis.read(temp)) != -1){
            out.write(temp,0,len);
            out.flush();
        }
        out.close();
        bis.close();
    }
}

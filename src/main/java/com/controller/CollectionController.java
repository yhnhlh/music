package com.controller;

import com.model.User;
import com.service.CollectionService;
import com.utils.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class CollectionController {
    @Autowired
    CollectionService collectionService;
    @RequestMapping("collectSong.do")
    public void   Collection(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        String songId = req.getParameter("songId");
        User user = Request.getUserFromHttpServletRequest(req);
        boolean isCollected=collectionService.collectionChange(req,Integer.parseInt(songId));
        PrintWriter pw = resp.getWriter();
        pw.print(isCollected+"");
        pw.flush();
        pw.close();
    }

}

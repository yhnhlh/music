package com.controller;

import com.utils.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LogoutController {
    @RequestMapping("logout.do")
    public void Logout(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();
        Constants.isLogin=0;
        Constants.isManger=0;
        resp.sendRedirect("index.jsp");
    }
}

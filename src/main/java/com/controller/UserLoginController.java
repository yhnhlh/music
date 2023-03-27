package com.controller;

import com.model.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;
import com.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UserLoginController {
    @Autowired
    UserService userService;
    @RequestMapping("login.do")
    public void UserLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String email = req.getParameter("email");
        String userpwd = req.getParameter("password");
        User user1=new User();
        user1.setEmail(email);
        user1.setPassword(userpwd);
        User user = userService.userLogin(user1);
        if(user!=null){
            Constants.isLogin=1;
            req.getSession().setAttribute("user",user);
            if(userService.isHasPrivilege(req)){
                Constants.isManger=1;
                resp.sendRedirect("main.jsp");
                return;
            }
            resp.sendRedirect("index.jsp");
        }else {
            req.setAttribute("msg","用户名或密码错误");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }
}

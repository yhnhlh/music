package com.controller;

import com.model.User;
import com.service.PersonalRecService;
import com.service.UserService;
import com.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class RegisterController {
    @Autowired
    PersonalRecService personalRecService;
    @Autowired
    UserService userService;
    @RequestMapping("register.do")
    public void RegisterUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user=new User();
        System.out.println("111");
        String email=req.getParameter("email");
        String pwd1=req.getParameter("password1");
        String pwd2=req.getParameter("password2");
        String username=req.getParameter("username");
        if(userService.isEmailExisted(email)){
            req.setAttribute("msg","用户名已存在");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }else if(pwd1==pwd2){
            req.setAttribute("msg","两次密码不一致");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }else {
            user.setEmail(email);
            user.setPassword(pwd1);
            user.setUserName(username);
            if(userService.insert(user)){
                Constants.isLogin=1;
                User user1 = userService.userLogin(user);
                req.getSession().setAttribute("user",user1);
                personalRecService.initializePersonalRecList(req);
                resp.sendRedirect("index.jsp");
            }
        }
    }

}

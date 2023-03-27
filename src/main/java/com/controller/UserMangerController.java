package com.controller;

import com.model.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserMangerController {
    @Autowired
    private UserService userService;
    @RequestMapping("userManager.do")
    public void UserManger(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String flag = req.getParameter("flag");
        if("addUser".equals(flag)){
            this.addUser(req,resp);
        }else if("findUser".equals(flag)){
            this.findUser(req,resp);
        }else if("preUpdate".equals(flag)){
            this.preUpdate(req,resp);
        }else if("modifyUser".equals(flag)){
            this.modifyUser(req,resp);
        }else if ("findUsers".equals(flag)){
            this.findUsers(req,resp);
        }else{
            this.dropUser(req,resp);
        }
    }
    /**
     * 处理查询单个用户请求
     */
    private void findUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String email = req.getParameter("email");
        User user = userService.selectByEmail(email);
        List<User> userList=new ArrayList<>();
        userList.add(user);
        req.setAttribute("userList",userList);
        req.getRequestDispatcher("userList.jsp").forward(req,resp);


    }

    /**
     * 处理查询所有用户请求
     */
    private void findUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        List<User> userList = userService.getAllRecords();
        req.setAttribute("userList",userList);
        System.out.println(userList);
        req.getRequestDispatcher("userList.jsp").forward(req,resp);
    }

    /**
     * 预更新查询
     */
    private void preUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String email = req.getParameter("email");
        User user = userService.selectByEmail(email);
        req.setAttribute("user",user);
        req.getRequestDispatcher("userUpdate.jsp").forward(req,resp);
    }

    /**
     * 处理更新用户请求
     */
    private void modifyUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String userId = req.getParameter("userId");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String userName = req.getParameter("userName");
        int i = userService.updateUser(Integer.parseInt(userId), email, password, userName);
        System.out.println(i);
        if(i>0){
            req.getRequestDispatcher("ok.jsp").forward(req,resp);
        }


    }
    /**
     * 处理删除用户的请求
     */
    private  void dropUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String userId = req.getParameter("userId");
        userService.deleteById(Integer.parseInt(userId));
        req.getRequestDispatcher("ok.jsp").forward(req,resp);
    }
    /**
     * 处理添加用户的请求
     */
    private void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String userName = req.getParameter("userName");
        User user=new User();
        user.setEmail(email);
        user.setUserName(userName);
        user.setPassword(password);
        userService.insert(user);
        req.getRequestDispatcher("ok.jsp").forward(req,resp);
    }
}

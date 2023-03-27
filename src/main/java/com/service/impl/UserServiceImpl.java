package com.service.impl;

import com.dao.UserDao;
import com.model.Role;
import com.model.User;
import com.service.UserService;
import com.utils.Request;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User userLogin(User u) {
        User user = userDao.selectByUser(u);
        return user;
    }

    @Override
    public boolean isHasPrivilege(HttpServletRequest request) {
        boolean isHasPrivilege=false;
        User user1 = Request.getUserFromHttpServletRequest(request);
        User user = userDao.selectByUser(user1);
        if(user==null) {
            return isHasPrivilege;
        }
        Role role=userDao.selectRoleByUserId(user.getUserId());
        if(role!=null) {
            isHasPrivilege=true;
        }
        return isHasPrivilege;
    }

    @Override
    public boolean insert(User u) {
        boolean isInsertSuccessful=false;
        int affectedRows=userDao.insert(u);
        if(affectedRows>0) {
            isInsertSuccessful=true;
        }
        return isInsertSuccessful;
    }

    @Override
    public boolean isEmailExisted(String email) {
        boolean isEmailExisted=false;
        User result  = userDao.selectByEmail(email);
        if(result!=null) {
            isEmailExisted=true;
        }
        return isEmailExisted;
    }

    @Override
    public User selectByEmail(String email) {
        return userDao.selectByEmail(email);
    }

    @Override
    public void deleteById(int userId) {
        userDao.deleteById(userId);
    }

    @Override
    public List<User> getAllRecords() {
        return userDao.selectAll();
    }

    @Override
    public int updateUser(int userId, String email, String password, String userName) {
        return userDao.updateUser(userId,email,password,userName);
    }
}

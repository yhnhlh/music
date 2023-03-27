package com.service;

import com.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {
    /**
     * 根据帐号和密码查找用户
     * @return
     * 若找到返回User
     */
    User userLogin(User user);
    /**
     * 判定当前用户是否具备权限
     * @param request
     * @return
     * 若有，返回true
     */
    public boolean isHasPrivilege(HttpServletRequest request);

    /**
     * 向user用户表中插入新的记录
     * @param u
     * 用户User对象
     * @return
     * 若插入成功返回true
     */
    public boolean insert(User u);

    /**
     * 检验指定的邮箱帐号是否存在
     * @param email
     * 邮箱帐号
     * @return
     * 若存在返回true
     */
    public boolean isEmailExisted(String email);

    /**
     * 检验指定的邮箱帐号的用户
     * @param email
     * 邮箱帐号
     * @return
     * 若存在返回true
     */
    public User selectByEmail(String email);

    /**
     * 根据数组里面的Id删除对应的用户
     * @param userId
     */
    public void deleteById(int userId);


    /**
     * 获取所有的用户记录
     * @return
     * 若没有，则返回null
     */
    public List<User> getAllRecords();

    /**
     * 修改用户信息
     * @param email
     * @param password
     * @param  userName
     * @return
     * 若成功，返回1
     */

    public int updateUser(int userId,String email,String password,String userName);

}

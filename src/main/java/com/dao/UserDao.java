package com.dao;

import com.model.Role;
import com.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {


    /**
     * 根据某个用户的email和password进行查询
     * @param u
     * 用户User对象
     * @return
     * 若查询成功返回查询到的对象，否则返回null
     */
    @Select("select * from user where email=#{email} and password=#{password}")
    public User selectByUser(User u);

    /**
     * 根据某个email记录进行查询
     * @param email
     * 邮箱帐号
     * @return
     * 若查询成功返回查询到的对象，否则返回null
     */

    @Select("select * from user where email=#{email}")
    public User selectByEmail(String email);

    /**
     * 向user用户表中插入新的记录
     * @param u
     * 用户User对象
     * @return
     * 若插入成功返回1,否则返回0,即返回受影响的行数
     */
    @Insert("insert into user(email,password,userName) values(#{email},#{password},#{userName})")
    public int insert(User u);

    /**
     * 查询所有的用户记录
     * @return
     * 若没有，则返回null
     */
    @Select("select * from user")
    public List<User> selectAll();

    /**
     * 查询所有的用户Id记录
     * @return
     * 若没有，则返回null
     */
    @Select("select userId from user")
    public List<Integer> selectAllUserId();

    @Delete("delete from user where userId= #{userId}")
    public void deleteById(int userId);

    /**
     * 根据用户Id查询当前用户的角色信息
     * @param userId
     * 当前用户的Id
     * @return
     * 若没有，则返回null
     */
    @Select("select * from role where roleId in (select roleId from userrole where userId =#{userId} )")
    public Role selectRoleByUserId(int userId);

    @Update("update user set email=#{email},password=#{password},userName= #{userName} where userId=#{userId}")
    public int updateUser(int userId,String email,String password,String userName);

}

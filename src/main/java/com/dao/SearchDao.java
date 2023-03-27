package com.dao;

import com.model.Review;
import com.model.Song;
import com.model.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchDao {

    /**
     * 根据关键字模糊查询歌曲信息
     * @param keyword
     * 关键字
     * @return
     * 若查询不到，返回empty
     */
    @Select("select * from song where songName like concat('%',#{keyword},'%')")
    List<Song> selectSongLikeKeyword(String keyword);

    /**
     * 根据关键字模糊查询评论信息
     * @param keyword
     * 评论信息
     * @return
     * 若查询不到，返回empty
     */
    @Select("select reviewId,userName,review,reviewTime \n" +
            "\t\tfrom \n" +
            "\t\t\t( select * from review where review like concat('%',#{keyword},'%') ) as reviewTb,user\n" +
            "\t\twhere reviewTb.userId=user.userId")
    List<Review> selectReviewLikeKeyword(String keyword);

    /**
     * 根据关键字模糊查询用户信息
     * @param keyword
     * 用户名/用户邮箱
     * @param userId
     * @return
     * 若查询不到，返回empty
     */
    @Select("select * from (select * from user where userId != #{arg1} )as userTb  \n" +
            "\t\twhere userName like concat('%',#{arg0},'%') \n" +
            "\t\t\t  or \n" +
            "\t\t\t  email like concat('%',#{arg0},'%') ")
    List<User> selectUserLikeKeyword(String keyword, int userId);
}

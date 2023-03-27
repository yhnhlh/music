package com.dao;

import com.model.Collection;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectionDao {
    /**
     * 查询用户对某歌曲的收藏
     * @param collection
     * 记录对象
     * @return
     * 若没有收藏，则返回null
     */

    @Select("select * from collection where userId=#{userId} and songId=#{songId}")
    public Collection selectByCollection(Collection collection);

    /**
     * 删除收藏记录
     * @param
     *
     */
    @Delete("delete from collection where userId=#{userId} and songId=#{songId}")
    public void deleteById(@Param("userId") int userId,@Param("songId") int songId);

    /**
     * 添加新记录
     * @param collection
     */
    @Insert("insert into collection(userId,songId) values(#{userId},#{songId})")
    public void insert(Collection collection);

    /**
     * 查询所有用户的收藏记录
     * @return
     */
    @Select("select * from collection")
    public List<Collection> selectAll();

}

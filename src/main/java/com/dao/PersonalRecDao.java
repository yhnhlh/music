package com.dao;

import com.model.Song;
import com.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PersonalRecDao {
    /**
     * 从表A中获取当前用户的个性化推荐列表
     * @param user
     * @return
     * 初始化为随机歌曲列表
     */
    @Select("select * from reca,song\n" +
            "\t\twhere reca.userId=#{userId} and reca.songId=song.songId")
    List<Song> selectPersonalRecFromA(User user);

    /**
     * 从表B中获取当前用户的个性化推荐列表
     * @param user
     * @return
     * 初始化为随机歌曲列表
     */
    @Select("select * from recb,song\n" +
            "\t\twhere recb.userId=#{userId} and recb.songId=song.songId")
    List<Song> selectPersonalRecFromB(User user);

    /**
     * 像reca表中插入数据
     * @param userId
     * 用户id
     * @param songId
     * 歌曲id
     */
    @Insert("insert into reca(userId,songId) values(#{0},#{1})")
    void insertRecA(int userId, int songId);

    /**
     * 像recb表中插入数据
     * @param userId
     * 用户id
     * @param songId
     * 歌曲id
     */
    @Insert("insert into recb(userId,songId) values(#{0},#{1})")
    void insertRecB(int userId, int songId);

    /**
     * 根据id从recB表中删除数据
     * @param userId
     */

    @Delete("delete from recb where userId=#{userId}")
    void deleteBByUserId(int userId);

    /**
     * 根据id从recA表中删除数据
     * @param userId
     */
    @Delete("delete from reca where userId=#{userId}")
    void deleteAByUserId(int userId);

    /**
     * 将List里面的songId和userId批量插入A表
     * @param songList
     * 包含歌曲Id的信息列表
     * @param userId
     * 用户的Id
     */

    @Insert("<script>"+
                "\t\tinsert into reca(userId,songId) values\n" +
            "\t\t<foreach collection=\"param1\" item=\"song\" open=\"\" close=\"\" separator=\",\">  \n" +
            "           (#{param2},#{song.songId})\n" +
            "        </foreach>"
            +"</script>")
    void insertListIntoRecA(List<Song> songList, int userId);

    /**
     * 将List里面的songId和userId批量插入B表
     * @param songList
     * 包含歌曲Id的信息列表
     * @param userId
     * 用户的Id
     */
    @Insert("<script>"+
                "insert into recb(userId,songId) values\n" +
            "\t\t<foreach collection=\"param1\" item=\"song\" open=\"\" close=\"\" separator=\",\">  \n" +
            "           (#{param2},#{song.songId})\n" +
            "        </foreach>"
            +"</script>")
    void insertListIntoRecB(List<Song> songList, int userId);

    /***
     * 将数组里面的songId和userId批量插入B表
     * @param recSongIds
     * songId数组
     * @param userId
     * 用户的Id
     */
    @Insert("<script>"+
                "insert into recb(userId,songId) values\n" +
            "\t\t<foreach collection=\"param1\" item=\"songId\" open=\"\" close=\"\" separator=\",\">  \n" +
            "           (#{param2},#{songId})\n" +
            "        </foreach>"
            +"</script>" )
    void insertArrayIntoRecB(Integer[] recSongIds, Integer userId);

    /***
     * 将数组里面的songId和userId批量插入A表
     * @param recSongIds
     * songId数组
     * @param userId
     * 用户的Id
     */
    @Insert("<script>"+
              "insert into reca(userId,songId) values\n" +
            "\t\t<foreach collection=\"param1\" item=\"songId\" open=\"\" close=\"\" separator=\",\">  \n" +
            "           (#{param2},#{songId})\n" +
            "        </foreach>"
            +"</script>")
    void insertArrayIntoRecA(Integer[] recSongIds, Integer userId);
}

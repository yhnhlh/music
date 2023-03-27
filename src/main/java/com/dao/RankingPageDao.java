package com.dao;

import com.model.Song;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface   RankingPageDao {
    /**
     * 获取最近一周排行榜列表
     * @return
     * 如果没有，则返回null
     */
    @Select("select * from weekRanking,song\n" +
            "\t\twhere weekRanking.songId=song.songId order by trendingCoefficient desc")
    List<Song> selectRecentWeekRanking();

    /**
     * 获取最近一个月排行榜列表
     * @return
     * 如果没有，则返回null
     */
    @Select("select * from monthRanking,song\n" +
            "\t\twhere monthRanking.songId=song.songId order by trendingCoefficient desc")
    List<Song> selectRecentMonthRanking();

}

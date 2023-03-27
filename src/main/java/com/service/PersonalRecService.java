package com.service;


import com.model.Song;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface PersonalRecService {

	/**
	 * 获取当前用户个性化推荐音乐列表，并带上是否已经收藏的标记.
	 *
	 * @param request HttpServletRequest
	 * @return 若没有获取到，返回null
	 */
	List<Song> getPersonalDailyRecWithCollectionFlag(HttpServletRequest request);

	/**
	 * 初始化当前用户的个性化音乐推荐列表
	 *
	 * @param request HttpServletRequest
	 */
	void initializePersonalRecList(HttpServletRequest request);
	
}

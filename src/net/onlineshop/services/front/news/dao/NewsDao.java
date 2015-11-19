/**
 * 2012-7-8
 * 
 */
package net.onlineshop.services.front.news.dao;

import java.util.List;

import net.onlineshop.core.DaoManager;
import net.onlineshop.services.front.news.bean.News;


/**
 * 
 * @param <T>
 */
public interface NewsDao extends DaoManager<News> {

	/**
	 * @param e
	 * @return
	 */
	List<News> selecIndexNews(News e);

	/**
	 * @return
	 */
	List<String> selectAllMd5();

	/**
	 * @param e
	 */
	void updateInBlackList(String e);

	/**
	 * @param news
	 */
	void sync(News news);

	List<News> selectNoticeList(News news);

	News selectSimpleOne(News news);

}

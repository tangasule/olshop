/**
 * 2012-7-8
 * 
 */
package net.onlineshop.services.manage.news.dao;

import java.util.List;

import net.onlineshop.core.DaoManager;
import net.onlineshop.services.manage.news.bean.News;


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
	 * @param news
	 */
	void sync(News news);

	void updateDownOrUp(News news);

	int selectCount(News news);

}

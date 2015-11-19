/**
 * 2012-7-8
 * 
 */
package net.onlineshop.services.manage.indexImg.dao;

import java.util.List;

import net.onlineshop.core.DaoManager;
import net.onlineshop.services.manage.indexImg.bean.IndexImg;


public interface IndexImgDao extends DaoManager<IndexImg> {

	/**
	 * @param i
	 * @return
	 */
	List<IndexImg> getImgsShowToIndex(int i);

}

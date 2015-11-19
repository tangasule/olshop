/**
 * 2012-7-8
 * 
 */
package net.onlineshop.services.front.indexImg.impl;

import java.util.List;

import net.onlineshop.core.ServersManager;
import net.onlineshop.services.front.indexImg.IndexImgService;
import net.onlineshop.services.front.indexImg.bean.IndexImg;
import net.onlineshop.services.front.indexImg.dao.IndexImgDao;


/**
 * 
 */
public class IndexImgServiceImpl extends ServersManager<IndexImg> implements
		IndexImgService {

	private IndexImgDao indexImgDao;

	public IndexImgDao getIndexImgDao() {
		return indexImgDao;
	}

	public void setIndexImgDao(IndexImgDao indexImgDao) {
		this.indexImgDao = indexImgDao;
	}

	@Override
	public List<IndexImg> getImgsShowToIndex(int i) {
		return indexImgDao.getImgsShowToIndex(i);
	}

}

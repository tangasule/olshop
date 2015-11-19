/**
 * 2012-7-8
 * 
 */
package net.onlineshop.services.manage.indexImg.dao.impl;

import java.util.List;

import net.onlineshop.core.dao.BaseDao;
import net.onlineshop.core.dao.page.PagerModel;
import net.onlineshop.services.manage.comment.bean.Comment;
import net.onlineshop.services.manage.indexImg.bean.IndexImg;
import net.onlineshop.services.manage.indexImg.dao.IndexImgDao;


/**
 * 
 */
public class IndexImgDaoImpl implements IndexImgDao {
	private BaseDao dao;

	public void setDao(BaseDao dao) {
		this.dao = dao;
	}

	public PagerModel selectPageList(IndexImg e) {
		return dao.selectPageList("manage.indexImg.selectPageList",
				"manage.indexImg.selectPageCount", e);
	}

	public List selectList(IndexImg e) {
		return dao.selectList("manage.indexImg.selectList", e);
	}

	public IndexImg selectOne(IndexImg e) {
		return (IndexImg) dao.selectOne("manage.indexImg.selectOne", e);
	}

	public int delete(IndexImg e) {
		return dao.delete("manage.indexImg.delete", e);
	}

	public int update(IndexImg e) {
		return  dao.update("manage.indexImg.update", e);
	}

	/**
	 * 批量删除用户
	 * 
	 * @param ids
	 */
	public int deletes(String[] ids) {
		IndexImg e = new IndexImg();
		for (int i = 0; i < ids.length; i++) {
			e.setId(ids[i]);
			delete(e);
		}
		return 0;
	}

	public int insert(IndexImg e) {
		return  dao.insert("manage.indexImg.insert", e);
	}

	/**
	 * @param bInfo
	 */
	public List<IndexImg> getLoseList(IndexImg bInfo) {
		return dao.selectList("manage.indexImg.getLoseList", bInfo);
	}
	
	@Override
	public int deleteById(int id) {
		return dao.delete("manage.indexImg.deleteById",id);
	}

	@Override
	public List<IndexImg> getImgsShowToIndex(int i) {
		return dao.selectList("manage.indexImg.getImgsShowToIndex",i);
	}
	public IndexImg selectById(String id) {
		return (IndexImg) dao.selectOne(id);
	}
}

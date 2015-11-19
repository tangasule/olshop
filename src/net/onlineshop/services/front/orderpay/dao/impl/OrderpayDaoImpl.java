package net.onlineshop.services.front.orderpay.dao.impl;import java.util.List;import net.onlineshop.core.dao.BaseDao;import net.onlineshop.core.dao.page.PagerModel;import net.onlineshop.services.front.orderpay.bean.Orderpay;import net.onlineshop.services.front.orderpay.dao.OrderpayDao;public class OrderpayDaoImpl implements OrderpayDao {	private BaseDao dao;	public void setDao(BaseDao dao) {		this.dao = dao;	}	public PagerModel selectPageList(Orderpay e) {		return dao.selectPageList("front.orderpay.selectPageList",				"front.orderpay.selectPageCount", e);	}	public List selectList(Orderpay e) {		return dao.selectList("front.orderpay.selectList", e);	}	public Orderpay selectOne(Orderpay e) {		return (Orderpay) dao.selectOne("front.orderpay.selectOne", e);	}	public int delete(Orderpay e) {		return dao.delete("front.orderpay.delete", e);	}	public int update(Orderpay e) {		return dao.update("front.orderpay.update", e);	}	public int deletes(String[] ids) {		Orderpay e = new Orderpay();		for (int i = 0; i < ids.length; i++) {			e.setId(ids[i]);			delete(e);		}		return 0;	}	public int insert(Orderpay e) {		return dao.insert("front.orderpay.insert", e);	}	public int deleteById(int id) {		return dao.delete("front.orderpay.deleteById", id);	}	@Override	public Orderpay selectById(String id) {		return (Orderpay) dao.selectOne("front.orderpay.selectById", id);	}}
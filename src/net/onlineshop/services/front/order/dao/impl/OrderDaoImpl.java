package net.onlineshop.services.front.order.dao.impl;import java.util.List;import net.onlineshop.core.dao.BaseDao;import net.onlineshop.core.dao.page.PagerModel;import net.onlineshop.services.front.order.bean.Order;import net.onlineshop.services.front.order.bean.OrderSimpleReport;import net.onlineshop.services.front.order.dao.OrderDao;public class OrderDaoImpl implements OrderDao {	private BaseDao dao;	public void setDao(BaseDao dao) {		this.dao = dao;	}	public PagerModel selectPageList(Order e) {		return dao.selectPageList("front.order.selectPageList",				"front.order.selectPageCount", e);	}	public List selectList(Order e) {		return dao.selectList("front.order.selectList", e);	}	public Order selectOne(Order e) {		return (Order) dao.selectOne("front.order.selectOne", e);	}	public int delete(Order e) {		return dao.delete("front.order.delete", e);	}	public int update(Order e) {		return dao.update("front.order.update", e);	}	public int deletes(String[] ids) {		Order e = new Order();		for (int i = 0; i < ids.length; i++) {			e.setId(ids[i]);			delete(e);		}		return 0;	}	public int insert(Order e) {		return dao.insert("front.order.insert", e);	}	public int deleteById(int id) {		return dao.delete("front.order.deleteById", id);	}	public Order selectById(String id) {		return (Order) dao.selectOne("front.order.selectById", id);	}	@SuppressWarnings("unchecked")	@Override	public List<Order> selectOrderInfo(Order order) {		return dao.selectList("front.order.selectOrderInfo",order);	}	@Override	public OrderSimpleReport selectOrdersSimpleReport(String account) {		return (OrderSimpleReport) dao.selectOne("front.order.selectOrdersSimpleReport",account);	}}
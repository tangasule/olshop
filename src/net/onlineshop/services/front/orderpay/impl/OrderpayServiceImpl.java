package net.onlineshop.services.front.orderpay.impl;import net.onlineshop.core.ServersManager;import net.onlineshop.services.front.orderpay.OrderpayService;import net.onlineshop.services.front.orderpay.bean.Orderpay;import net.onlineshop.services.front.orderpay.dao.OrderpayDao;public class OrderpayServiceImpl extends ServersManager<Orderpay> implements		OrderpayService {	private OrderpayDao orderpayDao;	public void setOrderpayDao(OrderpayDao orderpayDao) {		this.orderpayDao = orderpayDao;	}}
package net.onlineshop.services.front.advert.impl;import net.onlineshop.core.ServersManager;import net.onlineshop.services.front.advert.AdvertService;import net.onlineshop.services.front.advert.bean.Advert;import net.onlineshop.services.front.advert.dao.AdvertDao;public class AdvertServiceImpl extends ServersManager<Advert> implements		AdvertService {	private AdvertDao advertDao;	public void setAdvertDao(AdvertDao advertDao) {		this.advertDao = advertDao;	}}
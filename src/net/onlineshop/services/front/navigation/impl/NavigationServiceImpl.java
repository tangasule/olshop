package net.onlineshop.services.front.navigation.impl;import net.onlineshop.core.ServersManager;import net.onlineshop.services.front.navigation.NavigationService;import net.onlineshop.services.front.navigation.bean.Navigation;import net.onlineshop.services.front.navigation.dao.NavigationDao;public class NavigationServiceImpl extends ServersManager<Navigation> implements		NavigationService {	private NavigationDao navigationDao;	public void setNavigationDao(NavigationDao navigationDao) {		this.navigationDao = navigationDao;	}}
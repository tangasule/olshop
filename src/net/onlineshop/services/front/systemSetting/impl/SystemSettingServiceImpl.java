package net.onlineshop.services.front.systemSetting.impl;import net.onlineshop.core.ServersManager;import net.onlineshop.services.front.systemSetting.SystemSettingService;import net.onlineshop.services.front.systemSetting.bean.SystemSetting;import net.onlineshop.services.front.systemSetting.dao.SystemSettingDao;public class SystemSettingServiceImpl extends ServersManager<SystemSetting>		implements SystemSettingService {	private SystemSettingDao systemSettingDao;	public void setSystemSettingDao(SystemSettingDao systemSettingDao) {		this.systemSettingDao = systemSettingDao;	}}
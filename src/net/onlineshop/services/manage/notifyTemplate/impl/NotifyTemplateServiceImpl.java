package net.onlineshop.services.manage.notifyTemplate.impl;import net.onlineshop.core.ServersManager;import net.onlineshop.services.manage.notifyTemplate.NotifyTemplateService;import net.onlineshop.services.manage.notifyTemplate.bean.NotifyTemplate;import net.onlineshop.services.manage.notifyTemplate.dao.NotifyTemplateDao;public class NotifyTemplateServiceImpl extends ServersManager<NotifyTemplate>		implements NotifyTemplateService {	private NotifyTemplateDao notifyTemplateDao;	public void setNotifyTemplateDao(NotifyTemplateDao notifyTemplateDao) {		this.notifyTemplateDao = notifyTemplateDao;	}}
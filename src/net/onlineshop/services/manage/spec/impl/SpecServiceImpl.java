package net.onlineshop.services.manage.spec.impl;import net.onlineshop.core.ServersManager;import net.onlineshop.services.manage.spec.SpecService;import net.onlineshop.services.manage.spec.bean.Spec;import net.onlineshop.services.manage.spec.dao.SpecDao;public class SpecServiceImpl extends ServersManager<Spec> implements		SpecService {	private SpecDao specDao;	public void setSpecDao(SpecDao specDao) {		this.specDao = specDao;	}}
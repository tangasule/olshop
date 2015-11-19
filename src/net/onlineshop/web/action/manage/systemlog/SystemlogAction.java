package net.onlineshop.web.action.manage.systemlog;import net.onlineshop.core.BaseAction;import net.onlineshop.services.manage.systemlog.SystemlogService;import net.onlineshop.services.manage.systemlog.bean.Systemlog;import org.apache.commons.lang.StringUtils;public class SystemlogAction extends BaseAction<Systemlog> {	private static final long serialVersionUID = 1L;	private SystemlogService systemlogService;	public SystemlogService getSystemlogService() {		return systemlogService;	}	protected void selectListAfter() {		pager.setPagerUrl("systemlog!selectList.action");	}	public void setSystemlogService(SystemlogService systemlogService) {		this.systemlogService = systemlogService;	}	public Systemlog getE() {		return this.e;	}	public void prepare() throws Exception {		if (this.e == null) {			this.e = new Systemlog();		}		super.initPageSelect();	}	public void insertAfter(Systemlog e) {		e.clear();	}		public String systemlogListAndDetail() throws Exception{		String type = getRequest().getParameter("type");		if(StringUtils.isNotBlank(type)){			e.setType(Integer.valueOf(type));		}		selectList();		return "systemlogListAndDetail";	}}
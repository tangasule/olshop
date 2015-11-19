package net.onlineshop.core.system.bean;

import net.onlineshop.core.dao.page.PagerModel;

/**
 * 权限
 * 
 *
 */
public class Privilege extends PagerModel{
	private String id;
	private String rid;
	private String mid;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public void clear() {
		// TODO Auto-generated method stub
		this.id = null;
		this.mid = null;
		this.rid = null;
	}

}

package net.onlineshop.services.manage.activity.bean;import java.io.Serializable;import java.text.ParseException;import java.util.Date;import net.onlineshop.core.util.DateTimeUtil;public class Activity extends net.onlineshop.services.common.Activity implements		Serializable {	private static final long serialVersionUID = 1L;	private boolean expire;// 活动是否已经到期true:已到期；false:未到期	private String activityEndDateTime;// 活动结束时间，例如：1天3小时35分30秒	private String discountFormat;//折扣格式化显示	//	private String queryProductID;//查询的商品ID		public void clear() {		super.clear();		expire = false;		activityEndDateTime = null;		discountFormat = null;//		queryProductID = null;	}		/**	 * 检查活动是否已结束	 * true:已到期；false:未到期	 * @return	 */	public boolean checkActivity(){		try {			return DateTimeUtil.compareDateTime(new Date(),DateTimeUtil.sdf.parse(super.getEndDate()));		} catch (ParseException e) {			e.printStackTrace();		}		return false;	}	public String getActivityEndDateTime() {		return activityEndDateTime;	}	public void setActivityEndDateTime(String activityEndDateTime) {		this.activityEndDateTime = activityEndDateTime;	}	public boolean isExpire() {		return expire;	}	public void setExpire(boolean expire) {		this.expire = expire;	}	public String getDiscountFormat() {		return discountFormat;	}	public void setDiscountFormat(String discountFormat) {		this.discountFormat = discountFormat;	}}
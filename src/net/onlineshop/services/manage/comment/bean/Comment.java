package net.onlineshop.services.manage.comment.bean;import java.io.Serializable;/** * 评论 *  *  *  */public class Comment extends net.onlineshop.services.common.Comment implements Serializable {	private static final long serialVersionUID = 1L;	private boolean selectCommentFromIndex;//true:查询吐槽评论列表		public void clear() {		super.clear();		selectCommentFromIndex = false;	}	public boolean isSelectCommentFromIndex() {		return selectCommentFromIndex;	}	public void setSelectCommentFromIndex(boolean selectCommentFromIndex) {		this.selectCommentFromIndex = selectCommentFromIndex;	}}
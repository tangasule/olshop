package net.onlineshop.services.front.comment;import java.util.List;import net.onlineshop.core.Services;import net.onlineshop.services.front.comment.bean.Comment;public interface CommentService extends Services<Comment> {	/**	 * 用户评价商品，评价成功后将该订单项设置为已评价	 * @param e	 * @return	 */	public int insertList(List<Comment> comments);}
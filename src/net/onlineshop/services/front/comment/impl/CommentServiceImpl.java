package net.onlineshop.services.front.comment.impl;import java.util.List;import net.onlineshop.core.ServersManager;import net.onlineshop.services.front.account.AccountService;import net.onlineshop.services.front.account.bean.Account;import net.onlineshop.services.front.account.dao.AccountDao;import net.onlineshop.services.front.comment.CommentService;import net.onlineshop.services.front.comment.bean.Comment;import net.onlineshop.services.front.comment.dao.CommentDao;import net.onlineshop.services.front.order.bean.Order;import net.onlineshop.services.front.order.dao.OrderDao;import net.onlineshop.services.front.orderdetail.bean.Orderdetail;import net.onlineshop.services.front.orderdetail.dao.OrderdetailDao;public class CommentServiceImpl extends ServersManager<Comment> implements		CommentService {	private CommentDao commentDao;	private OrderdetailDao orderdetailDao;	private OrderDao orderDao;	private AccountService accountService;	public void setAccountService(AccountService accountService) {		this.accountService = accountService;	}	public void setOrderDao(OrderDao orderDao) {		this.orderDao = orderDao;	}	public void setOrderdetailDao(OrderdetailDao orderdetailDao) {		this.orderdetailDao = orderdetailDao;	}	public void setCommentDao(CommentDao commentDao) {		this.commentDao = commentDao;	}		/**	 * 插入评论，并同时更新指定的订单项为已评论。	 */	public int insertList(List<Comment> comments){		if(comments==null || comments.size()==0){			throw new NullPointerException();		}				for(int i=0;i<comments.size();i++){			Comment item = comments.get(i);			commentDao.insert(item);			//设置指定的订单项为			Orderdetail orderdetail = new Orderdetail();			orderdetail.setId(String.valueOf(item.getOrderdetailID()));			orderdetail.setIsComment("y");//设置为已评价			orderdetailDao.update(orderdetail);		}				//检查用户的所有订单项是否都已进行了评论，如果都评论过了，则更新订单的closedComment字段为y，表示订单评论功能关闭。		String orderid = comments.get(0).getOrderID();		int commentsCount = commentDao.selectCount(orderid);		int orderdetailCount = orderdetailDao.selectCount(orderid);		if(commentsCount > 0 && orderdetailCount==commentsCount){			Order order = new Order();			order.setId(String.valueOf(orderid));			order.setClosedComment(Order.order_closedComment_y);//关闭点评			orderDao.update(order);		}				//点评送积分。点评一个订单项则送该用户5个积分，此数字可以再后台进行配置		int addScore = comments.size() * 5;				Account acc = new Account();		acc.setAccount(comments.get(0).getAccount());		acc.setAddScore(addScore);		accountService.updateScore(acc);		return 1;	}}
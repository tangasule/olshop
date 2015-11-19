package net.onlineshop.core.exception;

/**
 * 修改订单状态异常
 * 
 * ei
 * 
 */
public class UpdateOrderStatusException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * @param string
	 */
	public UpdateOrderStatusException(String arg0) {
		super(arg0);
	}

}

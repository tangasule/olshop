package net.onlineshop.services.manage.orderdetail.bean;import java.io.Serializable;import net.onlineshop.services.manage.product.bean.Product;public class Orderdetail extends net.onlineshop.services.common.Orderdetail		implements Serializable {	private static final long serialVersionUID = 1L;	private Product product;	public void clear() {		super.clear();		if (product != null) {			product.clear();			product = null;		}	}	public Product getProduct() {		return product;	}	public void setProduct(Product product) {		this.product = product;	}}
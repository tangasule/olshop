/**
 * 2012-7-8
 * 
 */
package net.onlineshop.services.front.indexImg;

import java.util.List;

import net.onlineshop.core.Services;
import net.onlineshop.services.front.indexImg.bean.IndexImg;
import net.onlineshop.services.front.product.bean.Product;


/**
 * 
 */
public interface IndexImgService extends Services<IndexImg> {

	/**
	 * 加载图片显示到门户
	 * @param i
	 */
	List<IndexImg> getImgsShowToIndex(int i);

}

package net.onlineshop.services.manage.system;

import net.onlineshop.core.Services;
import net.onlineshop.core.dao.page.PagerModel;
import net.onlineshop.core.system.bean.User;

public interface UserInteface extends Services<User> {
	/**
	 * @param e
	 * @return
	 */
	public User login(User e);
}

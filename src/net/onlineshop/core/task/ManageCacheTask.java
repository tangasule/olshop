package net.onlineshop.core.task;

import java.util.concurrent.TimeUnit;

import net.onlineshop.core.front.SystemManager;
import net.onlineshop.core.oscache.ManageCache;

import org.slf4j.LoggerFactory;

/**
 * 后台缓存定时更新
 * 
 * 
 * 
 */
public class ManageCacheTask implements Runnable {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ManageCacheTask.class);
//	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private ManageCache manageCache;

	public void setManageCache(ManageCache manageCache) {
		this.manageCache = manageCache;
	}

	@Override
	public void run() {
		while (true) {
			
			try {
//				TimeUnit.MINUTES.sleep(15);//单位：分钟
				TimeUnit.SECONDS.sleep(Long.valueOf(SystemManager.getInstance().get("task_SystemAutoNotifyTask_time")));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			logger.debug("OrderCancelTask.run...");
			try {
				manageCache.loadAllCache();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

}

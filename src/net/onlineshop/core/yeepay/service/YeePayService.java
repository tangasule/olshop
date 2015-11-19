package net.onlineshop.core.yeepay.service;

import java.util.Map;

import net.onlineshop.core.yeepay.model.BackData;
import net.onlineshop.core.yeepay.model.SendData;


public interface YeePayService {

	// 把加密后的信息存储到requestMap中
	public abstract Map<String, Object> saveDataToRequest(
			Map<String, Object> request, SendData sendData);
	public abstract SendData saveData(SendData sendData);
	public boolean checkBackData(BackData backData);
	
	

}
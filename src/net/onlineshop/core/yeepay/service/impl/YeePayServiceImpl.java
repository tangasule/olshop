package net.onlineshop.core.yeepay.service.impl;

import java.util.Map;

import net.onlineshop.core.front.SystemManager;
import net.onlineshop.core.yeepay.config.YeepayConfig;
import net.onlineshop.core.yeepay.model.BackData;
import net.onlineshop.core.yeepay.model.SendData;
import net.onlineshop.core.yeepay.service.YeePayService;
import net.onlineshop.core.yeepay.util.DigestUtil;
import net.onlineshop.services.common.Pay;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

public class YeePayServiceImpl implements YeePayService {


	// 补全SendData的数据, P2 p3,p5,p8, pd是前台注入
	private SendData finishSendData(SendData sendData) {
		sendData.setP0_Cmd("Buy");
		sendData.setP1_MerId(YeepayConfig.partner);
		sendData.setP4_Cur("CNY");
		sendData.setP6_Pcat("");
		sendData.setP7_Pdesc("");
		sendData.setP9_SAF("0");
		sendData.setPr_NeedResponse("0");
		return sendData;
	}

	// 完成数据的追加
	private String joinSendDataParam(SendData sendData) {
		// 填充的所有数据
		sendData = this.finishSendData(sendData);
		StringBuffer infoBuffer = new StringBuffer();
		infoBuffer.append(sendData.getP0_Cmd());
		infoBuffer.append(sendData.getP1_MerId());
		infoBuffer.append(sendData.getP2_Order());
		infoBuffer.append(sendData.getP3_Amt());
		infoBuffer.append(sendData.getP4_Cur());
		infoBuffer.append(sendData.getP5_Pid());
		infoBuffer.append(sendData.getP6_Pcat());
		infoBuffer.append(sendData.getP7_Pdesc());
		infoBuffer.append(sendData.getP8_Url());
		infoBuffer.append(sendData.getP9_SAF());
		infoBuffer.append(sendData.getPa_MP());
		infoBuffer.append(sendData.getPd_FrpId());
		infoBuffer.append(sendData.getPr_NeedResponse());
		return infoBuffer.toString();
	}


	
	public SendData saveData(SendData sendData) {
		// 返回了被追加的字符串
		String joinParam = joinSendDataParam(sendData);
		sendData.setHmac(DigestUtil.hmacSign(joinParam, YeepayConfig.key));
		return sendData;
	}
	
	public Map<String, Object> saveDataToRequest(Map<String, Object> request,SendData sendData) {
		// 返回了被追加的字符串
		String joinParam = joinSendDataParam(sendData);
		// 把明文与密文都存储到相应的requestMap中
		request.put("p0_Cmd", sendData.getP0_Cmd());
		request.put("p1_MerId", sendData.getP1_MerId());
		request.put("p2_Order", sendData.getP2_Order());
		request.put("p3_Amt", sendData.getP3_Amt());
		request.put("p4_Cur", sendData.getP4_Cur());
		request.put("p5_Pid", sendData.getP5_Pid());
		request.put("p6_Pcat", sendData.getP6_Pcat());
		request.put("p7_Pdesc", sendData.getP7_Pdesc());
		request.put("p8_Url", sendData.getP8_Url());
		request.put("p9_SAF", sendData.getP9_SAF());
		request.put("pa_MP", sendData.getPa_MP());
		request.put("pd_FrpId", sendData.getPd_FrpId());
		request.put("pr_NeedResponse", sendData.getPr_NeedResponse());
		request.put("hmac", DigestUtil.hmacSign(joinParam, YeepayConfig.key));
		return request;
	}

	/*--------------------------------上面的是是发送请求需要调用的方法---------------------*/
	/*--------------------------------下面的是是接受结果需要调用的方法---------------------*/
	// 初始化返回来的数据,并且把数据封装到了backData中
//	private BackData finishBackData(Map<String, String[]> parameters) {
//		BackData backData = new BackData();
//		backData.setR0_Cmd(parameters.get("r0_Cmd")[0]);
//		backData.setP1_MerId(parameters.get("p1_MerId")[0]);
//		backData.setR1_Code(parameters.get("r1_Code")[0]);
//		backData.setR2_TrxId(parameters.get("r2_TrxId")[0]);
//		backData.setR3_Amt(parameters.get("r3_Amt")[0]);
//		backData.setR4_Cur(parameters.get("r4_Cur")[0]);
//		backData.setR5_Pid(parameters.get("r5_Pid")[0]);
//		backData.setR6_Order(parameters.get("r6_Order")[0]);
//		backData.setR7_Uid(parameters.get("r7_Uid")[0]);
//		backData.setR8_MP(parameters.get("r8_MP")[0]);
//		backData.setR9_BType(parameters.get("r9_BType")[0]);
//		return backData;
//	}

	// 完成返回数据的追加
	private String joinBackDataParam(BackData backData) {
		// 此方法,把返回来的参数封装到到backData中
//		BackData backData = this.finishBackData(parameters);
		// 追加字符串,为加密验证做准备
		StringBuffer infoBuffer = new StringBuffer();
		infoBuffer.append(backData.getP1_MerId());
		infoBuffer.append(backData.getR0_Cmd());
		infoBuffer.append(backData.getR1_Code());
		infoBuffer.append(backData.getR2_TrxId());
		infoBuffer.append(backData.getR3_Amt());
		infoBuffer.append(backData.getR4_Cur());
		infoBuffer.append(backData.getR5_Pid());
		infoBuffer.append(backData.getR6_Order());
		infoBuffer.append(backData.getR7_Uid());
		infoBuffer.append(backData.getR8_MP());
		infoBuffer.append(backData.getR9_BType());
		return infoBuffer.toString();
	}

	// 对返回来的数据进行加密,并且和传过来的密文进行比较,如果OK则说明数据没有被篡改
	public boolean checkBackData(BackData backData) {
		String joinParam = this.joinBackDataParam(backData);
		// 加密后得到自己的密文
		String md5 = DigestUtil.hmacSign(joinParam.toString(), YeepayConfig.key);
		// 密文和传过来密文比较
		return md5.equals(backData.getHmac());
	}

}

<%@page import="net.onlineshop.core.FrontContainer"%>
<%@page import="net.onlineshop.web.action.manage.account.AccountAction"%>
<%@page import="org.slf4j.LoggerFactory"%>
<%@page import="org.slf4j.Logger"%>
<%@page import="net.onlineshop.services.front.account.AccountService"%>
<%@page
	import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="net.onlineshop.core.front.SystemManager"%>
<%@page import="net.onlineshop.services.front.account.bean.LoginTypeEnum"%>
<%@page import="net.onlineshop.services.front.account.bean.Account"%>
<%@page import="net.onlineshop.core.ManageContainer"%>
<%@page import="net.onlineshop.core.pay.alipay.alipayescow.util.AlipayNotify"%>
<%
	/* *
	 功能：支付宝页面跳转同步通知页面
	 版本：3.2
	 日期：2011-03-17
	 说明：
	 以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
	 该代码仅供学习和研究支付宝接口使用，只是提供一个参考。

	 //***********页面功能说明***********
	 该页面可在本机电脑测试
	 可放入HTML等美化页面的代码、商户业务逻辑程序代码
	 //********************************
	 * */
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.Map"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>支付宝页面跳转同步通知页面</title>
</head>
<body>
	<%
		//获取支付宝GET过来反馈信息
		Map<String, String> params = new HashMap<String, String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter
				.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}

		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
		//支付宝用户号
		String user_id = new String(request.getParameter("user_id")
				.getBytes("ISO-8859-1"), "UTF-8");

		//授权令牌
		String token = new String(request.getParameter("token").getBytes(
				"ISO-8859-1"), "UTF-8");

		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//

		//计算得出通知验证结果
		boolean verify_result = AlipayNotify.verify(params);
		System.out.println("params=" + params);
		if (verify_result) {//验证成功
			//////////////////////////////////////////////////////////////////////////////////////////
			//请在这里加上商户的业务逻辑程序代码
			//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——

			//判断是否在商户网站中已经做过了这次通知返回的处理
			//如果没有做过处理，那么执行商户的业务程序
			//如果有做过处理，那么不执行商户的业务程序

			//该页面可做页面美工编辑
			out.println("验证成功");

			//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——

			Account acc = (Account) request.getSession().getAttribute(
					FrontContainer.USER_INFO);
			if (acc == null) {
				acc = new Account();
				request.getSession().setAttribute(FrontContainer.USER_INFO,
						acc);
			} else {
				acc.clear();
			}

			try {
				WebApplicationContext app = WebApplicationContextUtils
						.getWebApplicationContext(request.getSession()
								.getServletContext());
				AccountService accountService = (AccountService) app
						.getBean("accountServiceFront");
				Account alipayAcc = new Account();
				alipayAcc.setAlipayUseId(user_id);

				Logger logger = LoggerFactory
						.getLogger(AccountAction.class);
				synchronized (FrontContainer.insert_outAccount_lock) {
					alipayAcc = accountService.selectOne(alipayAcc);//根据支付宝用户ID查询用户是否存在，如果不存在则系统内部添加一个账号
					logger.debug("alipayAcc=" + alipayAcc);
					if (alipayAcc == null) {
						alipayAcc = new Account();
						//alipayAcc.setAccount("_out_"+System.currentTimeMillis());
						alipayAcc.setAlipayUseId(user_id);
						acc.setLoginType(LoginTypeEnum.alipay);
						logger.debug("acc.getLoginType()="
								+ acc.getLoginType());
						alipayAcc.setAccountType(acc.getLoginType().toString());
						//alipayAcc.setNickname("_out_");
						accountService.insertOutAccount(alipayAcc);
					} else {
						acc.setAccount(alipayAcc.getAccount());
					}

					acc.setAlipayUseId(user_id);//用户ID，唯一确定一个支付宝用户
					acc.setAccountType(LoginTypeEnum.alipay.toString());
					acc.setLoginType(LoginTypeEnum.alipay);
					acc.setNickname(params.get("real_name"));
					response.sendRedirect(SystemManager.systemSetting
							.getWww());
				}
			} catch (Exception e) {
				System.out.println("异常=" + e);
				e.printStackTrace();
			}
			//////////////////////////////////////////////////////////////////////////////////////////
		} else {
			//该页面可做页面美工编辑
			out.println("验证失败");
		}
	%>
</body>
</html>
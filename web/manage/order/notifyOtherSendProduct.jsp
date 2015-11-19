<%@page import="net.onlineshop.core.front.SystemManager"%>
<%@page import="net.onlineshop.services.manage.order.bean.Order"%>
<%@page import="net.onlineshop.services.manage.order.OrderService"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="net.onlineshop.core.pay.alipay.alipayescow.util.AlipaySubmit"%>
<%@page import="org.dom4j.Node"%>
<%@page import="org.dom4j.Document"%>
<%@page import="org.dom4j.DocumentHelper"%>
<%
/* *
 *功能：确认发货接口接入页
 */
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="net.onlineshop.core.pay.alipay.alipayescow.config.*"%>
<%@ page import="java.util.*"%>
	<%
		
		try{
			////////////////////////////////////请求参数//////////////////////////////////////
			String orderid = request.getParameter("orderid");
			//交易号
			String trade_no = new String(request.getParameter("WIDtrade_no").getBytes("ISO-8859-1"),"UTF-8");
			//必填
	
			//物流公司名称
			//String logistics_name = new String(request.getParameter("WIDlogistics_name").getBytes("ISO-8859-1"),"UTF-8");
			String logistics_name = request.getParameter("expressCompanyName");//new String(request.getParameter("expressCompanyName").getBytes("ISO-8859-1"),"UTF-8");
			logistics_name = SystemManager.manageExpressMap.get(logistics_name);
			//必填
	
			//物流发货单号
			String invoice_no = new String(request.getParameter("WIDinvoice_no").getBytes("ISO-8859-1"),"UTF-8");
			//物流运输类型
			String transport_type = new String(request.getParameter("WIDtransport_type").getBytes("ISO-8859-1"),"UTF-8");
			if(transport_type.equals("POST")){
				logistics_name = "中国邮政";
			}else if(transport_type.equals("no")){//不需要物流
				
			}
			
			String confirmSendProductRemark = new String(request.getParameter("confirmSendProductRemark").getBytes("ISO-8859-1"),"UTF-8");
			//三个值可选：POST（平邮）、EXPRESS（快递）、EMS（EMS）
			System.out.println("orderid="+orderid+",trade_no="+trade_no+",logistics_name="+logistics_name+",invoice_no="+invoice_no+",transport_type="+transport_type+",confirmSendProductRemark="+confirmSendProductRemark);
			//////////////////////////////////////////////////////////////////////////////////
			//if(1==1){
				//return;
			//}
			//把请求参数打包成数组
			Map<String, String> sParaTemp = new HashMap<String, String>();
			sParaTemp.put("service", "send_goods_confirm_by_platform");
	        sParaTemp.put("partner", AlipayConfig.partner);
	        sParaTemp.put("_input_charset", AlipayConfig.input_charset);
			sParaTemp.put("trade_no", trade_no);
			sParaTemp.put("logistics_name", logistics_name);
			sParaTemp.put("invoice_no", invoice_no);
			sParaTemp.put("transport_type", transport_type);
			
			String is_success = "T";
			//is_success = "T";
			if(is_success!=null && is_success.equals("T")){
				System.out.println("expressCompanyName = " + request.getParameter("expressCompanyName") + ",expressNo = " + request.getParameter("WIDinvoice_no"));
				
				//修改订单状态为【已发货】
				WebApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
				OrderService orderService = (OrderService) app.getBean("orderServiceManage");
				Order order = new Order();
				order.setId(orderid);
				order.setStatus("send");
				order.setExpressNo(request.getParameter("WIDinvoice_no"));
				order.setExpressCompanyName(request.getParameter("expressCompanyName"));
				orderService.update(order);
				
				response.getWriter().write("{\"code\":\"0\"}");
				//response.sendRedirect(SystemManager.systemSetting.getManageHttp()+"/manage/order!toEdit.action?e.id="+orderid);
			}else{
				String error = "请求确认发货接口，返回失败！";
				System.out.println("请求确认发货接口，返回失败！");
				//System.out.println(error);
				response.setContentType("application/json;charset=UTF-8");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write("{\"code\":\"1\",\"error\":\""+error+"\"}");
				//out.println("{\"code\":\"1\",\"error\":\""+error+"\"}");
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("发货页面异常Exception..."+e.getMessage());
			
			response.setContentType("application/json;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("{\"code\":\"1\",\"error\":\""+"未知异常"+"\"}");
		}
	%>

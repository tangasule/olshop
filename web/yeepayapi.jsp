<%@page import="net.onlineshop.core.yeepay.config.YeepayConfig"%>
<%@page import="net.onlineshop.core.yeepay.model.SendData"%>
<%@page import="net.onlineshop.core.yeepay.service.YeePayService"%>
<%@page import="org.slf4j.LoggerFactory"%>
<%@page import="org.slf4j.Logger"%>
<%
/* *
 *功能：提交易宝支付请求
 */
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>易宝交易接口</title>
	</head>
	<%
	 	Logger logger = LoggerFactory.getLogger(YeePayService.class);
		////////////////////////////////////请求参数//////////////////////////////////////
		SendData sendData = (SendData)request.getAttribute("sendData");
	 	String formName = "yeepay";
	 	StringBuffer sbHtml = new StringBuffer();
        sbHtml.append("<form id=\""+formName+"\" name=\""+formName+"\" action=\"" + YeepayConfig.YEEPAY_GATEWAY_NEW
                      + "\" method=\"POST\">");

       sbHtml.append("<input type=\"hidden\" name=\"p0_Cmd\" value=\"" + sendData.getP0_Cmd() + "\"/>");
       sbHtml.append("<input type=\"hidden\" name=\"p1_MerId\" value=\"" + sendData.getP1_MerId() + "\"/>");
       sbHtml.append("<input type=\"hidden\" name=\"p2_Order\" value=\"" + sendData.getP2_Order() + "\"/>");
       sbHtml.append("<input type=\"hidden\" name=\"p3_Amt\" value=\"" + sendData.getP3_Amt() + "\"/>");
       sbHtml.append("<input type=\"hidden\" name=\"p4_Cur\" value=\"" + sendData.getP4_Cur() + "\"/>");
       sbHtml.append("<input type=\"hidden\" name=\"p5_Pid\" value=\"" + sendData.getP5_Pid() + "\"/>");
       sbHtml.append("<input type=\"hidden\" name=\"p6_Pcat\" value=\"" + sendData.getP6_Pcat() + "\"/>");
       sbHtml.append("<input type=\"hidden\" name=\"p7_Pdesc\" value=\"" + sendData.getP7_Pdesc() + "\"/>");
       sbHtml.append("<input type=\"hidden\" name=\"p8_Url\" value=\"" + sendData.getP8_Url() + "\"/>");
       sbHtml.append("<input type=\"hidden\" name=\"p9_SAF\" value=\"" + sendData.getP9_SAF() + "\"/>");
       sbHtml.append("<input type=\"hidden\" name=\"pa_MP\" value=\"" + sendData.getPa_MP() + "\"/>");
       sbHtml.append("<input type=\"hidden\" name=\"pd_FrpId\" value=\"" + sendData.getPd_FrpId() + "\"/>");
       sbHtml.append("<input type=\"hidden\" name=\"pr_NeedResponse\" value=\"" + sendData.getPr_NeedResponse() + "\"/>");
       sbHtml.append("<input type=\"hidden\" name=\"hmac\" value=\"" + sendData.getHmac() + "\"/>");

        //submit按钮控件请不要含有name属性
        sbHtml.append("<input type=\"submit\" value=\"确认\" style=\"display:none;\"></form>");
        sbHtml.append("<script>document.forms['"+formName+"'].submit();</script>");
		
		//建立请求
		//out.println("请求支付宝...");
		try{
			out.println("正在请求易宝...");
			out.println(sbHtml.toString());
			logger.error("sHtmlText="+sbHtml.toString());
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("异常！");
			out.println("异常！");
		}
	
	 %>
	<body>
	</body>
</html>

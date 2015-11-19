<%@page import="net.onlineshop.core.FrontContainer"%>
<%@page import="net.onlineshop.services.front.order.bean.Order"%>
<%@page import="net.onlineshop.services.front.order.OrderService"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.slf4j.*"%>
<%@page import="net.onlineshop.core.pay.alipay.alipayescow.util.AlipayNotify"%>

<%@ page contentType="text/html; charset=UTF-8"%>

<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="java.util.*"%>
<%@page import="net.onlineshop.services.front.news.bean.News"%>
<%@page import="net.onlineshop.core.ManageContainer"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.Map"%>
<!DOCTYPE html>
<html class="no-js">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>支付宝页面跳转同步通知页面</title>
	<%@ include file="/resource/common_html_meat.jsp"%>
<%@ include file="/resource/common_css.jsp"%>
 </head>
 <body>
		<%@ include file="/indexMenu.jsp"%>
		
		<div class="container">
			<div class="row">
				<div class="col-xs-12">
					<div class="row">
						<div class="col-xs-12">
							<ol class="breadcrumb">
							  <li>首页</li>
							  <li class="active">支付失败</li>
							</ol>
						</div>
					</div>
					
			
					<hr>
					
					<div class="row">
						<div class="col-xs-12" style="font-size: 14px;font-weight: normal;">
							<div class="panel panel-default">
					              <div class="panel-body" style="font-size: 16px;font-weight: normal;text-align: center;">
					              	  <div class="panel-body" style="font-size: 16px;font-weight: normal;">
						              	 <span class="glyphicon glyphicon-ok text-success"></span>
										 <span class="text-success">订单支付失败</span>
						              </div>
					              </div>
							</div>
							<hr>
						</div>
					</div>
				</div>
			</div>
		</div>
	
		<%@ include file="/foot.jsp"%>
  </body>
</html>
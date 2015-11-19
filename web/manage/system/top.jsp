<%@page import="net.onlineshop.core.system.bean.User"%>
<%@page import="java.util.Map"%>
<%@page import="net.onlineshop.core.ManageContainer"%>
<%--  --%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<%@ include file="/resource/common_html_meat.jsp"%>
  	<style type="text/css">
  		body{padding: 0; margin: 0;font-size: 12px; line-height: 100%;font-family: Arial, sans-serif;}
		#header { display: block;overflow: hidden;height: 50px; z-index: 30;}
		#header { background-color:#102c4a;}
		#header, #header .headerNav { background:url(<%=request.getContextPath()%>/resource/images/header_bg.png) repeat-x;}
		#header .logo { float: left;width: 200px;height: 50px;text-indent: -1000px; 
						background:url(<%=request.getContextPath()%>/resource/images/log.png) scroll 5px -12px no-repeat;}
		#header .nav {display: block; height: 21px; position: absolute;top: 8px;right: 0;z-index: 31;}
		#header .nav li { float:left; margin-left:-1px; padding:0 8px; line-height:11px; background:url(<%=request.getContextPath()%>/resource/images/listLine.png) no-repeat;}
		#header .nav li a { color:#b9ccda;text-decoration: none;}
		
	</style> 
	<script type="text/javascript">
    	//注销
    	function logout(){
    		window.parent.location.href = "<%=request.getContextPath()%>/manage/user!loginOut.action";
    	}
    </script>
</head>
<body leftmargin="0" topmargin="0" scroll="no" style="overflow-y:hidden;" id="header">
	<div >
		<div class="headerNav">
	              <a class="logo" target="_blank" href="<%=SystemManager.systemSetting.getWww()%>" title="前往首页" style="max-height: 50px;"></a>
	              <div style="float: left; color: white; font-size: 28px; padding-top: 15px;">后台管理系统</div>
			<ul class="nav">
				<%
					User u =  (User)session.getAttribute(ManageContainer.manage_session_user_info);
					if(u==null){
						out.println("u="+u);
						response.sendRedirect("user!loginOut.action");
						return;
					}
					//out.print(u.getNickname()+"("+u.getUsername()+")");
					String us = u.getNickname()+"("+u.getUsername()+")";
				%>
				<li><a href="javascript:;">welcome, <%=us %></a></li>
				<li><a href="#" onclick="logout()">注销</a></li>
				<%-- <li><a target="_blank" href="<%=SystemManager.systemSetting.getWww()%>">前台首页</a></li> --%>
			</ul>
			
		</div>
	</div>
</body>
</html>
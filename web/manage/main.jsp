<%@page import="net.onlineshop.core.system.bean.User"%>
<%@page import="java.util.Map"%>
<%@page import="net.onlineshop.core.ManageContainer"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/resource/common_html_meat.jsp"%>
</head>

<%
		User u =  (User)session.getAttribute(ManageContainer.manage_session_user_info);
		if(u==null){
			out.println("u="+u);
			response.sendRedirect("user!loginOut.action");
			return;
		}
		//out.print(u.getNickname()+"("+u.getUsername()+")");
	%>

<frameset rows="50,*" >
     <frame src="<%=request.getContextPath()%>/manage/system/top.jsp">
 	 <frameset cols="210,*" >
		<frame src="<%=request.getContextPath()%>/manage/system/left.jsp" name="leftFrame" noresize="noresize"/>
		<frame src="<%=request.getContextPath()%>/manage/user!initManageIndex.action" name="rightFrame" />
	</frameset>
 </frameset>
	

</html>

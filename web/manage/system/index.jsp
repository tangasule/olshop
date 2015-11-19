<%@page import="net.onlineshop.core.ManageContainer"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/resource/common_html_meat.jsp"%>
<%@ include file="/manage/system/common.jsp"%>
<script type="text/javascript">
	$(function() {
		$("#username").focus();

		if (top.location != self.location) {
			top.location = self.location;
		}
	});
</script>
</head>
<body>
	<div class="container">
		<div class="row">
		
			<div class="span5">
				<div style="margin-top: 100px;text-align: right;margin-right: 10px;">
					<img data-src="holder.js/240x240" class="img-circle" alt="240x240" src="<%=request.getContextPath()%>/resource/images/admin_logo.png" style="width: 240px; height: 240px;">
				</div>
			</div>
			
			<div class="span7" style="border-left: 1px solid #ccc;margin-left: -2px;">
<!-- 				<hr width="1px" size="100" style="height: 400px;float: left;"> -->
<!-- <HR align=center width=12 height="5"  color=#ccc style="height: 500px;float: left;display:block;"> -->
				<table class="table table-bordered" style="width: 95%;margin-top: 100px;float: right;">
					<caption>
						<%
						Object loginErrorObj = request.getSession().getAttribute(ManageContainer.loginError);
						if(loginErrorObj!=null){
						%>
						<div class="alert alert-warning alert-dismissable" style="margin-bottom:0px;">
						  <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
			<%-- 			  <strong>登陆失败!</strong> 账号或密码错误！ --%>
							<%=loginErrorObj.toString() %>
						</div>
						<%}
						request.getSession().setAttribute("loginError",null);
						%>
					</caption>
					<tr>
						<td colspan="2"
							style="background-color: #dff0d8; text-align: center;"><strong>&nbsp;<%=SystemManager.systemSetting.getName()%>-后台</strong>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<s:form action="user!login.action" theme="simple" namespace="/manage"
								cssClass="form-horizontal">
								<div class="control-group">
									<label class="control-label" for="inputEmail">帐号</label>
									<div class="controls">
										<div class="input-prepend">
											<span class="add-on"><i class="icon-user"></i></span>
											<s:textfield name="e.username" cssClass="len" id="username" />
										</div>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="inputPassword">密码</label>
									<div class="controls">
										<div class="input-prepend">
											<span class="add-on"><i class="icon-lock"></i></span>
											<s:password name="e.password" cssClass="len" value="111111" label="密码" />
										</div>
									</div>
								</div>
								<div class="control-group">
									<div class="controls">
										<div class="input-prepend">
											<span class="add-on"><i class="icon-hand-right"></i></span>
<%-- 											<s:submit value="登录" cssClass="btn" /> --%>
											<button class="btn">
												登陆
											</button>
										</div>
									</div>
								</div>
							</s:form>
						</td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: center;"><%=SystemManager.systemSetting.getVersion()%>
						</td>
					</tr>
				</table>
				
			</div>
		</div>
	</div>
</body>
</html>

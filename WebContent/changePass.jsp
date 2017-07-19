<%@page import="org.apache.struts2.ServletActionContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="Shortcut Icon" href="//www.dpfile.com/s/res/favicon.5ff777c11d7833e57e01c9d192b7e427.ico" type="image/x-icon">
		<link rel="stylesheet prefech" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.11/semantic.css">
	    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
	    <script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.11/semantic.js"></script>
		<title>修改密码-大众点评课</title>
	</head>
 
	<body>
		${requestScope.message }
		${sessionScope.user.userid }
		<div class="ui container">
			<form class="ui form" action="changePassword" method="post">
				<div class="ui segment">
					<div class="field">
						<input type="hidden" name="userid" value="${sessionScope.user.userid }"/>
					</div>
					<div class="field">
						<label>原密码</label>
						<input type="password" name="oldPassword" placeholder="请输入旧密码"/>
					</div>
					<div class="field">
						<label>新密码</label>
						<input type="password" name="newPassword1" placeholder="请输入新密码"/>
					</div>
					<div class="field">
						<label>确认密码</label>
						<input type="password" name="newPassword2" placeholder="请再次输入新密码"/>
					</div>
				</div>
				<button class="ui primary button" type="submit">修改</button>
			</form>
		</div>
	</body>
</html>
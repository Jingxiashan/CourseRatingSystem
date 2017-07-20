<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="Shortcut Icon"
	href="//www.dpfile.com/s/res/favicon.5ff777c11d7833e57e01c9d192b7e427.ico"
	type="image/x-icon">
<link rel="stylesheet prefech"
	href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.11/semantic.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.11/semantic.js"></script>
<title>修改${sessionScope.user.nickname }的信息-大众点评课</title>
</head>

<body>
	${requestScope.message }
	<div class="ui container">
		<div class="ui segment">
			<form class="ui form" action="" method="post">
				<div class="ui segment">
					<div class="field">
						<label>昵称</label> <input type="text" name="nickname"
							value="${sessionScope.user.nickname }" placeholder="请设置昵称" />
					</div>
					<div class="field">
						<label>微信账号</label> <input type="text" name="wechatAccount"
							value="${sessionScope.user.wechatAccount }"
							placeholder="请填写您的微信账号" />
					</div>
					<div class="field">
						<label>年级</label> <select class="ui search dropdown" name="grade">
							<option value="">请选择年级</option>
							<option value="2010">2010级</option>
							<option value="2011">2011级</option>
							<option value="2012">2012级</option>
							<option value="2013">2013级</option>
							<option value="2014">2014级</option>
							<option value="2015">2015级</option>
							<option value="2016">2016级</option>
							<option value="2017">2017级</option>
							<option value="2018">2018级</option>
						</select>
					</div>
					<div class="field">
						<label>简介</label> 
						<textarea type="text" name="introduction"
							placeholder="请填写关于您的简介" >${sessionScope.user.introduction }</textarea>
					</div>
				</div>
				<button class="ui primary button" type="submit">修改信息</button>
			</form>
		</div>
	</div>
</body>
</html>
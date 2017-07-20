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
<title>${sessionScope.user.nickname }的信息-大众点评课</title>
</head>

<body>
	${requestScope.message }
	<div class="ui container">
		<div class="ui segment">
				<div class="ui segment">
					<br>昵称：${sessionScope.user.nickname }
					<br>微信账号：${sessionScope.user.wechatAccount }
					<br>年级：${sessionScope.user.grade }
					<br>个人简介：${sessionScope.user.introduction }
				</div>
				<button class="ui primary button" onclick="window.location.href='modifyProfile.jsp'">修改信息</button>
		</div>
		<div class="ui segment">
			<table>
				<tr>
					<td>课程名</td>
					<td>老师</td>
					<td>评价</td>
					<td>综合推荐得分</td>
					<td>评论时间</td>
				</tr>
				<c:forEach items="${requestScope.commentPage }" var="comment">
					<tr>
						<td>${comment.course.coursename }</td>
						<td>${comment.teacher.teachername }</td>
						<td>${comment.critics }</td>
						<td>${comment.recommandScore}</td>
						<td>${comment.timestamp}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="ui segment">
			<table>
				<tr>
					<td>课程名</td>
				</tr>
				<c:forEach items="${requestScope.favourateList }" var="course">
					<tr>
						<td>${course.coursename }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
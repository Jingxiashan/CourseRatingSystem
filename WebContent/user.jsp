<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Standard Meta -->
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<link rel="Shortcut Icon"
	href="images/logos/icon.ico"
	type="image/x-icon">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<link rel="stylesheet prefech"
	href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.11/semantic.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.11/semantic.js"></script>
<script>
	$(document).ready(function() {

		// fix main menu to page on passing
		$('.main.menu').visibility({
			type : 'fixed'
		});
		$('.overlay').visibility({
			type : 'fixed',
			offset : 80
		});

		// lazy load images
		$('.image').visibility({
			type : 'image',
			transition : 'vertical flip in',
			duration : 500
		});

		// show dropdown on hover
		$('.main.menu  .ui.dropdown').dropdown({
			on : 'hover'
		});
	});
</script>


<style type="text/css">
body {
	background-color: #FFFFFF;
}

.ui.menu .item img.logo {
	margin-right: 1.5em;
}

.main.container {
	margin-top: 7em;
}

.wireframe {
	margin-top: 2em;
}

.ui.footer.segment {
	margin: 5em 0em 0em;
	padding: 5em 0em;
}

.overlay {
	float: left;
	margin: 0em 3em 1em 0em;
}

#chart {
	text-align: left;
	box-shadow: 0px 2px 8px rgba(0, 0, 0, 0.2);
	border: 1px solid #aaa;
	margin: 32px auto;
	background: white;
}
</style>

<title>个人中心 - 我的课</title>
</head>

<body id="example">

<div class="ui two column grid">

	<div class="three wide column">
		<div class="ui vertical inverted sticky menu" style="position:fixed!important;top:0">
			<div class="item" style="width: 80px">
				<img style="background:#FFFFFF" class="ui tiny image" src="${empty sessionScope.user.picpath ? 'images/stevie.jpg' : sessionScope.user.picpath }">
			</div>
			<div class="container" style="color: #FFFFFF">
				<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;好久不见，${sessionScope.user.nickname }。</b>
			</div>
			<br>
			<div class="item">
				<div class="header">个人中心</div>
				<div class="menu">
					<a class="item" href="user.jsp">个人中心 </a>
					<a href="logout.action" class="item">注销</a>
				</div>
			</div>
			<div class="item">
				<div class="header">课程管理</div>
				<div class="menu">
					<a class="item" href="user_allfavourites.jsp">课程收藏管理 </a>
				</div>
			</div>
			<div class="item">
				<div class="header">评论管理</div>
				<div class="menu"><a class="item" href="user_allcomments.jsp">发表评论管理</a></div>
			</div>
			<div class="item">
				<div class="header">个人信息管理</div>
				<div class="menu">
					<a class="item" href="modifyProfile.jsp"> 修改个人信息 </a> 
					<a class="item" href="changePass.jsp"> 修改个人密码 </a>
				</div>
			</div>
			<div class="item" style="height: 750px">
				<div class="header"><i class="left arrow icon"></i></div>
				<div class="menu">
					<a href="course_findAll.action" class="item">课程详情</a>					
					<a class="item" href="courseSearchByCname.jsp">课程查询</a>
					<a class="item" href="homepage.jsp">网站介绍</a> 
					<a class="item" href="about.jsp">关于我们</a>
				</div>
			</div>
		</div>
	</div>


	<div class="thirteen wide column" style="background:#FFFFFF;padding-left:20px;width:auto">
           <div class="ui basic segment" style="margin:50px">
		<div class="ui left aligned vertical container">
				<img src="${empty sessionScope.user.picpath ? 'images/stevie.jpg' : sessionScope.user.picpath }" style="width: 100px">
				<h1 class="ui header">${sessionScope.user.nickname }</h1>
				<br>
			
			
			<div class="ui basic segment">
			
				<div class="ui header">
					<h3>老司机基本信息</h3>
				</div>
				
				<div class="ui basic segment">
					<div>
						<h4>昵称：${sessionScope.user.nickname }</h4>
					</div>
					<div class="ui divider"></div>
					<div>
						<h4>微信账号：${sessionScope.user.wechatAccount }</h4>
					</div>
					<div class="ui divider"></div>
					<div>
						<h4>年级：${sessionScope.user.grade }</h4>
					</div>
					<div class="ui divider"></div>
					<div>
						<h4>个人简介：</h4>
						<p>${sessionScope.user.introduction }</p>
					</div>
					<div class="ui divider"></div>
				</div>
		
			</div>	
			
		</div>
		</div>
	</div>
	</div>

	


</body>
</html>

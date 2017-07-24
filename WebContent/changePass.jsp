<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Standard Meta -->
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
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

<title>个人中心 - 大众点评课</title>
</head>

<body id="example">

<div class="ui two column grid">

	<div class="three wide column">
		<div class="ui vertical inverted sticky menu" style="position:fixed!important;top:0">
			<div class="item" style="width: 80px">
				<img src="images/jenny.jpg">
			</div>
			<div class="container" style="color: #FFFFFF">
				<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;好久不见，${sessionScope.user.nickname }。</b>
			</div>
			<br>
			<div class="item">
				<div class="header">课程管理</div>
				<div class="menu">
					<a class="item" href="user_allfavourites.jsp">课程收藏管理 </a> <a
						class="item" href="courseSearchByCname.jsp">课程查询</a>
				</div>
			</div>
			<div class="item">
				<div class="header">评论管理</div>
				<div class="menu">
					<a class="item" href="user_allcomments.jsp">发表评论管理</a>
				</div>
			</div>
			<div class="item">
				<div class="header">个人信息管理</div>
				<div class="menu">
					<a class="item" href="modifyProfile.jsp"> 修改个人信息 </a> <a
						class="item" href="changePass.jsp"> 修改个人密码 </a>
				</div>
			</div>
			<div class="item" style="height: 750px">
				<div class="header">其他</div>
				<div class="menu">
					<a class="item" href="homepage.jsp">网站介绍</a> 
					<a class="item"	href="about.jsp">关于我们</a>
				</div>
			</div>
		</div>
	</div>


	<div class="thirteen wide column">
		<div class="ui container" style="background:#FFFFFF;padding-left:50px;width:auto">
			<div class="article">
			
				<div class="ui masthead vertical segment" style="width: 80%">
					<div class="ui container">
						<div class="introduction">
							<h1 class="ui header">${sessionScope.user.nickname}</h1>
							<div class="sub header">${sessionScope.user.introduction}</div>
							<div class="ui hidden divider"></div>
						</div>
					</div>
				</div>


				<div class="ui dividing header" style="width: 80%">
					<h2>修改个人密码</h2>
				</div>	
							
				${requestScope.message } 
				<div class="ui container">
					<form class="ui form" action="changePassword" method="post" style="width: 80%">
						<div class="ui segment">
							<div class="field">
								<input type="hidden" name="userid"
									value="${sessionScope.user.userid }" />
							</div>
							<div class="field">
								<label>原密码</label> <input type="password" name="oldPassword"
									placeholder="请输入旧密码" />
							</div>
							<div class="field">
								<label>新密码</label> <input type="password" name="newPassword1"
									placeholder="请输入新密码" />
							</div>
							<div class="field">
								<label>确认密码</label> <input type="password" name="newPassword2"
									placeholder="请再次输入新密码" />
							</div>
						</div>
						<button class="ui primary button" type="submit">修改</button>
					</form>
				</div>
			</div>
		</div>

	</div>


</div>

</body>
</html>













<%@page import="com.courseratingsystem.web.vo.CoursePage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>关于我们-大众点评课</title>
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
</style>

</head>

<body style="text-align:center">
	<div class="ui fixed inverted menu">
		<div class="ui container">
			<a href="homepage.jsp" class="header item"> <img class="logo"
				src="images/testPic.jpg"> 大众点评课 <a
				href="course_findAll.action" class="item">全部课程</a>
				<div class="ui simple dropdown item">
					课程搜索 <i class="dropdown icon"></i>
					<div class="menu">
						<a class="item" href="courseSearchByCname.jsp">按课程名称</a> <a
							class="item" href="courseSearchByTname.jsp">按授课教师</a>
					</div>
				</div>
		</div>
		<div style="margin-right: 50px; margin-top: 5px">
			<a href="user.jsp" class="item">${sessionScope.user.nickname}</a>
		</div>
	</div>

	<div class="ui main text container">
		<h1 class="ui header">关于我们</h1>
		<br>
	</div>

	<div class="ui container" style="text-align:center">
		<div class="ui special doubling two cards"
			style="width: 80%; width:1000px;text-align:center;;margin:auto">
			<div class="ui card" style="width: 230px;margin:auto">
				<div class="ui slide masked reveal image">
					<img src="images/here.jpg" class="visible content"> <img
						src="images/backend.jpg" class="hidden content">
				</div>
				<div class="content">
					<div class="header">黄嘉星</div>
					<div class="meta">
						<span class="date"></span>
					</div>
				</div>
				<div class="extra content">
					<i class="github alternate icon"></i><br>
					<a href="https://github.com/killer6">https://github.com/killer6</a>
				</div>
			</div>
			<div class="ui card" style="width: 230px;margin:auto">
				<div class="ui slide masked reveal image">
					<img src="images/pretty.jpg" class="visible content"> <img
						src="images/backend.jpg" class="hidden content">
				</div>
				<div class="content">
					<div class="header">张彦泽</div>
					<div class="meta">
						<span class="date"></span>
					</div>
				</div>
				<div class="extra content">
					<i class="github alternate icon"></i><br>
					<a href="https://github.com/Lancelot-97">https://github.com/Lancelot-97</a>
				</div>
			</div>
						<div class="ui card" style="width: 230px;margin:auto">
				<div class="ui slide masked reveal image">
					<img src="images/love.jpg" class="visible content"> <img
						src="images/frontend.jpg" class="hidden content">
				</div>
				<div class="content">
					<div class="header">鲁迪</div>
					<div class="meta">
						<span class="date"></span>
					</div>
				</div>
				<div class="extra content">
					<i class="github alternate icon"></i>
					<a href="https://github.com/Jingxiashan">https://github.com/Jingxiashan</a>
				</div>
			</div>
			<div class="ui card" style="width: 230px;margin:auto">
				<div class="ui slide masked reveal image">
					<img src="images/boom.jpg" class="visible content"> <img
						src="images/bandf.jpg" class="hidden content">
				</div>
				<div class="content">
					<div class="header">孔啸</div>
					<div class="meta">
						<span class="date"></span>
					</div>
				</div>
				<div class="extra content">
					 <i class="github alternate icon"></i>
					 <a href="https://github.com/kongxiao0532">https://github.com/kongxiao0532</a>
				</div>
			</div>
		</div>
	</div>



	<div class="ui inverted vertical footer segment">
		<div class="ui left aligned container">
			<div class="ui stackable inverted divided grid">
				<div class="three wide column">
					<h4 class="ui inverted header">关于</h4>
					<div class="ui inverted link list">
						<a href="homepage.jsp" class="item">网站介绍</a> <a href="about.jsp"
							class="item">联系我们 </a>
					</div>
				</div>
				<div class="ten wide column">
					<h4 class="ui inverted header">大众点评课</h4>
					<p>只做给你看的选课攻略。</p>
					<i class="github icon"></i>
					<a href="https://github.com/Jingxiashan/CourseRatingSystem"style="color:#B0B0B0">https://github.com/Jingxiashan/CourseRatingSystem</a>
				</div>
			</div>
			<div class="ui inverted section divider"></div>
		</div>
	</div>
</body>
<script>
	$('.special.cards .image').dimmer({
		on : 'hover'
	});
	$('.ui.star .rating').rating('disable');
</script>
</html>
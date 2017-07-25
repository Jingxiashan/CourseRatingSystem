<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<!-- Standard Meta -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<link rel="Shortcut Icon" href="images/logos/icon.ico"
	type="image/x-icon">
<link rel="stylesheet prefech"
	href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.11/semantic.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.11/semantic.js"></script>
<!-- Site Properties -->
<title>主页 - 我的课</title>
<style type="text/css">
.hidden.menu {
	display: none;
}

.masthead.segment {
	min-height: 700px;
	padding: 1em 0em;
}

.masthead .logo.item img {
	margin-right: 1em;
}

.masthead .ui.menu .ui.button {
	margin-left: 0.5em;
}

.masthead h1.ui.header {
	margin-top: 3em;
	margin-bottom: 0em;
	font-size: 4em;
	font-weight: normal;
}

.masthead h2 {
	font-size: 1.7em;
	font-weight: normal;
}

.ui.vertical.stripe {
	padding: 8em 0em;
}

.ui.vertical.stripe h3 {
	font-size: 2em;
}

.ui.vertical.stripe .button+h3,.ui.vertical.stripe p+h3 {
	margin-top: 3em;
}

.ui.vertical.stripe .floated.image {
	clear: both;
}

.ui.vertical.stripe p {
	font-size: 1.33em;
}

.ui.vertical.stripe .horizontal.divider {
	margin: 3em 0em;
}

.quote.stripe.segment {
	padding: 0em;
}

.quote.stripe.segment .grid .column {
	padding-top: 5em;
	padding-bottom: 5em;
}

.footer.segment {
	padding: 5em 0em;
}

.secondary.pointing.menu .toc.item {
	display: none;
}

@media only screen and (max-width: 700px) {
	.ui.fixed.menu {
		display: none !important;
	}
	.secondary.pointing.menu .item,.secondary.pointing.menu .menu {
		display: none;
	}
	.secondary.pointing.menu .toc.item {
		display: block;
	}
	.masthead.segment {
		min-height: 350px;
	}
	.masthead h1.ui.header {
		font-size: 2em;
		margin-top: 1.5em;
	}
	.masthead h2 {
		margin-top: 0.5em;
		font-size: 1.5em;
	}
}
</style>

<script>
	$(document).ready(function() {

		// fix menu when passed
		$('.masthead').visibility({
			once : false,
			onBottomPassed : function() {
				$('.fixed.menu').transition('fade in');
			},
			onBottomPassedReverse : function() {
				$('.fixed.menu').transition('fade out');
			}
		});

		// create sidebar and attach to menu open
		$('.ui.sidebar').sidebar('attach events', '.toc.item');

	});
</script>
</head>
<body>

	<!-- Following Menu -->
	<div class="ui large top fixed hidden menu">
		<div class="ui container">
			<a class="active item">主页</a> <a href="course_findAll.action"
				class="item">课程详情</a>
			<div class="ui simple dropdown item">
				课程搜索 <i class="dropdown icon"></i>
				<div class="menu">
					<a class="item" href="courseSearchByCname.jsp">按课程名称</a> <a
						class="item" href="courseSearchByTname.jsp">按授课教师</a>
				</div>
			</div>
			<div class="right menu">
				<!-- 如果未登录，显示登录注册 -->
				<c:if test="${empty sessionScope.user}">
					<a href="login.jsp" class="item">登录</a>
					<a href="register.jsp" class="item">注册</a>
				</c:if>
				<!-- 如果已经登录，显示个人中心链接 -->
				<c:if test="${!empty sessionScope.user}">
					<a href="./user/" class="item">${sessionScope.user.nickname}</a>
					<a href="logout.action" class="item">注销</a>
				</c:if>
			</div>
		</div>
	</div>

	<!-- Page Contents -->
	<div class="pusher">
		<div class="ui inverted vertical masthead center aligned segment">
			<!-- 顶端菜单 -->
			<div class="ui container">
				<div class="ui large secondary inverted pointing menu">
					<a class="toc item"> <i class="sidebar icon"></i>
					</a> <a class="active item">主页</a> <a href="course_findAll.action"
						class="item">课程详情</a>
					<div class="ui simple dropdown item">
						课程搜索 <i class="dropdown icon"></i>
						<div class="menu">
							<a class="item" href="courseSearchByCname.jsp">按课程名称</a> <a
								class="item" href="courseSearchByTname.jsp">按授课教师</a>
						</div>
					</div>
					<div class="right menu">
						<!-- 如果未登录，显示登录注册 -->
						<c:if test="${empty sessionScope.user}">
							<a href="login.jsp" class="item">登录</a>
							<a href="register.jsp" class="item">注册</a>
						</c:if>
						<!-- 如果已经登录，显示个人中心链接 -->
						<c:if test="${!empty sessionScope.user}">
							<a href="./user/" class="item">${sessionScope.user.nickname}</a>
							<a href="logout.action" class="item">注销</a>
						</c:if>
					</div>
				</div>
			</div>

			<div class="ui text container">
				<div class="ui image" style="margin-top: 170px">
					<img src="images/logos/logo_homepage.png"></img>
				</div>
			</div>
		</div>
		<div class="ui horizontal">
			<div class="ui vertical">
				<div class="ui middle aligned stackable grid container">
					<div class="row">
						<div class="ui vertical stripe segment">
							<div class="ui text container">
								<h3 class="ui header">提供一切你最想知道的关于课程的信息。</h3>
								<p>内容丰富？/给分情况？/期末考评方式？/点名频率？/课堂氛围？</p>
								<h3 class="ui header">听听老司机们血的教训/拔草经历</h3>
								<p>获得来自过来人的第一笔资料。</p>
							</div>
						</div>
						、



						<div class="six wide right floated column">
							<div class="ui card" style="border: 0px; width: 400px">
								<div class="ui slide masked reveal image">
									<img src="images/screenshoot1.jpg" class="visible content">
									<img src="images/screenshoot2.jpg" class="hidden content">
								</div>

							</div>
						</div>




					</div>
				</div>
			</div>
		</div>
		<div class="ui inverted vertical footer segment">
			<div class="ui container">
				<div
					class="ui stackable inverted divided equal height stackable grid">
					<div class="three wide column">
						<h4 class="ui inverted header">关于</h4>
						<div class="ui inverted link list">
							<a href="#" class="item">网站介绍</a> <a href="about.jsp"
								class="item">联系我们</a>
						</div>
					</div>
					<div class="ten wide column">
						<h4 class="ui inverted header">我的课</h4>
						<p>只做给你看的选课攻略。</p>
						<i class="github icon"></i> <a
							href="https://github.com/Jingxiashan/CourseRatingSystem" target="_blank"
							style="color: #B0B0B0">https://github.com/Jingxiashan/CourseRatingSystem</a>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>

</html>

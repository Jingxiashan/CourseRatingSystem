<%@page import="com.courseratingsystem.web.vo.CoursePage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>${requestScope.teacher.teachername }-大众点评课</title>
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

<body>
	<div class="ui fixed inverted menu">
		<div class="ui container">
			<a href="homepage.jsp" class="header item"> <img class="logo"
				src="images/testPic.jpg"> 大众点评课
			</a> <a onClick="javascript :history.back(-1);" class="item">返回</a> <a
				href="course_findAll.action" class="item">课程列表</a>
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
					<a href="user.jsp" class="item">${sessionScope.user.nickname}</a>
					<a href="logout.action" class="item">注销</a>
				</c:if>
			</div>
		</div>
	</div>
	
	<div class="ui left aligned main text container">
		<img src="images/jenny.jpg" style="width: 100px">
		<h1 class="ui header">${requestScope.teacher.teachername }</h1>
		<br>
	</div>

	<div class="ui container" style="width: 50%">
		<div class="ui segment">
			<h3 class="ui header">该老师所教授课程</h3>
			<div class="ui center aligned middle aligned ">
				<div class="ui center aligned basic segment">

					<!-- 在此处添加点出课程详情和收藏课程的action -->
					<form class="ui form">
						<div class="ui cards" style="width: 50%; margin: auto">
							<!-- 此处循环画 <div card>得到该老师全部课程 -->
							<c:forEach items="${requestScope.courseList }" var="course">

								<div class="card">
									<div class="content">
										<div class="header">${course.coursename }</div>
										<br>
										<div class="meta">推荐指数</div>
										<div class="ui star rating">
											<c:forEach begin="0" end="${course.recommendationScore-1 }">
												<i class="icon active"></i>
											</c:forEach>
										</div>
									</div>


									<div class="center aligned container">
										<button class="ui red basic button"
											onclick="window.location.href='course_getPage.action?courseid=${course.courseid }'; window.event.returnValue = false;">详情。</button>
										<!-- 	<button class="ui red basic button">要了。</button> -->
									</div>

									<br>
								</div>

							</c:forEach>
						</div>
					</form>
				</div>

			</div>
		</div>
		<h3 class="ui header">该老师所教授课程的评论</h3>
		<div class="ui left aligned segment">
			<div class="ui comments">
					<!-- 在这里循环画对应课程的评论 循环<div comment>+<div hidden divider> -->
					<c:forEach items="${requestScope.commentList }" var="comment">
					<div class="ui two column very relaxed grid">
						<div class="eleven wide column">
							<div class="comment">
								<a class="avatar"> <img src="images/elliot.jpg"></a>
								<div class="content">
									<a class="author" href="user_getOthersProfile.action?userid=${comment.userid }">${request.user.nickname }</a>
									<div class="text" style="margin-top:15px">${comment.critics }</div>
									
								</div>
								<h5>评论时间：${comment.timestamp }</h5>
							</div>
						</div>
						
						<div class="five wide column" style="margin:0px">
							<div class="ui right floated labeled mini button" tabindex="0">
								<div class="ui red mini button" type="" onclick="likeComment(${comment.commentid });">
									<i class="heart icon"></i> 戳
								</div>
								<div id="comment${comment.commentid }Count"
									class="ui basic red left mini basic label">${comment.likeCount }
								</div>
							</div>
						</div>
					</div>	
					<div class="ui divider"></div>
					</c:forEach>
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














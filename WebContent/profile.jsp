<%@page import="com.courseratingsystem.web.vo.CoursePage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>${requestScope.user.nickname }的个人主页</title>
<head>
<!-- Standard Meta -->
<c:if test="${empty requestScope.user.userid }">
	<meta http-equiv="refresh" content="0;url=404.jsp"> 
</c:if>
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
			
			<a href="homepage.jsp" class="header item">
				<img class="logo" src="images/logos/logo_menu.png" style="width:105px;margin-right:0px"> 
			</a><a onClick="javascript :history.back(-1);" class="item">返回</a> <a
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
					<a href="./user/" class="item">${sessionScope.user.nickname}</a>
					<a href="logout.action" class="item">注销</a>
				</c:if>
			</div>
		</div>
	</div>

	<div class="ui left aligned main text container">
		<img src="${empty requestScope.user.picpath ? 'images/stevie.jpg' : requestScope.user.picpath }" style="width: 100px">
		<h1 class="ui header">${requestScope.user.nickname }</h1>
		<br>
	</div>
	
	<div class="ui container" style="width: 50%">
		<div class="ui segment">
			<div class="ui header">
				<h3>老司机基本信息</h3>
			</div>
			<div class="ui tall stacked segment">
				<div>
					<h4>昵称：${requestScope.user.nickname }</h4>
				</div>
				<div class="ui divider"></div>
				<div>
					<h4>微信账号：${requestScope.user.wechatAccount }</h4>
				</div>
				<div class="ui divider"></div>
				<div>
					<h4>年级：${requestScope.user.grade }</h4>
				</div>
				<div class="ui divider"></div>
				<div>
					<h4>个人简介：</h4>
					<p>${requestScope.user.introduction }</p>
				</div>
			</div>


			<div class="ui header">
				<h3>啊，老司机这样说过。</h3>
			</div>
			<div class="ui tall stacked segment">
				<div class="ui comments">
					<c:forEach items="${requestScope.commentPage.commentList }" var="comment">
						<div class="ui two column very relaxed grid">
							<div class="eleven wide column">
								<div class="comment">
								<a class="avatar"> <img src="${empty requestScope.user.picpath ? 'images/stevie.jpg' : requestScope.user.picpath }"></a>
								<div class="content">
									授课教师：<a class="author" href="teacher_getPage.action?teacherid=${comment.teacher.teacherid}">${comment.teacher.teachername }</a>
									<br>课程名称：<a class="author" href="course_getPage.action?courseid=${comment.course.courseid}">${comment.course.coursename }</a>
									<div>
									推荐星级：<div class="ui star rating" data-rating="${comment.recommandScore }" data-max-rating="5"></div>
									</div>
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
				<div class="seven wide column">
					<h4 class="ui inverted header">我的课</h4>
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
	$('.ui .rating').rating('disable');

	function likeComment(id) {
		$.ajax({
			type : 'get',
			url : "${pageContext.request.contextPath}/likeComment.action",
			data : {
				commentid : id
			},
			success : function(data) {
				$("#comment" + id + "Count").html(data.likeCount);
			}
		})
	}
</script>
</html>































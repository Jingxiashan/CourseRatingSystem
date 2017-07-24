<%@page import="com.courseratingsystem.web.vo.CoursePage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>${requestScope.user.nickname }的个人主页</title>
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
				src="images/testPic.jpg">大众点评课
			</a>
		</div>
	</div>

	<div class="ui left aligned main text container">
		<img src="images/elliot.jpg" style="width: 100px">
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
								<a class="avatar"> <img src="images/elliot.jpg"></a>
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
					<h4 class="ui inverted header">大众点评课</h4>
					<p>只做给你看的选课攻略。</p>
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































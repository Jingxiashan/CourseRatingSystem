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

<title>课程收藏 - 我的课</title>
</head>

<body id="example">

<div class="ui two column grid">

	<div class="three wide column">
		<div class="ui vertical inverted sticky menu" style="position:fixed!important;left:0;top:0">
			<div class="item" style="width: 80px">
				<img src="images/stevie.jpg">
			</div>
			<div class="container" style="color: #FFFFFF">
				<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;好久不见，${sessionScope.user.nickname }。</b>
			</div>
			<br>
			<div class="item">
				<div class="header">课程管理</div>
				<div class="menu">
					<a class="item" href="user_allfavourites.jsp">课程收藏管理 </a> 
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
					<a class="item" href="user.jsp" class="item">个人中心</a>
					<a href="course_findAll.action" class="item">课程详情</a>					
					<a class="item" href="courseSearchByCname.jsp">课程查询</a>
					<a class="item" href="homepage.jsp">网站介绍</a> 
					<a class="item" href="about.jsp">关于我们</a>
				</div>
			</div>
		</div>
	</div>


	<div class="thirteen wide column">
		<div class="ui container" style="background:#FFFFFF;padding-left:50px;width:auto">
			<div class="article">
			
				
				<div class="ui dividing header" style="width: 80%;margin-top:80px">
                    <h2>已收藏课程</h2>
				</div>
				<br>
				
				<!-- 这里定义收藏课程的删除以及点出详情的action -->
				<form>
					<div class="ui center aligned middle aligned grid">
						<div class="ui  special doubling cards"  id="courseCards">
							<c:forEach items="${sessionScope.user.courses }" var="course">
								<div class="centered card" id="course${course.courseid }">
									<div class="content">
										<img class="right floated mini ui image" src="images/elliot.jpg">
										<div class="header">
											<h4><a style="color:black" href="course_getPage.action?courseid=${course.courseid }">${course.coursename }</a></h4>
										</div>
										
										<div class="meta" style="margin-top:30px">
											<span class="date"><h5>推荐星级</h5>
												<div class="ui star rating" data-rating="${course.coursemark.recommendationScore }" data-max-rating="5"></div>
											</span>
										</div>
									</div>
									<div class="extra content">
										<div class="ui two buttons">
											<div class="ui basic green button" onclick="coursegetPage(${course.courseid });">戳详情</div>
											<div class="ui basic red button" onclick="deleteFavourate(${course.courseid })">戳删除</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</form>
				<br>
				
			</div>
		</div>
	</div>
	
</div>

<div class="ui basic modal">
	<div class="ui icon header" id="modalTitle">
		<i class="archive icon"></i> 收藏成功
	</div>
	<div class="actions">
		<div class="ui green ok inverted button">
			<i class="checkmark icon"></i> 确定
		</div>
	</div>
</div>

</body>

<script type="text/javascript">

$(".ui .rating").rating('disable');

function deleteFavourate(courseid){
	$.ajax({
		type:'get',
		url:'${pageContext.request.contextPath}/deleteFavourate.action',
		data:{"courseid":courseid },
		success:function(data){
			var cards = document.getElementById("courseCards");
			var card = document.getElementById("course"+courseid);
			cards.removeChild(card);
			document.getElementById("modalTitle").innerHTML="已取消收藏";
			$('.ui.basic.modal')
			  .modal('show')
			;
		}
	});
}

function coursegetPage(courseid){
	document.forms[0].method="post";
	document.forms[0].action='${pageContext.request.contextPath}/course_getPage.action?courseid='+courseid;
	document.forms[0].submit();
}

</script>
</html>

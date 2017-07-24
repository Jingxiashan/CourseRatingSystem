<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>课程评论 - 大众点评课</title>
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
					<a class="item" href="about.jsp">关于我们</a>
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
					<h2>已发表评论</h2>
				</div>

				<div class="ui raised aligned segment" style="width: 80%">
					<div class="ui comments"  id="comments">
						<c:forEach items="${sessionScope.user.comments }" var="comment">
							<div class="ui two column grid" id="comment${comment.commentid }">
							
								<div class="ten wide column">
									<div class="comment">
										<a class="avatar"><img src="images/elliot.jpg"></a>
									
										<div class="content">
											<a class="author" href="user_getOthersProfile.action?userid=${comment.user.userid }">${comment.user.nickname }</a>
											<div class="metadata">
												<span class="date">${comment.timestamp }</span>
											</div>
											
											<div class="author" style="margin-top:10px">评价课程：${comment.course.coursename }</div>
											<div class="author" style="margin-top:5px">评价教师：${comment.teacher.teachername }</div>
											<div class="text" style="margin-top:10px">${comment.critics }</div>
										</div>
									</div>
								</div>
								
								<div class="six wide column">
									<!-- 这里是 点赞评论和删除评论的action-->
									<form class="actions">
										<div class="ui labeled mini button" tabindex="0">
											<div class="ui red mini button" window.event.returnValue = false;">
												<i class="heart icon"></i> 戳
											</div>
											<div id="comment${comment.commentid }Count" class="ui basic red left mini basic label">
												${comment.likeCount }
											</div>
										</div>
										<div class="ui labeled mini button" tabindex="0">
											<div class="ui basic blue mini button" onclick="deleteComment(${comment.commentid})">
												<i class="fork icon"></i>删除
											</div>
										</div>
									</form>
								</div>
								
							</div>
						</c:forEach>
					</div>
				</div>
				
			</div>
		</div>
	</div>
	
</div>

<div class="ui basic modal">
	<div class="ui icon header" id="modalTitle">
		<i class="archive icon"></i> 评论成功
	</div>
	<div class="actions">
		<div class="ui green ok inverted button">
			<i class="checkmark icon"></i> 确定
		</div>
	</div>
</div>

</body>
<script>
$(".ui .rating").rating('disable');

function deleteComment(commentid){
	$.ajax({
		type:'get',
		url:'${pageContext.request.contextPath}/deleteComment.action',
		data:{"commentid":commentid },
		success:function(data){
			var parent = document.getElementById("comments");
			var child = document.getElementById("comment"+commentid);
			parent.removeChild(child);
			document.getElementById("modalTitle").innerHTML="已删除评论";
			$('.ui.basic.modal')
			  .modal('show')
			;
		}
	});
}


</script>
</html>

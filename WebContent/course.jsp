<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>课程详情-${requestScope.course.coursename}</title>
<!-- Standard Meta -->
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<link rel="stylesheet prefech"
	href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.11/semantic.css">

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script src="js/radar_jquery.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.11/semantic.js"></script>
<script src="js/radarChart.js"></script>

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

.overlay .menu {
	position: relative;
	left: 0;
	transition: left 0.5s ease;
}

.overlay.fixed .menu {
	left: 800px;
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


	<div class="ui container" style="width: 750px">
		<div class="ui main text container">


			<!-- 这里是 收藏课程的action-->
			<form class="ui form">
				<div class="two fields">
					<div class="field">
						<h1 class="ui header">${requestScope.course.coursename}</h1>
						<span class="date">
							<div class="ui statistics">
								<div class="statistic">
									<div class="value">
										<i class="thumbs up icon"></i>
										${requestScope.course.recommendationScore}/5
									</div>
									<div class="label">推荐指数</div>
								</div>
								<div class="statistic">
									<div class="value">
										<i class="user circle outline icon"></i>
										${requestScope.course.peopleCount }
									</div>
									<div class="label">条评价</div>
								</div>
							</div>
						</span> <span class="date"><h4>
								授课教师：
								<c:forEach items="${requestScope.course.teacherList }"
									var="teacher">
									<a class="ui label"
										href="teacher_getPage.action?teacherid=${teacher.teacherid}">${teacher.teachername }</a>
								</c:forEach>
							</h4> </span><br>
						<button class="ui primary button" type=button
							onclick="window.location.href='comment_getPage.action?courseid=${requestScope.course.courseid }'">啊，评论。</button>
						<c:if test="${requestScope.ifFavourate == 'true' }">
							<button class="ui primary button" id="favourate" type=button
								onclick="deleteFavourate()">取消收藏。</button>
						</c:if>
						<c:if test="${requestScope.ifFavourate == 'false' }">
							<button class="ui primary button" id="favourate" type=button
								onclick="addFavourate()">嗯，收藏。</button>
						</c:if>
					</div>
					<div class="ui right floated basic segment"
						style="margin: 0px; padding: 0px; border: 0px">
						<div id="chart" style="margin: 0px"></div>
					</div>
				</div>
				<br>
		</div>
		</form>
	</div>
	<div class="ui text container">
		<div class="ui form">
			<h4 class="ui dividing header">课程属性评价</h4>
			<div class="five fields">
				<div class="field">
					<div class="ui card">
						<div class="content">
							<div class="header">内容好否?</div>
						</div>
						<div class="content" style="height: 150px">
							<h4 class="ui sub header">从老师讲授知识层面来讲，内容对自己有益程度；内容有益，请给多星。</h4>
						</div>
						<div class="extra content">
							<div class="ui star rating"
								data-rating="${requestScope.course.averageRatingsUsefulness }"
								data-max-rating="5"></div>
						</div>
					</div>

				</div>
				<div class="field">
					<div class="ui card">
						<div class="content">
							<div class="header">上课爽否?</div>
						</div>
						<div class="content" style="height: 150px">
							<h4 class="ui sub header">在上课时，课堂氛围情况；课堂氛围活跃，老师授课生动有趣，请给多星。</h4>
						</div>
						<div class="extra content">
							<div class="ui star rating"
								data-rating="${requestScope.course.averageRatingsVividness }"
								data-max-rating="5"></div>
						</div>
					</div>
				</div>
				<div class="field">
					<div class="ui card">
						<div class="content">
							<div class="header">占时少否?</div>
						</div>
						<div class="content" style="height: 150px">
							<h4 class="ui sub header">根据自己的学习经历，与其他同类型课程比较，完成课后作业、课后展示及大小考试所花费时间；占用课余时间少，请给多星。</h4>
						</div>
						<div class="extra content">
							<div class="ui star rating"
								data-rating="${requestScope.course.averageRatingsSpareTimeOccupation }"
								data-max-rating="5"></div>
						</div>
					</div>
				</div>
				<div class="field">
					<div class="ui card">
						<div class="content">
							<div class="header">给分高否?</div>
						</div>
						<div class="content" style="height: 150px">
							<h4 class="ui sub header">根据自己的学习经历，与其他同类型课程比较的期末分情况；期末给分高，请给多星。</h4>
						</div>
						<div class="extra content">
							<div class="ui star rating"
								data-rating="${requestScope.course.averageRatingsScoring }"
								data-max-rating="5"></div>
						</div>
					</div>
				</div>
				<div class="field">
					<div class="ui card">
						<div class="content">
							<div class="header">点名少否?</div>
						</div>
						<div class="content" style="height: 150px">
							<h4 class="ui sub header">根据自己的学习经历，与其他同类型课程比较的点名情况比较；点名频率低，请给多星。</h4>
						</div>
						<div class="extra content">
							<div class="ui star rating"
								data-rating="${requestScope.course.averageRatingsRollCall }"
								data-max-rating="5"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<h4 class="ui dividing header">嗯，老司机们这样说。</h4>
		<div class="ui raised aligned segment">
			<div class="ui comments">
				<c:forEach items="${requestScope.commentPage.commentList }" var="comment">	
					<div class="ui two column grid">
						<div class="eleven wide column">
							<div class="comment">
								<a class="avatar"> 
									<img src="images/elliot.jpg">
								</a>
								<div class="content">
									<a class="author" href="user_getOthersProfile.action?userid=${comment.user.userid }">${comment.user.nickname }</a>
								      <div class="metadata">
								        <span class="date">${comment.timestamp }</span>
								      </div>
									<div class="text" style="margin-top:10px">${comment.critics }</div>
								</div>
							</div>
						</div>
						<div class="five wide column">
							<div class="ui right floated labeled mini button" tabindex="0">
								<div class="ui red mini button" type="button" onclick="likeComment(${comment.commentid });">
									<i class="heart icon"></i> 戳
								</div>
								<div id="comment${comment.commentid }Count" class="ui basic red left mini basic label">${comment.likeCount }</div>
							</div>		
						</div>
					</div>
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
				<div class="seven wide column">
					<h4 class="ui inverted header">大众点评课</h4>
					<p>只做给你看的选课攻略。</p>
				</div>
			</div>
			<div class="ui inverted section divider"></div>
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
	$('.ui .rating').rating('disable');
});
$(function(){
	 $('#chart').radarChart({
		    size: [400, 300],
		    step: 1,
		    title: "",
		    values: {
		      "内容好否？": ${requestScope.course.averageRatingsUsefulness },
		      "上课爽否？": ${requestScope.course.averageRatingsVividness },
		      "占时少否？": ${requestScope.course.averageRatingsSpareTimeOccupation },
		      "给分高否？": ${requestScope.course.averageRatingsScoring },
		      "点名少否？": ${requestScope.course.averageRatingsRollCall }
		    },
		    showAxisLabels: true
		  })
	});
  function addFavourate(){
	  var user = "${sessionScope.user }";
	  if(user.length == 0){
		  window.location.href="login.jsp";
		  return;
	  }
	$.ajax({
		type:'get',
		url:'${pageContext.request.contextPath}/addFavourate.action',
		data:{courseid:"${requestScope.course.courseid }" },
		success:function(data){
			var button = document.getElementById("favourate");
			button.onclick=function(){deleteFavourate();};
			button.innerHTML="取消收藏。";
			document.getElementById("modalTitle").innerHTML="收藏成功";
			$('.ui.basic.modal')
			  .modal('show')
			;
		}
	});
  }
  
  function deleteFavourate(){
		$.ajax({
			type:'get',
			url:'${pageContext.request.contextPath}/deleteFavourate.action',
			data:{courseid:"${requestScope.course.courseid }" },
			success:function(data){
				var button = document.getElementById("favourate");
				button.onclick=function(){addFavourate();};
				button.innerHTML="嗯，收藏。";
				document.getElementById("modalTitle").innerHTML="已取消收藏";
				$('.ui.basic.modal')
				  .modal('show')
				;
			}
		})
  }
  
  function likeComment(id){
	  $.ajax({
	 	type:'get',
	 	url:"${pageContext.request.contextPath}/likeComment.action",
	 	data:{commentid:id},
		success:function(data){
			 $("#comment"+id+"Count").html(data.likeCount); 	
		}		  
	  })
}

</script>
</html>

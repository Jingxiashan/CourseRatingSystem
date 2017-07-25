<%@page import="com.courseratingsystem.web.vo.CoursePage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>${requestScope.teacher.teachername }-我的课</title>
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
	<div class="ui fixed borderless inverted menu">
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
										<div class="ui star rating" data-rating="${((course.recommendationScore % 1) > 0.5) ? (course.recommendationScore + 1 - (course.recommendationScore % 1)) : (course.recommendationScore - (course.recommendationScore % 1)) }" data-max-rating="5"></div>
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
		<h4 class="ui dividing header">嗯，老司机们这样说。</h4>
		<div class="ui raised aligned segment">
			<div id="commentlist" class="ui comments" style="margin-bottom:0">
				<c:forEach items="${requestScope.commentPage.commentList }" var="comment">
					<div class="ui two column grid"  id="comment${comment.commentid }">
						<div class="eleven wide column">
							<div class="comment">
								<a class="avatar"> <img src="${empty comment.user.picpath ? 'images/stevie.jpg' : comment.user.picpath }"></a>
								<div class="content">
									<a class="author" href="user_getOthersProfile.action?userid=${comment.user.userid }">${comment.user.nickname }</a>
									<div class="metadata">
								        <span class="date">${comment.timestamp }</span>
								    </div>
								    <div class="author" style="margin-top:5px">评价课程：${comment.course.coursename }</div>
									<div class="text" style="margin-top:10px">${comment.critics }</div>
								</div>
							</div>
						</div>
						
						<div class="five wide column">
							<c:if test="${empty sessionScope.user.userid }">
								<!-- 如果未登录 -->
								<button class="ui right floated basic red mini button" type="button">
								  <i class="heart icon"></i>
								  ${comment.likeCount }
								</button>
							</c:if>
							<c:if test="${!empty sessionScope.user.userid }">
								<!-- 如果已登录 -->
								<c:if test="${comment.user.userid == sessionScope.user.userid }">
									<!-- 如果是自己的评论 -->
									<div class="ui right floated basic blue mini button" onclick="deleteComment(${comment.commentid})">
										<i class="remove icon"></i>删除
									</div>
									<button class="ui right floated basic red mini button" type="button">
									  <i class="heart icon"></i>
									  ${comment.likeCount }
									</button>
								</c:if>
								<c:if test="${comment.user.userid != sessionScope.user.userid }">
									<!-- 如果不是自己的评论 -->
									<div class="ui right floated labeled mini button" tabindex="0">
										<div class="ui red mini button" type="button"
											onclick="likeComment(${comment.commentid });">
											<i class="heart icon"></i> 戳
										</div>
										<div id="comment${comment.commentid }Count"
											class="ui basic red left mini basic label">${comment.likeCount }</div>
									</div>
								</c:if>
							</c:if>
						</div>
					</div>	
					</c:forEach>
			</div>
			<div class="ui basic segment" style="margin-top:0;margin-bottom:20px">
				<div id="pageturner" class="ui right floated mini pagination menu">
					<c:forEach begin="1" end="${requestScope.commentPage.totalPage}" step="1" var="i">
						<c:if test="${i==requestScope.commentPage.currentPage}">
							<a class="disabled item">${i }</a>
						</c:if>
						<c:if test="${i!=requestScope.commentPage.currentPage}">
							<a class="item" onclick="turnPage(${i},${requestScope.teacher.teacherid});">${i }</a>
						</c:if>
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
				<div class="ten wide column">
					<h4 class="ui inverted header">我的课</h4>
					<p>只做给你看的选课攻略。</p>
					<i class="github icon"></i>
					<a href="https://github.com/Jingxiashan/CourseRatingSystem" target="_blank" style="color:#B0B0B0">https://github.com/Jingxiashan/CourseRatingSystem</a>
				</div>
			</div>
			<div class="ui inverted section divider"></div>
		</div>
	</div>
	<div class="ui basic modal" id="favourateModal">
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
	$('.special.cards .image').dimmer({
		on : 'hover'
	});
	$('.ui .rating').rating('disable');
	
	
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
	 function deleteComment(commentid){
		  	$.ajax({
		  		type:'get',
		  		url:'${pageContext.request.contextPath}/deleteComment.action',
		  		data:{"commentid":commentid },
		  		success:function(data){
		  			var parent = document.getElementById("commentlist");
		  			var child = document.getElementById("comment"+commentid);
		  			console.log(parent);
		  			console.log(child);
		  			parent.removeChild(child);
		  			document.getElementById("modalTitle").innerHTML="已删除评论";
		  			$('.ui.basic.modal')
		  			  .modal('show')
		  			;
		  		}
		  	});
		  }
	 function turnPage(page,teacherid){
		  $.ajax({
			  type:'get',
			  url:"${pageContext.request.contextPath}/turnPage.action",
			  data:{"currentPage":page,"id":teacherid,"pageSize": ${requestScope.commentPage.pageSize },"findBy":"teacher"},
			  success:function(data){
					var returnData = JSON.parse(data);
					var html="";
				    for(var tmp in returnData[1].results){
				    	var commentid = returnData[1].results[tmp].commentid;
				    	var critics = returnData[1].results[tmp].critics;
				    	var userid = returnData[1].results[tmp].userid;
				    	var nickname = returnData[1].results[tmp].nickname;
				    	var timestamp = returnData[1].results[tmp].timestamp;
				    	var likecount = returnData[1].results[tmp].likeCount;
				    	var coursename = returnData[1].results[tmp].courseName;
				    	var picpath = returnData[1].results[tmp].picpath;
				    	var newDate = new Date();
				    	newDate.setTime(timestamp);
				    	// Wed Jun 18 2014 
				    	timestamp=newDate.toLocaleString();
				    	
				    	html = html + "<div class='ui two column grid'>"+
						"<div class='eleven wide column'>"+
						"<div class='comment'>"+
							"<a class='avatar'> "+
							"<img src='";
						if(picpath.length==0){
							html+="images/stevie.jpg";
						}
						else{
							html+=picpath;
						}
						html+="'>"+
							"</a>"+
							"<div class='content'>"+
								"<a class='author' href='user_getOthersProfile.action?userid="+userid+"'>"+nickname+"</a>"+
							      "<div class='metadata'>"+
							       "<span class='date'>"+timestamp+"</span>"+
							      "</div>"+
							      "<div class='author' style='margin-top:15px'>评价课程："+coursename+"</div>"+
								"<div class='text' style='margin-top:10px'>"+critics+"</div>"+
							"</div>"+
						"</div>"+
					"</div>"+
					"<div class='five wide column'>";
						if(userid == ${empty sessionScope.user.userid ? 0 : sessionScope.user.userid}){
							html +=
								"<div class='ui right floated basic blue mini button' onclick='deleteComment('"+commentid+"'>"+
									"<i class='remove icon'></i>删除"+
								"</div>"+
								"<button class='ui right floated basic red mini button' type='button'>"+
									"<i class='heart icon'></i>"+likecount+
								"</button>";
						} 
						else{
							html += 
						"<div class='ui right floated labeled mini button' tabindex='0'>"+
							"<div class='ui red mini button' type='button' onclick='likeComment("+commentid+");'>"+
								"<i class='heart icon'></i> 戳"+
							"</div>"+
							"<div id='comment"+commentid+"Count' class='ui basic red left mini basic label'>"+likecount+"</div>"+
						"</div>";	
						}
						html +=
					"</div>"+
				"</div>";
				
				  }
				    var commentlist = document.getElementById("commentlist");
				    commentlist.innerHTML=html;
				    var pageturner=document.getElementById("pageturner");
				    var cpage = returnData[0].currentPage;
				    var html2="";
					for(var i = 1;i<=${requestScope.commentPage.totalPage};i++){
						if(i==cpage){
							html2=html2+"<a class='disabled item'>"+i+"</a>";
						}
						else if(i!=cpage){
							html2=html2+"<a class='item' onclick='turnPage("+i+","+teacherid+");'>"+i+"</a>";
						}
					}

				pageturner.innerHTML=html2;
			  }
		  });
	  }
</script>
</html>














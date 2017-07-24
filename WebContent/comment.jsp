<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>课程评价-${requestScope.course.coursename }</title>
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
		</div>
	</div>

	<div class="ui main text container">
		<h1 class="ui header">评价课程：${requestScope.course.coursename }</h1>
		<br>
	</div>

	<div class="ui container" style="width: 750px">
		<form class="ui form">
			<h4 class="ui dividing header">当前课程基本信息</h4>
			<div class="ui form">
				<div class="two fields">
					<div class="field">
						<label>课程名称：${requestScope.course.coursename }</label>
					</div>
					<div class="field">
						<label>授课教师：<c:forEach
								items="${requestScope.course.teacherList }" var="teacher">
								<a class="ui label"
									href="teacher_getPage.action?teacherid=${teacher.teacherid}">${teacher.teachername }</a>
							</c:forEach></label>
					</div>
				</div>
			</div>
			<h4 class="ui dividing header">课程其他属性评价</h4>
			<div class="ui form">
				<div class="five fields">
					<div class="field">
						<div class="ui card">
							<div class="content">
								<div class="header">内容好否？</div>
							</div>
							<div class="content" style="height: 150px">
								<h4 class="ui sub header">从老师讲授知识层面来讲，内容对自己有益程度；内容有益，请给多星。</h4>
							</div>
							<div class="extra content">
								<div class="ui star rating" id="useful_star">
									<i class="icon active"></i>
									<i class="icon active"></i>
									<i class="icon active"></i>
									<i class="icon active"></i>
									<i class="icon active"></i>
								</div>
							</div>
						</div>

					</div>
					<div class="field">
						<div class="ui card">
							<div class="content">
								<div class="header">上课爽否？</div>
							</div>
							<div class="content" style="height: 150px">
								<h4 class="ui sub header">在上课时，课堂氛围情况；课堂氛围活跃，老师授课生动有趣，请给多星。</h4>
							</div>
							<div class="extra content">
								<div class="ui star rating" id="vivid_star">
									<i class="icon active"></i>
									<i class="icon active"></i>
									<i class="icon active"></i>
									<i class="icon active"></i>
									<i class="icon active"></i>
								</div>
							</div>
						</div>
					</div>
					<div class="field">
						<div class="ui card">
							<div class="content">
								<div class="header">占时少否？</div>
							</div>
							<div class="content" style="height: 150px">
								<h4 class="ui sub header">根据自己的学习经历，与其他同类型课程比较的完成课后作业或准备课后展示及与课程相关的大小考试所花费时间；占用课余时间少，请给多星。</h4>
							</div>
							<div class="extra content">
								<div class="ui star rating" id="time_star">
									<i class="icon active"></i>
									<i class="icon active"></i>
									<i class="icon active"></i>
									<i class="icon active"></i>
									<i class="icon active"></i>
								</div>
							</div>
						</div>
					</div>
					<div class="field">
						<div class="ui card">
							<div class="content">
								<div class="header">给分高否？</div>
							</div>
							<div class="content" style="height: 150px">
								<h4 class="ui sub header">根据自己的学习经历，与其他同类型课程比较的期末分情况；期末给分高，请给多星。</h4>
							</div>
							<div class="extra content">
								<div class="ui star rating" id="score_star">
									<i class="icon active"></i>
									<i class="icon active"></i>
									<i class="icon active"></i>
									<i class="icon active"></i>
									<i class="icon active"></i>
								</div>
							</div>
						</div>
					</div>
					<div class="field">
						<div class="ui card">
							<div class="content">
								<div class="header">点名多否？</div>
							</div>
							<div class="content" style="height: 150px">
								<h4 class="ui sub header">根据自己的学习经历，与其他同类型课程比较的点名情况，节节必点、每月点名、点名看老师心情、一学期点名2-3次、几乎不点名；点名频率低，请给多星。</h4>
							</div>
							<div class="extra content">
								<div class="ui star rating" id="roll_star">
									<i class="icon active"></i>
									<i class="icon active"></i>
									<i class="icon active"></i>
									<i class="icon active"></i>
									<i class="icon active"></i>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- <h4 class="ui dividing header">课程期末考核方式</h4>
			<select class="ui fluid search final dropdown">
				<option value="">请选择考核方式</option>
				<option value="1">论文结课</option>
				<option value="2">开卷考试</option>
				<option value="3">闭卷考试</option>
				<option value="4">其他</option>
			</select> -->
			<h4 class="ui dividing header">嗯。你要评价的是哪个老师哇</h4>
			<select class="ui fluid search teacher dropdown">
				<c:forEach items="${requestScope.course.teacherList }" var="teacher">
					<option value="${teacher.teacherid}">${teacher.teachername }</option>
				</c:forEach>
			</select>
			<h4 class="ui dividing header">给它打个总分吧！</h4>
			<div class="ui massive star rating" id="recomm_star">
									<i class="icon active"></i>
									<i class="icon active"></i>
									<i class="icon active"></i>
									<i class="icon active"></i>
									<i class="icon active"></i>
			</div>
			<h4 class="ui dividing header">嗯，老司机有话要说。</h4>
			<div class="field">
				<textarea id="critics"></textarea>
			</div>
			<button class="ui blue labeled icon button" type=button onclick="submitComment()">
				<i class="icon edit"></i> 发言完毕！准备提交！
			</button>
		</form>
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
			<i class="checkmark icon"></i> 评论成功
		</div>
		<div class="actions">
			<button class="ui green ok inverted button" type="button" onclick="window.location.href='course_getPage.action?courseid=${requestScope.course.courseid }'">
				<i class="checkmark icon"></i> 确定
			</button>
		</div>
	</div>
</body>
<script type="text/javascript">
	//初始化属性评分：初始化：3颗星 max：5颗星
	$('.ui.rating').rating({
		maxRating : 5
	});
	//提示信息弹出
	$('.activating.element').popup();
	//期末考核形式
	$('.ui.dropdown').dropdown();
	//提交
	function submitComment() {
		var teacherid = $('.ui.teacher.dropdown').dropdown("get value");
		var courseid = ${requestScope.course.courseid };
		var userid = ${sessionScope.user.userid };
		var useful = $('#useful_star').rating("get rating");
		var vivid = $('#vivid_star').rating("get rating");
		var time = $('#time_star').rating("get rating");
		var score = $('#score_star').rating("get rating");
		var roll = $('#roll_star').rating("get rating");
		var recomm = $('#recomm_star').rating("get rating");
		var critics = document.getElementById('critics').value;
		$.ajax({
		 	type:'post',
		 	url:"${pageContext.request.contextPath}/addComment.action",
		 	data:{
		 		"teacher.teacherid":teacherid,
		 		"course.courseid":courseid,
		 		"user.userid":userid,
		 		"ratingUsefulness":useful,
				"ratingVividness":vivid,
				"ratingSpareTimeOccupation":time,
				"ratingScoring":score,
				"ratingRollCall":roll,
				"recommandScore":recomm,
				"critics":critics
		 		},
			success:function(data){
				$('.ui.basic.modal')
				  .modal('show')
				;
			}
	 	});
	}
</script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

.overlay .menu {
	position: relative;
	left: 0;
	transition: left 0.5s ease;
}

.overlay.fixed .menu {
	left: 800px;
}
#chart {
  text-align: left;
  box-shadow: 0px 2px 8px rgba(0, 0, 0, 0.2);
  border: 1px solid #aaa;
  margin: 32px auto;
  background: white;
}
</style>
<script src="js/jquery.js"></script>
<script src="js/index.js"></script>
</head>

<body>
	<div class="ui fixed inverted menu">
		<div class="ui container">
			<a href="#" class="header item"> <img class="logo"
				src="images/testPic.jpg"> 大众点评课
			</a> <a href="homepage.jsp" class="item">主页</a>  <a href="index.jsp"
				class="item">返回</a>
			<div class="ui simple dropdown item">
				课程搜索 <i class="dropdown icon"></i>
				<div class="menu">
					<a class="item" href="courseSearchByCname.jsp">按课程名称</a> <a
						class="item" href="courseSearchByTname.jsp">按授课教师</a>
				</div>
			</div>
		</div>
	</div>


	<div class="ui container" style="width: 750px">
		<div class="ui main text container">
		
		
		<!-- 这里是 收藏课程的action-->
			<form class="ui form">
				<div class="two fields">
					<div class="field">
						<h1 class="ui header">课程名称1</h1>
						<span class="date">
							<h4>
								推荐星级
								<div class="ui star rating">
									<i class="icon active"></i>
								</div>
							</h4>
						</span> <span class="date"><h4>
								授课教师：<a href="#"> 教师A</a>
							</h4> </span><br>
						<button class="ui primary button" type="submit">嗯，收藏。</button>
					</div>
					<div class="field">
						<div class="ui raised aligned segment" style="width: 250px">
							<!-- <img class="medium ui left aligned image " src="images/jenny.jpg">-->
							<div id="chart"></div>
						</div>
					</div>
					<br>
				</div>
			</form>
		</div>
		<h4 class="ui dividing header">课程其他属性评价</h4>
		<div class="ui text container">
			<div class="ui form">
				<div class="five fields">
					<div class="field">
						<div class="ui card">
							<div class="content">
								<div class="header">内容有用否?</div>
							</div>
							<div class="content" style="height: 150px">
								<h4 class="ui sub header">从老师讲授知识层面来讲，内容对自己有益程度；内容有益，请给多星。</h4>
							</div>
							<div class="extra content">
								<div class="ui star rating" data-rating="3" data-max-rating="5">
									<i class="icon active"></i>
								</div>
							</div>
						</div>

					</div>
					<div class="field">
						<div class="ui card">
							<div class="content">
								<div class="header">课堂生动否?</div>
							</div>
							<div class="content" style="height: 150px">
								<h4 class="ui sub header">在上课时，课堂氛围情况；课堂氛围活跃，老师授课生动有趣，请给多星。</h4>
							</div>
							<div class="extra content">
								<div class="ui star rating" data-rating="3" data-max-rating="5">
									<i class="icon active"></i> <i class="icon active"></i> <i
										class="icon active"></i> <i class="icon active"></i> <i
										class="icon active"></i>
								</div>
							</div>
						</div>
					</div>
					<div class="field">
						<div class="ui card">
							<div class="content">
								<div class="header">占用课余否?</div>
							</div>
							<div class="content" style="height: 150px">
								<h4 class="ui sub header">根据自己的学习经历，与其他同类型课程比较的完成课后作业或准备课后展示及与课程相关的大小考试所花费时间；占用课余时间少，请给多星。</h4>
							</div>
							<div class="extra content">
								<div class="ui star rating" data-rating="3" data-max-rating="5">
									<i class="icon active"></i> <i class="icon active"></i>
								</div>
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
								<div class="ui star rating" data-rating="3" data-max-rating="5">
									<i class="icon active"></i> <i class="icon active"></i> <i
										class="icon active"></i> <i class="icon active"></i> <i
										class="icon active"></i>
								</div>
							</div>
						</div>
					</div>
					<div class="field">
						<div class="ui card">
							<div class="content">
								<div class="header">点名多否?</div>
							</div>
							<div class="content" style="height: 150px">
								<h4 class="ui sub header">根据自己的学习经历，与其他同类型课程比较的点名情况，节节必点、每月点名、点名看老师心情、一学期点名2-3次、几乎不点名；点名频率低，请给多星。</h4>
							</div>
							<div class="extra content">
								<div class="ui star rating" data-rating="3" data-max-rating="5">
									<i class="icon active"></i> <i class="icon active"></i> <i
										class="icon active"></i>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 
			<div class="overlay">
				<div class="ui labeled icon vertical menu">
					<a class="item"><i class="twitter icon"></i> 收藏该课</a> 
					<a class="item"><i class="facebook icon"></i> 教师详情</a> 
				</div>
			</div>
			 -->
			<h4 class="ui dividing header">嗯，老司机们这样说。</h4>
			<div class="ui raised aligned segment">
				<div class="ui comments">
					<div class="comment">
						<a class="avatar"> <img src="images/elliot.jpg">
						</a>
						<div class="content">
							<a class="author">鲁迪</a>
							<div class="text">喜欢圣经与西方文化的孩子上辈子一定是拯救了世界的天使，比如我，鲁迪。</div>
					
					<!-- 这里是 点赞评论的action-->
							<form class="actions">
								<div class="ui labeled button" tabindex="0">
									<div class="ui red button">
										<i class="heart icon"></i> 戳
									</div>
									<div class="ui basic red left pointing label"> 1,048 </div>

								</div>
							</form>
						</div>
					</div>
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
$(function(){
	  $('#chart').radarChart({
	    size: [500, 400],
	    step: 1,
	    title: "My Skills",
	    values: {
	      "JavaScript": 5,
	      "Node.js": 3.5,
	      "jQuery": 4,
	      "PHP": 3,
	      "C++": 2.5
	    },
	    showAxisLabels: true
	  });
	});
</script>
</html>

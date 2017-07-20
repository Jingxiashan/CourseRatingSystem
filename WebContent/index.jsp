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
			<a href="#" class="header item"> <img class="logo"
				src="images/testPic.jpg"> 大众点评课
			</a> <a href="homepage.jsp" class="item">主页</a>
			<div class="ui simple dropdown item">
				课程搜索 <i class="dropdown icon"></i>
				<div class="menu">
					<a class="item" href="courseSearchByCname.jsp">按课程名称</a> 
					<a class="item" href="courseSearchByTname.jsp">按授课教师</a>
				</div>
			</div>
		</div>
	</div>

	<div class="ui main text container">
		<h1 class="ui header">课程信息</h1>
		<br>
	</div>

	<div class="ui center aligned grid">
		<div class="ui special cards" style="size: 100px">
			<div class="card">
				<div class="blurring dimmable image">
					<div class="ui inverted dimmer">
						<div class="content">
							<div class="center">
								<div class="ui inverted button"><a href="homepage.jsp">“戳”</a></div>
							</div>
						</div>
					</div>
					<img src="images/jenny.jpg">
				</div>
				<div class="content">
					<pre><h3>课程名称1          教师A</h3></pre>
					<div class="meta">
						<span class="date"><h4>推荐星级</h4>
							<div class="ui star rating">
								<i class="icon active"></i>
							</div> </span>
					</div>
				</div>
				<div class="extra content">
					<i class="smile icon"></i><a href="addCoursemark.jsp">老司机想说几句，嗯？</a>	
				</div>
					
			</div>
			<div class="card">
				<div class="blurring dimmable image">
					<div class="ui inverted dimmer">
						<div class="content">
							<div class="center">
								<div class="ui inverted button"><a href="homepage.jsp">“戳”</a></div>
							</div>
						</div>
					</div>
					<img src="images/elliot.jpg">
				</div>
				<div class="content">
					<pre><h3>课程名称2          教师B</h3></pre>
					<div class="meta">
						<span class="date"><h4>推荐星级</h4>
							<div class="ui star rating">
								<i class="icon active"></i>
							</div> </span>
					</div>
				</div>
				<div class="extra content">
					<i class="smile icon"></i><a href="addCoursemark.jsp">老司机想说几句，嗯？</a>	
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
</script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<!-- Standard Meta -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<link rel="stylesheet prefech"
	href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.11/semantic.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.11/semantic.js"></script>
<!-- Site Properties -->
<title>Homepage - CourseRatingSystem</title>
<link rel="stylesheet" type="text/css"
	href="../dist/components/reset.css">
<link rel="stylesheet" type="text/css"
	href="../dist/components/site.css">

<link rel="stylesheet" type="text/css"
	href="../dist/components/container.css">
<link rel="stylesheet" type="text/css"
	href="../dist/components/grid.css">
<link rel="stylesheet" type="text/css"
	href="../dist/components/header.css">
<link rel="stylesheet" type="text/css"
	href="../dist/components/image.css">
<link rel="stylesheet" type="text/css"
	href="../dist/components/menu.css">

<link rel="stylesheet" type="text/css"
	href="../dist/components/divider.css">
<link rel="stylesheet" type="text/css"
	href="../dist/components/dropdown.css">
<link rel="stylesheet" type="text/css"
	href="../dist/components/segment.css">
<link rel="stylesheet" type="text/css"
	href="../dist/components/button.css">
<link rel="stylesheet" type="text/css"
	href="../dist/components/list.css">
<link rel="stylesheet" type="text/css"
	href="../dist/components/icon.css">
<link rel="stylesheet" type="text/css"
	href="../dist/components/sidebar.css">
<link rel="stylesheet" type="text/css"
	href="../dist/components/transition.css">

<style type="text/css">
.hidden.menu {
	display: none;
}

.masthead.segment {
	min-height: 700px;
	padding: 1em 0em;
}

.masthead .logo.item img {
	margin-right: 1em;
}

.masthead .ui.menu .ui.button {
	margin-left: 0.5em;
}

.masthead h1.ui.header {
	margin-top: 3em;
	margin-bottom: 0em;
	font-size: 4em;
	font-weight: normal;
}

.masthead h2 {
	font-size: 1.7em;
	font-weight: normal;
}

.ui.vertical.stripe {
	padding: 8em 0em;
}

.ui.vertical.stripe h3 {
	font-size: 2em;
}

.ui.vertical.stripe .button+h3,.ui.vertical.stripe p+h3 {
	margin-top: 3em;
}

.ui.vertical.stripe .floated.image {
	clear: both;
}

.ui.vertical.stripe p {
	font-size: 1.33em;
}

.ui.vertical.stripe .horizontal.divider {
	margin: 3em 0em;
}

.quote.stripe.segment {
	padding: 0em;
}

.quote.stripe.segment .grid .column {
	padding-top: 5em;
	padding-bottom: 5em;
}

.footer.segment {
	padding: 5em 0em;
}

.secondary.pointing.menu .toc.item {
	display: none;
}

@media only screen and (max-width: 700px) {
	.ui.fixed.menu {
		display: none !important;
	}
	.secondary.pointing.menu .item,.secondary.pointing.menu .menu {
		display: none;
	}
	.secondary.pointing.menu .toc.item {
		display: block;
	}
	.masthead.segment {
		min-height: 350px;
	}
	.masthead h1.ui.header {
		font-size: 2em;
		margin-top: 1.5em;
	}
	.masthead h2 {
		margin-top: 0.5em;
		font-size: 1.5em;
	}
}
</style>

<script src="assets/library/jquery.min.js"></script>
<script src="../dist/components/visibility.js"></script>
<script src="../dist/components/sidebar.js"></script>
<script src="../dist/components/transition.js"></script>
<script>
  $(document)
    .ready(function() {

      // fix menu when passed
      $('.masthead')
        .visibility({
          once: false,
          onBottomPassed: function() {
            $('.fixed.menu').transition('fade in');
          },
          onBottomPassedReverse: function() {
            $('.fixed.menu').transition('fade out');
          }
        })
      ;

      // create sidebar and attach to menu open
      $('.ui.sidebar')
        .sidebar('attach events', '.toc.item')
      ;

    })
  ;
  </script>
</head>
<body>

	<!-- Following Menu -->
	<div class="ui large top fixed hidden menu">
		<div class="ui container">
			<a class="active item">主页</a> <a href="customerIndex.jsp"
				class="item">课程详情</a>
			<div class="right menu">
				<div class="item">
					<a href="login.jsp" class="ui button">登录</a>
				</div>
				<div class="item">
					<a href="login.jsp" class="ui primary button">注册</a>
				</div>
			</div>
		</div>
	</div>

	<!-- Sidebar Menu -->
	<div class="ui vertical inverted sidebar menu">
		<a class="active item">主页</a> <a href="customerIndex.jsp" class="item">课程详情</a>
		<a href="login.jsp" class="ui inverted button">登录</a> <a
			href="signup.jsp" class="ui inverted button">注册</a>
	</div>


	<!-- Page Contents -->
	<div class="pusher">
		<div class="ui inverted vertical masthead center aligned segment">

			<div class="ui container">
				<div class="ui large secondary inverted pointing menu">
					<a class="toc item"> <i class="sidebar icon"></i>
					</a> <a class="active item">主页</a> <a href="customerIndex.jsp"
						class="item">课程详情</a>
					<div class="right item">
						<a href="login.jsp" class="ui inverted button">登录</a> <a
							href="signup.jsp" class="ui inverted button">注册</a>
					</div>
				</div>
			</div>

			<div class="ui text container">
				<h1 class="ui inverted header">大众点评课</h1>
				<h2>“专门打造给你看的选课攻略”</h2>
			</div>
		</div>
		<div class="ui horizontal">
			<div class="ui vertical">
				<div class="ui middle aligned stackable grid container">
					<div class="row">
						<div class="ui vertical stripe segment">
							<div class="ui text container">
								<h3 class="ui header">提供一切你最想知道的关于课程的信息。</h3>
								<p>给分情况？/期末考评方式？/点名平率？/课堂氛围？</p>
								</h4>
								<h3 class="ui header">听听老司机们血的教训/拔草经历</h3>
								<p>获得来自过来人的第一笔资料。</p>
							</div>
						</div>
						<div class="six wide right floated column">
							<img src="images/testPic.jpg"
								class="ui large bordered rounded image">
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="ui inverted vertical footer segment">
			<div class="ui container">
				<div
					class="ui stackable inverted divided equal height stackable grid">
					<div class="three wide column">
						<h4 class="ui inverted header">关于</h4>
						<div class="ui inverted link list">
							<a href="#" class="item">网站介绍</a> <a href="#" class="item">联系我们</a>
						</div>
					</div>
					<div class="seven wide column">
						<h4 class="ui inverted header">大众点评课</h4>
						<p>只做给你看的选课攻略。</p>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>

</html>
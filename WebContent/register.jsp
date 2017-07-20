<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="Shortcut Icon"
	href="//www.dpfile.com/s/res/favicon.5ff777c11d7833e57e01c9d192b7e427.ico"
	type="image/x-icon">
<link rel="stylesheet prefech"
	href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.11/semantic.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.11/semantic.js"></script>
<title>注册-大众点评课</title>
<!-- Site Properties -->
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
	$(document).ready(function() {

		// fix menu when passed
		$('.masthead').visibility({
			once : false,
			onBottomPassed : function() {
				$('.fixed.menu').transition('fade in');
			},
			onBottomPassedReverse : function() {
				$('.fixed.menu').transition('fade out');
			}
		});

		// create sidebar and attach to menu open
		$('.ui.sidebar').sidebar('attach events', '.toc.item');

	});
</script>
</head>

<body>

	<div class="ui inverted vertical masthead center aligned segment">
		<div class="ui container">
			<div class="ui large secondary inverted pointing menu">
				<a class="toc item"> <i class="sidebar icon"></i>
				</a> <a class="active item">注册</a> <a href="homepage.jsp" class="item">主页</a>
			</div>
		</div>

		${requestScope.message }
		<div class="ui container" style="margin-top: 10rem; width: 450px">
			<div class="column">
				<form class="ui large form" action="register" method="post">
					<div class="ui stacked inverted aligned right segment">
						<div class="field">
							<div class="ui left icon inverted transparent input">
								<i class="user icon"></i> <input type="text" name="username"
									placeholder="请输入用户名">
							</div>
						</div>
						<div class="field">
							<div class="ui left icon inverted transparent input">
								<i class="lock icon"></i> <input type="password"
									name="password1" placeholder="请输入密码">
							</div>
						</div>
						<div class="field">
							<div class="ui left icon inverted transparent input">
								<i class="lock icon"></i> <input type="password"
									name="password2" placeholder="请再次输入密码">
							</div>
						</div>

						<div class="ui inverted divider"></div>
						<div class="field">
							<div class="ui left icon inverted transparent input">
								<i class="child icon"></i> <input type="text" name="nickname"
									placeholder="请输入昵称">
							</div>
						</div>
						<div class="field">
							<select class="ui inverted dropdown" name="grade">
								<option value="">请选择年级</option>
								<option value="2010">2010级</option>
								<option value="2011">2011级</option>
								<option value="2012">2012级</option>
								<option value="2013">2013级</option>
								<option value="2014">2014级</option>
								<option value="2015">2015级</option>
								<option value="2016">2016级</option>
								<option value="2017">2017级</option>
								<option value="2018">2018级</option>
							</select>
						</div>
					</div>
					<h4 class="ui horizontal inverted divider">欢迎你，我的朋友</h4>
					<button class="ui inverted basic button" type="submit">注册</button>
					<div class="ui inverted message">
						已经是老朋友啦？ <a href="login.jsp">登录</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
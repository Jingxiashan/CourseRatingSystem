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
<title>登录-大众点评课</title>
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
<style type="text/css">
body {
	background-color: #DADADA;
}

body>.grid {
	height: 100%;
}

.image {
	margin-top: -100px;
}

.column {
	max-width: 450px;
}
</style>

<body>
	<div class="ui inverted vertical masthead center aligned segment">
		<div class="ui container">
			<div class="ui large secondary inverted pointing menu">
				<a class="toc item"> <i class="sidebar icon"></i>
				</a> <a class="active item">主页</a> <a href="customerIndex.jsp"
					class="item">课程详情</a>
				<div class="right item">
					<a href="login.jsp" class="ui inverted button">登录</a> <a
						href="register.jsp" class="ui inverted button">注册</a>
				</div>
			</div>
		</div>
	</div>
		<s:actionerror />
		${requestScope.message }
		<div class="ui center aligned segment">
			<div class="ui inverted center aligned segment">
				<div class="column">
					<form class="ui large form" action="login" method="post">
						<div class="ui stacked segment">
							<div class="field">
								<div class="ui left icon input">
									<i class="user icon"></i> <input type="text" name="username"
										placeholder="Username">
								</div>
							</div>
							<div class="ui inverted divider"></div>
							<div class="field">
								<div class="ui left icon input">
									<i class="lock icon"></i> <input type="password" name="password"
										placeholder="Password">
								</div>
							</div>
						</div>
							<h4 class="ui horizontal inverted divider">登录大众点评课</h4>
					</form>
					<div class="ui message">
						第一次访问本网站？ <a href="register.jsp">注册</a>
					</div>
				</div>
			</div>
		</div>
</body>
</html>

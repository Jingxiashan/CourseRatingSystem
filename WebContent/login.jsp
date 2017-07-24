<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="Shortcut Icon"
	href="images/logos/icon.ico"
	type="image/x-icon">
<link rel="stylesheet prefech"
	href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.11/semantic.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.11/semantic.js"></script>
<title>登录-我的课</title>


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
				</a> <a class="active item">登录</a> <a href="homepage.jsp" class="item">主页</a>
			</div>
		</div>



				<div class="ui container" style="margin-top: 10rem; width: 450px">
			<div class="column">
				<form class="ui large form" id="loginForm" method="post">
					<div class="ui stacked inverted segment">
						<div class="field">
							<div class="ui left icon inverted transparent input">
								<i class="user icon"></i> <input type="text" name="username" id="username"
									placeholder="用户名" style="color:#FFFFFF">
							</div>
						</div>
						<div class="ui inverted divider"></div>
						<div class="field">
							<div class="ui left icon inverted transparent input">
								<i class="lock icon"></i> <input type="password" name="password" id="password"
									placeholder="密码" style="color:#FFFFFF">
							</div>
						</div>
					</div>
					<h4 class="ui horizontal inverted divider">好久不见？</h4>
					<button class="ui inverted basic button" type="button" onclick="login()">登录</button>
				</form>
					<div class="ui inverted message">
						不如交个朋友，嗯？ <a href="register.jsp">注册</a>
					</div>
			</div>
		</div>
	</div>
	<div class="ui basic modal">
		<div class="ui icon header" id="modalTitle">
			<i class="remove icon"></i> 登陆失败
		</div>
		<div class="content">
    		<p id="modalMessage"></p>
  		</div>
		<div class="actions">
			<button class="ui green ok inverted button" type="button">
				<i class="checkmark icon"></i> 确定
			</button>
		</div>
	</div>
</body>
<script>
function login(){
	var username = document.getElementById('username').value;
	var password = document.getElementById('password').value;
	$.ajax({
		type:'post',
	 	url:"${pageContext.request.contextPath}/login.action",
	 	data:{
	 		"username":username,
	 		"password":password
	 		},
		success:function(data){
			var result = data;			console.log(result);
			if(result == "success"){
				window.location.href="course_findAll.action";
			}else{
				document.getElementById("modalMessage").innerHTML = result;
				$('.ui.basic.modal')
				  .modal('show')
				;	
			} 
			
		}
	});
}
</script>
</html>

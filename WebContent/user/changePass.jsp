<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Standard Meta -->
<link rel="Shortcut Icon"
	href="../images/logos/icon.ico"
	type="image/x-icon">
<c:if test="${empty sessionScope.user.userid }">
	<meta http-equiv="refresh" content="0;url=../404.jsp"> 
</c:if>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<link rel="stylesheet prefech"
	href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.11/semantic.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script
	src="../js/sha1.js"></script>
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

<title>个人中心 - 我的课</title>
</head>

<body id="example">

<div class="ui two column grid">


	<div class="three wide column">
		<div class="ui vertical inverted sticky menu" style="position:fixed!important;top:0">
			<div class="item" style="width: 80px">
				<img style="background:#FFFFFF" class="ui tiny image" src="${empty sessionScope.user.picpath ? 'images/stevie.jpg' : sessionScope.user.picpath }">
			</div>
			<div class="container" style="color: #FFFFFF">
				<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;好久不见，${sessionScope.user.nickname }。</b>
			</div>
			<br>
			<div class="item">
				<div class="header">个人中心</div>
				<div class="menu">
					<a class="item" href="./">个人中心 </a>
					<a href="../logout.action" class="item">注销</a>
				</div>
			</div>
			<div class="item">
				<div class="header">课程管理</div>
				<div class="menu">
					<a class="item" href="./favourites.jsp">课程收藏管理 </a>
				</div>
			</div>
			<div class="item">
				<div class="header">评论管理</div>
				<div class="menu"><a class="item" href="./comments.jsp">发表评论管理</a></div>
			</div>
			<div class="item">
				<div class="header">个人信息管理</div>
				<div class="menu">
					<a class="item" href="./modifyProfile.jsp"> 修改个人信息 </a> 
					<a class="item" href="./changePass.jsp"> 修改个人密码 </a>
				</div>
			</div>
			<div class="item" style="height: 750px">
				<div class="header"><i class="left arrow icon"></i></div>
				<div class="menu">
					<a href="../course_findAll.action" class="item">课程详情</a>					
					<a class="item" href="../courseSearchByCname.jsp">课程查询</a>
					<a class="item" href="../homepage.jsp">网站介绍</a> 
					<a class="item" href="../about.jsp">关于我们</a>
				</div>
			</div>
		</div>
	</div>


	<div class="thirteen wide column">
		<div class="ui container" style="background:#FFFFFF;padding-left:50px;width:auto">
			<div class="article">
			


				<div class="ui dividing header" style="width: 80%;margin-top:80px">
					<h2>修改个人密码</h2>
				</div>	
							

				<div class="ui container">
					<form class="ui form" style="width: 80%">
						<div class="ui basic segment">
							<div class="field">
								<input type="hidden" name="userid"
									value="${sessionScope.user.userid }" />
							</div>
							<div class="field">
								<label>原密码</label> <input type="password" name="oldPassword" id="oldPassword"
									placeholder="请输入旧密码" />
							</div>
							<div class="field">
								<label>新密码</label> 
								<input type="password" name="newPassword1" id="newPassword1" onblur="checkPassword()"
									placeholder="请输入新密码" />
							</div>
							<div class="field">
								<label>确认密码</label> 
								<input type="password" name="newPassword2" id="newPassword2" onblur="checkPassword()"
									placeholder="请再次输入新密码" />
							</div>
							<div class="field" id="passwordHint"></div>
						</div>
						<button class="ui right floated black basic button" type="button" onclick="changePass()" id="submitButton">修改</button>
					</form>
				</div>
			</div>
		</div>

	</div>


</div>
<div class="ui basic modal">
		<div class="ui icon header" id="modalTitle">
			<i class="remove icon" id="modalIcon"></i> 修改失败
		</div>
		<div class="content">
    		<p id="modalMessage"></p>
  		</div>
		<div class="actions">
			<button class="ui green ok inverted button" type="button" id="modalButton">
				<i class="checkmark icon"></i> 确定
			</button>
		</div>
	</div>
</body>
<script>
function checkPassword(){
	var password1 = document.getElementById('newPassword1').value;
	var password2 = document.getElementById('newPassword2').value;
	if(password2.length == 0){
		return;
	}
	var passwordHint = document.getElementById("passwordHint");
	var registerButton = document.getElementById("submitButton");
	if(password1 == password2){
		if(password1.length < 6){
			passwordHint.innerHTML="<i class='remove icon'></i>密码太短啦！！！这么不安全的密码都不敢给你存！";
			registerButton.className="ui right floated disabled black basic button";
			$('#passwordHint').transition('tada');
		}else{
			passwordHint.innerHTML="<i class='checkmark icon'></i>哇密码通过啦！";
			registerButton.className="ui right floated black basic button";			
		}
	}else{
		passwordHint.innerHTML="<i class='remove icon'></i>手残嘛！两次密码都输得不一样！";
		registerButton.className="ui right floated disabled black basic button";
		$('#passwordHint').transition('tada');
		
	}
}
function changePass(){
	var oldPassword = document.getElementById('oldPassword').value;
	var password1 = document.getElementById('newPassword1').value;
	var password2 = document.getElementById('newPassword2').value;

	var modalMessage = document.getElementById('modalMessage');
	var modalTitle = document.getElementById('modalTitle');
	var modalButton = document.getElementById('modalButton');
	if(oldPassword.length == 0){
		modalMessage.innerHTML = "原密码不能为空啊！";
		modalTitle.innerHTML = "<i class='remove icon' id='modalIcon'></i> 修改失败"
		modalButton.removeAttribute("onclick");
		$('.ui.basic.modal')
		  .modal('show')
		;
		return;
	}
	if(password1.length == 0 || password2.length == 0){
		modalMessage.innerHTML = "新密码不能为空啊！";
		modalTitle.innerHTML = "<i class='remove icon' id='modalIcon'></i> 修改失败"
			modalButton.removeAttribute("onclick");
		$('.ui.basic.modal')
		  .modal('show')
		;
		return;
	}
	var sha1_newPassword = hex_sha1(password1);
	var sha1_oldPassword = hex_sha1(oldPassword);
	$.ajax({
		type:'post',
	 	url:"${pageContext.request.contextPath}/changePassword.action",
	 	data:{
	 		"userid":${sessionScope.user.userid },
	 		"oldPassword":sha1_oldPassword,
	 		"newPassword":sha1_newPassword
	 		},
		success:function(data){
			if(data == "success"){
				modalTitle.innerHTML = "<i class='checkmark icon' id='modalIcon'></i> 修改密码成功"
				modalMessage.innerHTML = "密码修改成功！";
				modalButton.setAttribute("onclick","window.location.href='./'");
				$('.ui.basic.modal')
				  .modal('show')
				;
			}else{
				modalMessage.innerHTML = data;
				modalTitle.innerHTML = "<i class='remove icon' id='modalIcon'></i> 修改密码失败"
					modalButton.removeAttribute("onclick");
				$('.ui.basic.modal')
				  .modal('show')
				;
			}
		}
	});
}
</script>
</html>













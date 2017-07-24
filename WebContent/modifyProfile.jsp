<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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

<title>修改个人信息 - 我的课</title>
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
					<a class="item" href="user.jsp">个人中心 </a>
					<a href="logout.action" class="item">注销</a>
				</div>
			</div>
			<div class="item">
				<div class="header">课程管理</div>
				<div class="menu">
					<a class="item" href="user_allfavourites.jsp">课程收藏管理 </a>
				</div>
			</div>
			<div class="item">
				<div class="header">评论管理</div>
				<div class="menu"><a class="item" href="user_allcomments.jsp">发表评论管理</a></div>
			</div>
			<div class="item">
				<div class="header">个人信息管理</div>
				<div class="menu">
					<a class="item" href="modifyProfile.jsp"> 修改个人信息 </a> 
					<a class="item" href="changePass.jsp"> 修改个人密码 </a>
				</div>
			</div>
			<div class="item" style="height: 750px">
				<div class="header"><i class="left arrow icon"></i></div>
				<div class="menu">
					<a href="course_findAll.action" class="item">课程详情</a>					
					<a class="item" href="courseSearchByCname.jsp">课程查询</a>
					<a class="item" href="homepage.jsp">网站介绍</a> 
					<a class="item" href="about.jsp">关于我们</a>
				</div>
			</div>
		</div>
	</div>


	<div class="thirteen wide column">
		<div class="ui container" style="background:#FFFFFF;padding-left:50px;width:auto">
			<div class="article">
			
			
				<div class="ui dividing header" style="width: 80%;margin-top:80px">
					<h2>修改个人信息</h2>
				</div>
			

				<div class="ui container">
					<form class="ui form" style="width: 80%">
						<div class="ui basic segment">
						
						
						
						<!-- <label for="upload">上传头像:</label>
						<input type="file" name="avatar" id="avatar" onchange="preImg(this.id,'imgPre')"> 
				            <img id="imgPre" src="" style="display: block;" /> 
				            <input type="text" name="userid"> 
				 		<button type="submit">上传</button> -->
						
							<div class="field" style="width:150px">
								<label>头像</label> 
								<img class="ui small image" id="avatarPre" src="${empty sessionScope.user.picpath ? 'images/stevie.jpg' : sessionScope.user.picpath }" style="display:block"/>
								<label for="avatar" class="ui basic icon button" id="cvIntro"> <i class="user circle outline icon"></i>上传新头像</label>
                    			<input type="file" id="avatar" name="avatar" style="display:none" onchange="preImg(this.id,'avatarPre')">
							</div>
						
						
						
						
							<div class="field">
								<label>昵称</label> <input type="text" name="nickname" id="nickname"
									value="${sessionScope.user.nickname }" placeholder="请设置昵称" />
							</div>
							<div class="field">
								<label>微信账号</label> <input type="text" name="wechatAccount" id="wechatAccount"
									value="${sessionScope.user.wechatAccount }"
									placeholder="请填写您的微信账号" />
							</div>
							<div class="field">
								<label>年级</label> <select class="ui search dropdown" id="gradeSelect" name="grade">
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
							<div class="field">
								<label>简介</label> 
								<textarea type="text" name="introduction" id="introduction"
									placeholder="请填写关于您的简介" >${sessionScope.user.introduction }</textarea>
							</div>
						</div>
						<button class="ui black basic right floated button" type="button" onclick="modifyProfile()">修改信息</button>
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
$("#gradeSelect").dropdown('set selected',${sessionScope.user.grade });
function modifyProfile(){
	var formData = new FormData($('.ui.form')[0]);
	var nickname = document.getElementById("nickname").value;
	var wechatAccount = document.getElementById("wechatAccount").value;
	var gradeSelect = document.getElementById("gradeSelect").value;
	var introduction = document.getElementById("introduction").value;
	var modalMessage = document.getElementById("modalMessage");
	var modalTitle = document.getElementById("modalTitle");
	var modalButton = document.getElementById("modalButton");
	console.log(gradeSelect);
	if(nickname.length == 0){
		modalMessage.innerHTML = "昵称不能为空啊！";
		modalTitle.innerHTML = "<i class='remove icon' id='modalIcon'></i> 修改失败"
		modalButton.removeAttribute("onclick");
		$('.ui.basic.modal')
		  .modal('show')
		;
		return;
	}
	if(wechatAccount.length == 0){
		modalMessage.innerHTML = "微信账号不能为空啊！";
		modalTitle.innerHTML = "<i class='remove icon' id='modalIcon'></i> 修改失败"
		modalButton.removeAttribute("onclick");
		$('.ui.basic.modal')
		  .modal('show')
		;
		return;
	}
	if(gradeSelect.length == 0){
		modalMessage.innerHTML = "年级不能为空啊！";
		modalTitle.innerHTML = "<i class='remove icon' id='modalIcon'></i> 修改失败"
		modalButton.removeAttribute("onclick");
		$('.ui.basic.modal')
		  .modal('show')
		;
		return;
	}
	if(introduction.length == 0){
		modalMessage.innerHTML = "个人简介不能为空啊！";
		modalTitle.innerHTML = "<i class='remove icon' id='modalIcon'></i> 修改失败"
		modalButton.removeAttribute("onclick");
		$('.ui.basic.modal')
		  .modal('show')
		;
		return;
	}
	$.ajax({
		type:'post',
	 	url:"${pageContext.request.contextPath}/json_user_modifyProfile.action",
	 	data:formData,
		processData: false,
		contentType: false,
		cache: false,
		success:function(data){
			if(data == "success"){
				modalTitle.innerHTML = "<i class='checkmark icon' id='modalIcon'></i> 修改信息成功";
				modalMessage.innerHTML = "";
				modalButton.setAttribute("onclick","window.location.href='user.jsp'");
				$('.ui.basic.modal')
				  .modal('show')
				;
			}else{
				modalMessage.innerHTML = data;
				modalTitle.innerHTML = "<i class='remove icon' id='modalIcon'></i> 修改信息失败";
				modalMessage.innerHTML = "";
				modalButton.removeAttribute("onclick");
				$('.ui.basic.modal')
				  .modal('show')
				;
			}
		}
	}); 
}
function preImg(sourceId, targetId) {  
    if (typeof FileReader === 'undefined') {  
        alert('Your browser does not support photo uploads...');  
        return;  
    }  
    var reader = new FileReader();  
  
    reader.onload = function(e) {  
        var img = document.getElementById(targetId);  
        img.src = this.result;  
    }  
    reader.readAsDataURL(document.getElementById(sourceId).files[0]);  
}  
</script>
</html>
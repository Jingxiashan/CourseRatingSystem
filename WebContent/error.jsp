<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>出错啦</title>
<link rel="Shortcut Icon"
	href="images/logos/icon.ico"
	type="image/x-icon">
<link rel="stylesheet prefech"
	href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.11/semantic.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.11/semantic.js"></script>
</head>
<body style="background:#1B1C1D;text-align:center">
	<div class="ui sizer vertical segment" style="font-size:60px;margin-top:120px">
	  <div class="ui huge header" style="color:white">出错啦</div>
	</div>
	<div class="ui sizer vertical segment">
	  <div class="ui huge header" style="color:white" id="hint">3秒后返回主页...</div>
	</div>

</body>
<script>
$(document).ready(function() {
	var countDown = 3;
	var hint = document.getElementById("hint");
	hint.innerHTML = countDown + "秒后返回主页..."
	setInterval(function(){
		countDown--;
		hint.innerHTML = countDown + "秒后返回主页...";
	},1000);
	setTimeout(function(){
		window.location.href="homepage.jsp";	
	},countDown * 1000); 
	
});
</script>
</html>
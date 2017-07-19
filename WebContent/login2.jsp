<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link rel="stylesheet prefech" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.9/semantic.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.10/semantic.js"></script>

<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<style type="text/css">
		#first{
			color:white;
			text-align:center;
			padding:5px;
			line-height:50px;
		}
	</style>
	<style type="text/css">
		#my{
			background-image: url(bb.jpg);
		}
	</style>
</head>
<body id="my">	

	<div id="first">
	<h1>请您登陆</h1>

	<form align="center" action="login" name="form1" method="post" >
  	  <fieldset >
      <legend style="color:white">Welcome!</legend>
      <pre style="font-family:arial;color:white;font-size:20px;">用户名 :  <input type="text" name="username" autofocus ><br /></pre>
      <pre style="font-family:arial;color:white;font-size:20px;">密码     :  <input type="password" name="password" /><br /></pre>
                     
      <div class="ui large buttons">
		<input type="submit" value=" 登录  " class="ui button"> 
		<div class="or" ></div>
		<input type="submit" value=" 注册  " formaction="register" class="ui button"><br />
      </div>
      
      </fieldset>
	</form>
   
	<h3 align="center" style="color:white">
	<s:actionerror />
	${requestScope.msg}
	</h3>
	</div>
   
</body>
</html>
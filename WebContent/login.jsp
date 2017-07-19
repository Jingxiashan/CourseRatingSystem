<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="Shortcut Icon" href="//www.dpfile.com/s/res/favicon.5ff777c11d7833e57e01c9d192b7e427.ico" type="image/x-icon">
		<link rel="stylesheet prefech" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.11/semantic.css">
	    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
	    <script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.11/semantic.js"></script>
		<title>登录-大众点评课</title>
	</head>
	<style type="text/css">
	    body {
	      background-color: #DADADA;
	    }
	    body > .grid {
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
		<s:actionerror/>
		<div class="ui middle aligned center aligned grid">
		  <div class="column">
		    <h2 class="ui teal image header">
		      <img src="images/index.png" class="image">
		      <div class="content">
		        Log-in to your account
		      </div>
		    </h2>
		    <form class="ui large form" action="login" method="post" >
		      <div class="ui stacked segment">
		        <div class="field">
		          <div class="ui left icon input">
		            <i class="user icon"></i>
		            <input type="text" name="username" placeholder="Username">
		          </div>
		        </div>
		        <div class="field">
		          <div class="ui left icon input">
		            <i class="lock icon"></i>
		            <input type="password" name="password" placeholder="Password">
		          </div>
		        </div>
		
		        <button class="ui fluid large teal submit button" type="submit">登录</button>
		     </div>
		    </form>
		
		    <div class="ui message">
		      	第一次访问本网站？ <a href="signup.jsp">注册</a>
		    </div>
		  </div>
		</div>
	</body>
</html>
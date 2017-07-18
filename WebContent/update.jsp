<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet prefech" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.9/semantic.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.10/semantic.js"></script>
<title>Insert title here</title>
</head>
<body>
<form action="book_update" method="post">
<!-- 
	<input type="hidden" name="bookid" value="${requestScope.book.bookid}">
	书名：<input type="text" name="bookname" value="${requestScope.book.bookname}">
	<input type="submit" value="提交"> -->
	
	<div class="ui middle aligned center aligned segment" style="margin-top:2rem">
          <div class="ui left icon input">
            <i class="user icon"></i>
            <input type="hidden" name="bookid" value="${requestScope.book.bookid}">
          </div>
           <div class="ui left icon input">
            <i class="user icon"></i>
            <input type="text" name="bookname" value="${requestScope.book.bookname}">
          </div>
          <button class="ui primary button" type="submit">Save </button>
    </div>
</form>

</body>
</html>
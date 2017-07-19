<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="addcomment" method="post" name="form1" align="center">
  	  <fieldset >
 	     <legend>Welcome!</legend>
      <pre style="font-family:arial;font-size:20px;">courseid                  :  <input type="text" name="course.courseid"><br /></pre>
      <pre style="font-family:arial;font-size:20px;">teacherid                 :  <input type="text" name="teacher.teacherid" /><br /></pre>
      <pre style="font-family:arial;font-size:20px;">userid                    :  <input type="text" name="user.userid" /><br /></pre>
      <pre style="font-family:arial;font-size:20px;">ratingUsefulness         :  <input type="text" name="ratingUsefulness" /><br /></pre>
      <pre style="font-family:arial;font-size:20px;">ratingVividness          :  <input type="text" name="ratingVividness" /><br /></pre>
      <pre style="font-family:arial;font-size:20px;">ratingSpareTimeOccupation:  <input type="text" name="ratingSpareTimeOccupation" /><br /></pre>
      <pre style="font-family:arial;font-size:20px;">ratingScoring            :  <input type="text" name="ratingScoring" /><br /></pre>
      <pre style="font-family:arial;font-size:20px;">ratingRollCall           :  <input type="text" name="ratingRollCall" /><br /></pre>
      <pre style="font-family:arial;font-size:20px;">recommandScore            :  <input type="text" name="recommandScore" /><br /></pre>
      <pre style="font-family:arial;font-size:20px;">critics                   :  <input type="text" name="critics" /><br /></pre>
      <pre style="font-family:arial;font-size:20px;">likeCount                 :  <input type="text" name="likeCount" /><br /></pre>
      <pre style="font-family:arial;font-size:20px;">timestamp                 :  <input type="text" name="timestamp" /><br /></pre>

		<input type="submit" value="提交"> 
		<input type="submit" value="无用" formaction="register"><br />
      
      </fieldset>
	</form>
</body>
</html>
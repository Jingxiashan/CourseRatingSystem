<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
成功！

	<table>
		<tr>
			<td>courseId</td>
			<td>courseName</td>
			<td>commentId</td>
			<td>userId</td>
			<td>ratingUsefulness</td>
			<td>ratingVividness</td>
			<td>ratingSpareTimeOccupation</td>
			<td>ratingScoring</td>
			<td>ratingRollCall</td>
			<td>recommandScore</td>
			<td>critics</td>
			<td>likeCount</td>
			<td>timeStamp</td>
		</tr>
		
		<c:forEach items="${requestScope.commentWithCourseNameList}" var="comment">
			<tr>
				<td>${comment.courseid}</td>
				<td>${comment.coursename}</td>
				<td>${comment.commentid}</td>
				<td>${comment.userid }</td>
				<td>${comment.ratingUsefulness }</td>
				<td>${comment.ratingVividness }</td>
				<td>${comment.ratingSpareTimeOccupation }</td>
				<td>${comment.ratingScoring }</td>
				<td>${comment.ratingRollCall }</td>
				<td>${comment.recommandScore }</td>
				<td>${comment.critics }</td>
				<td>${comment.likeCount }</td>
				<td>${comment.timestamp }</td>
			</tr>
		</c:forEach>
	</table>	
	
teacherid:  ${teacher.teacherid }
teachername:${teacher.teachername }

<table>
	<tr>
		<td>teacherId</td>
		<td>teacherName</td>
	</tr>
	
	<c:forEach items="${requestScope.teacherList }" var="teacher">
		<tr>
			<td>${teacher.teacherid}</td>
			<td>${teacher.teachername}</td>
		</tr>
	</c:forEach>
</table>


</body>
</html>
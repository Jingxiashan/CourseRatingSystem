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
		</tr>
		
		<c:forEach items="${requestScope.commentWithCourseNameList}" var="comment">
			<tr>
				<td>${comment.courseid}</td>
				<td>${comment.coursename}</td>
				<td>${comment.commentid}</td>
			</tr>
		</c:forEach>
	</table>	

</body>
</html>
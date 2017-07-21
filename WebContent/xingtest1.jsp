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
			<td>averageRatingsUsefulness</td>
			<td>averageRatingsVividness</td>
			<td>averageRatingsSpareTimeOccupation</td>
			<td>averageRatingsScoring</td>
			<td>averageRatingsRollCall</td>
			<td>peopleCount</td>
			<td>recommendationScore</td>
			<td>finalType</td>			
		</tr>
		
		<c:forEach items="${requestScope.courseList}" var="course">
			<tr>
				<td>${course.courseid}</td>
				<td>${course.coursename}</td>
				<td>${course.averageRatingsUsefulness}</td>
				<td>${course.averageRatingsVividness}</td>
				<td>${course.averageRatingsSpareTimeOccupation}</td>
				<td>${course.averageRatingsScoring }</td>
				<td>${course.averageRatingsRollCall }</td>
				<td>${course.peopleCount }</td>
				<td>${course.recommendationScore }</td>
				<td>${course.finalType }</td>
			</tr>
		</c:forEach>
	</table>	

</body>
</html>
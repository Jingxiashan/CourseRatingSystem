<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Course Overview</title>
</head>
<body>
	<h1>课程名称：${requestScope.CourseOverviewPlusTeacher.coursename}</h1>
	<table>
		<tr>
			<td>综合推荐度</td>
			<td>有用度</td>
			<td>生动度</td>
			<td>课余时间占用</td>
			<td>给分</td>
			<td>点名频率</td>
		</tr>
		<tr>
			<td>${requestScope.CourseOverviewPlusTeacher.recommendationScore}</td>
			<td>${requestScope.CourseOverviewPlusTeacher.averageRatingsUsefulness}</td>
			<td>${requestScope.CourseOverviewPlusTeacher.averageRatingsVividness}</td>
			<td>${requestScope.CourseOverviewPlusTeacher.averageRatingsSpareTimeOccupation}</td>
			<td>${requestScope.CourseOverviewPlusTeacher.averageRatingsScoring}</td>
			<td>${requestScope.CourseOverviewPlusTeacher.averageRatingsRollCall}</td>
		</tr>
	</table>
	<table>
		<c:forEach items="${requestScope.CourseOverviewPlusTeacher.teacherList}" var="teacher">
			<tr>
				<td><a href="findteacherbyid?teacherid=${teacher.teacherid}">${teacher.teachername}</a></td>
			</tr>
		</c:forEach>
	</table>
	<table>
		<c:forEach items="${requestScope.CourseOverviewPlusTeacher.commentlist}" var="comment">
		<tr><td>
		<p>${requestScope.CourseOverviewPlusTeacher.user.username}</p>
		<p>${requestScope.CourseOverviewPlusTeacher.critics}</p>
		<p>${requestScope.CourseOverviewPlusTeacher.timestamp}</p>
		<a href="dianzan?commentid=${comment.commentid}"></a>
		</td></tr>
		</c:forEach>
	</table>
	
	<a href="pinglun?courseid=${requestScope.CourseOverviewPlusTeacher.courseid}"></a>
</body>
</html>
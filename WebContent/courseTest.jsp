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
<div>
<form action="course_search" method="post">
<input type="text" name="searchtext"><br>
<select name="sortby">
<option value="recommendationScore">recomm</option>
<option value="averageRatingsVividness">vivid</option>
</select><br>
<input type="submit" value="Search">
</form>
<button onclick="window.location.href='course_searchall.action'"></button>
</div>
	<table>
		<tr>
			<td>name</td>
			<td>recommendationScore</td>
			<td>vividness</td>
			<td>teacher</td>
		</tr>
		<c:forEach items="${requestScope.coursepage.list}" var="course">
			<tr>
			<td>${course.coursename}</td>
			<td>${course.recommendationScore}</td>
			<td>${course.averageRatingsVividness}</td>
			<td>${course.teachername}</td>
			</tr>
		</c:forEach>
		 <tr>
			<td>
				每页${requestScope.coursepage.pageSize}条记录 总共${requestScope.coursepage.totalPage}页
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				当前：第${requestScope.coursepage.currentPage} / ${requestScope.coursepage.totalPage}页
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				请选择：第
				<c:forEach begin="1" end="${requestScope.coursepage.totalPage}" step="1" var="i">
					<c:if test="${i==requestScope.coursepage.currentPage}">
						【${i}】
					</c:if>
					<c:if test="${i!=requestScope.coursepage.currentPage}">
						<a href="course_search?currentPage=${i}">${i}</a>
					</c:if>
				</c:forEach>
				页
			</td>
		</tr>
	</table>
</body>
</html>

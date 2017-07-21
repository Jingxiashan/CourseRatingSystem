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
	<form action="comment_findByTeacher" method="post">
		<input type="text" name="teacherid"><br>
		<input type="submit" value="Search">
	</form>
</div>

	<table>
		<tr>
			<td>commentId</td>
			<td>courseId</td>
			<td>teacherId</td>
			<td>userId</td>
			<td>rating_usefulness</td>
			<td>likeCount</td>
			<td>timeStamp</td>
		</tr>
		
		<c:forEach items="${requestScope.commentPage.commentList}" var="comment">
			<tr>
				<td>${comment.commentid}</td>
				<td>${comment.course.courseid}</td>
				<td>${comment.teacher.teacherid}</td>
				<td>${comment.user.userid}</td>
				<td>${comment.ratingUsefulness}</td>
				<td>${comment.likeCount }</td>
				<td>${comment.timestamp }</td>
			</tr>
		</c:forEach>
		
		<tr>
			<td>
				每页${requestScope.commentPage.pageSize}条记录 总共${requestScope.commentPage.totalPage}页
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				当前：第${requestScope.commentPage.currentPage} / ${requestScope.commentPage.totalPage}页
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				请选择：第
				<c:forEach begin="1" end="${requestScope.commentPage.totalPage}" step="1" var="i">
					<c:if test="${i==requestScope.commentPage.currentPage}">
						【${i}】
					</c:if>
					<c:if test="${i!=requestScope.commentPage.currentPage}">
						<a href="comment_findByTeacher?currentPage=${i}&teacherid=${requestScope.teacherid}">${i}</a>
					</c:if>
				</c:forEach>
				页
			</td>
		</tr>
	</table>	

<div>
	<form action="Teacher_findTeacherCourseByID" method="post">
		<input type="text" name="teacherid"><br>
		<input type="submit" value="findTeacherCourseByID">
	</form>
</div>

<div>
	<form action="Teacher_findCommentAndCourseByID" method="post">
		<input type="text" name="teacherid"><br>
		<input type="submit" value="findCommentAndCourseByID">
	</form>
</div>

<div>
	<form action="Teacher_findTeacherByTeacherId" method="post">
		<input type="text" name="teacherid"><br>
		<input type="submit" value="findTeacherByTeacherId">
	</form>
</div>

<div>
	<form action="Teacher_findTeachersByTeachername" method="post">
		<input type="text" name="teachername"><br>
		<input type="submit" value="findTeachersByTeachername">
	</form>
</div>

<div>
	<form action="Teacher_findTeachersByCourseID" method="post">
		<input type="text" name="courseid"><br>
		<input type="submit" value="findTeachersByCourseID">
	</form>
</div>

</body>
</html>
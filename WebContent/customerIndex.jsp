<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Standard Meta -->
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<link rel="stylesheet prefech"
	href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.11/semantic.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.11/semantic.js"></script>
<!-- Site Properties -->
<title>CustumerIndex - CourseRatingSystem</title>

<link rel="stylesheet" type="text/css"
	href="../dist/components/reset.css">
<link rel="stylesheet" type="text/css"
	href="../dist/components/site.css">

<link rel="stylesheet" type="text/css"
	href="../dist/components/container.css">
<link rel="stylesheet" type="text/css"
	href="../dist/components/grid.css">
<link rel="stylesheet" type="text/css"
	href="../dist/components/header.css">
<link rel="stylesheet" type="text/css"
	href="../dist/components/image.css">
<link rel="stylesheet" type="text/css"
	href="../dist/components/menu.css">

<link rel="stylesheet" type="text/css"
	href="../dist/components/divider.css">
<link rel="stylesheet" type="text/css"
	href="../dist/components/list.css">
<link rel="stylesheet" type="text/css"
	href="../dist/components/segment.css">
<link rel="stylesheet" type="text/css"
	href="../dist/components/dropdown.css">
<link rel="stylesheet" type="text/css"
	href="../dist/components/icon.css">

<style type="text/css">
body {
	background-color: #FFFFFF;
}

.ui.menu .item img.logo {
	margin-right: 1.5em;
}

.main.container {
	margin-top: 7em;
}

.wireframe {
	margin-top: 2em;
}

.ui.footer.segment {
	margin: 5em 0em 0em;
	padding: 5em 0em;
}
</style>

</head>
<body>

	<div class="ui fixed inverted menu">
		<div class="ui container">
			<a href="#" class="header item"> <img class="logo"
				src="images/testPic.jpg"> 大众点评课
			</a> <a href="homepage.jsp" class="item">主页</a>
			<div class="ui simple dropdown item">
				Dropdown <i class="dropdown icon"></i>
				<div class="menu">
					<a class="item" href="#">Link Item</a> <a class="item" href="#">Link
						Item</a>
					<div class="divider"></div>
					<div class="header">Header Item</div>
					<div class="item">
						<i class="dropdown icon"></i> Sub Menu
						<div class="menu">
							<a class="item" href="#">Link Item</a> <a class="item" href="#">Link
								Item</a>
						</div>
					</div>
					<a class="item" href="#">Link Item</a>
				</div>
			</div>
		</div>
	</div>

	<div class="ui main text container">
		<h1 class="ui header">课程信息</h1>
		<br>
	</div>

	<div class="ui container">
		<div class="ui middle aligned center aligned segment">
			<div class="ui left icon input">
				<i class="user icon"></i> <input type="text" name="coursename"
					placeholder="课程名称">
			</div>
			<div class="ui left icon input">
				<i class="user icon"></i> <input type="text" name="teachername"
					placeholder="授课教师">
			</div>
			<table
				class="ui middle aligned center aligned compact celled definition table"
				style="margin-top: 2rem">
				<thead class="full-width">
					<tr>
						<th>课程名称</th>
						<th>授课教师</th>
						<th>推荐指数</th>
						<th>老司机评论</th>
						<th>更多信息</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<c:forEach items="${requestScope.bookPage.dataList}" var="book">

							<tr>
								<td>${book.bookid}</td>
								<td>${book.bookname }</td>
								<td>${book.bookprice }

									<div class="ui star rating">
										<i class="icon active"></i>
									</div>

								</td>
								<td>
								balabala
								</td>
								<td>
									<div class="ui labeled button" tabindex="0">
										<div class="ui basic blue button">
											<i class="fork icon"><a
												href="book_delete?bookid=${book.bookid}"></i> 戳
										</div>
										<a class="ui basic left pointing blue label">
											${book.bookid} </a>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tr>
				</tbody>
				<tfoot class="full-width">
					<tr>
						<th></th>
						<th colspan="4">
							<button
								class="ui right floated small primary labeled icon button"
								type="submit">
								<i class="user icon"></i> 造福他人
							</button>
						</th>
					</tr>
				</tfoot>

			</table>
			<tr>
				<td>Each
					page&nbsp;&nbsp;${requestScope.bookPage.pageSize}&nbsp;&nbsp;records&nbsp;&nbsp;Total${requestScope.bookPage.totalPage}pages
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Current
					page:at${requestScope.bookPage.currentPage} &nbsp;&nbsp;/
					&nbsp;&nbsp;${requestScope.bookPage.totalPage}page
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Choose: <c:forEach
						begin="1" end="${requestScope.bookPage.totalPage}" step="1"
						var="i">
						<c:if test="${i==requestScope.bookPage.currentPage}">
						[${i}]
					</c:if>
						<c:if test="${i!=requestScope.bookPage.currentPage}">
							<a href="book_search?currentPage=${i}">${i}</a>
						</c:if>
					</c:forEach> page

				</td>



			</tr>

		</div>
		<!--  </form>-->

	</div>






















	<div class="ui inverted vertical footer segment">
		<div class="ui left aligned container">
			<div class="ui stackable inverted divided grid">
				<div class="three wide column">
					<h4 class="ui inverted header">关于</h4>
					<div class="ui inverted link list">
						<a href="homepage.jsp" class="item">网站介绍</a> <a href="about.jsp"
							class="item">联系我们 </a>
					</div>
				</div>
				<div class="seven wide column">
					<h4 class="ui inverted header">大众点评课</h4>
					<p>只做给你看的选课攻略。</p>
				</div>
			</div>
			<div class="ui inverted section divider"></div>
		</div>
	</div>
</body>
</html>
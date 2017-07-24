<%@page import="com.courseratingsystem.web.vo.CoursePage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>课程列表-大众点评课</title>
<head>
<!-- Standard Meta -->
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<link rel="stylesheet prefech"
	href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.11/semantic.css">
<script	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.11/semantic.js"></script>
<script>

function onSelected(value){
	if(typeof(value) == "undefined"){
		var value = $('#searchDropdown').dropdown('get value');
	}
	if(value == 0){
		document.getElementById("searchIcon");
	}
	$('#searchDropdown').dropdown('set selected',value);
	var searchIcon = document.getElementById("searchIcon");
	var searchInput = document.getElementById("searchInput");
	var searchForm = document.getElementById("searchForm");
	switch(value){
		case "1":
			searchIcon.className="book icon";
			searchInput.placeholder="按课程名称";
			searchForm.action="course_findByName";
		break;
		case "2":
		  searchIcon.className="user icon";
		  searchInput.placeholder="按授课教师";
			searchForm.action="course_findByTeacher";
		break;
	}
}
</script>

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

<body id="body">
	<div class="ui fixed borderless inverted menu">
		<div class="ui container">
			<a href="homepage.jsp" class="header item">
				<img class="logo" src="images/testPic.jpg"> 大众点评课
			</a>
			<a href="course_findAll.action" class="item active">全部课程</a>
			<div class="ui simple dropdown item">
				课程搜索 <i class="dropdown icon"></i>
				<div class="menu">
					<a class="item" href="courseSearchByCname.jsp">按课程名称</a> <a
						class="item" href="courseSearchByTname.jsp">按授课教师</a>
				</div>
			</div>
			<div class="right menu">
				<!-- 如果未登录，显示登录注册 -->
				<c:if test="${empty sessionScope.user}">
					<a href="login.jsp" class="item">登录</a> 
					<a href="register.jsp" class="item">注册</a>
				</c:if>
				<!-- 如果已经登录，显示个人中心链接 -->
				<c:if test="${!empty sessionScope.user}">
					<a href="user.jsp" class="item">${sessionScope.user.nickname}</a>
					<a href="logout.action" class="item">注销</a>
				</c:if>
			</div>
		</div>
	</div>



	<div class="ui main container">
		<div class="ui two column grid" style="min-height:300px">
			<div class="ui four wide column">
				<div class="ui sticky vertical menu" id="verticalMenu" style="position: fixed ! important;">
				
				  <c:if test="${!empty requestScope.searchtype && requestScope.searchtype != 0}">
				  <!-- 如果执行了搜索 -->
					<div class="active teal item">
					    搜索结果：${requestScope.searchtext }
						<div class="ui teal label">${requestScope.coursepage.totalCount }</div>
					</div>
					<a class="item" onClick="javascript :history.back(-1);" >
				   		 返回上一页
				   		 <i class="left arrow icon"></i>
				  	</a>
					<a class="item" href="course_findAll.action">
				   		 全部课程
				   		 <i class="home icon"></i>
				  	</a>
					  <script>
					  	onSelected(${requestScope.searchtype });
					  	document.getElementById("searchInput").value="${requestScope.searchtext }";
					  </script>
				  </c:if>
				  
				  <c:if test="${!empty requestScope.searchtype && requestScope.searchtype == 0}">
				  <!-- 如果显示的是全部课程 -->
					<div class="active teal item" href="course_findAll.action">
				   	 全部课程
				    	<div class="ui teal label">${requestScope.coursepage.totalCount }</div>
				  	</div>
				  </c:if>
				   <div class="ui left pointing dropdown link item">
				    <i class="dropdown icon"></i>
				    排序
				    <div class="menu">
				      <div class="item" onclick="sort('recommendationScore')">推荐得分</div>
				      <div class="item" onclick="sort('averageRatingsUsefulness')">内容有用性</div>
				      <div class="item" onclick="sort('averageRatingsVividness')">课堂生动性</div>
				      <div class="item" onclick="sort('averageRatingsSpareTimeOccupation')">占用时间（少）</div>
				      <div class="item" onclick="sort('averageRatingsScoring')">期末给分</div>
				      <div class="item" onclick="sort('averageRatingsRollCall')">平日点名（少）</div>
				    </div>
				  </div>
				  <div class="item">
				  	<form id="searchForm" action="course_findByName" method="post">
					  	<!-- 搜索框 -->
					  	<div class="ui transparent icon input" style="width:180px">
					  		<!-- 下拉框 -->
					    	<div class="ui icon top left pointing dropdown" id="searchDropdown" onChange="onSelected()" style="margin:auto">
	  							<i class="book icon" id="searchIcon"></i>
	  							<input type="hidden">
								<div class="menu">
									<div class="item" data-value="1">
										<i class="book icon"></i>按课程名称搜索
									</div>
							    	<div class="item" data-value="2">
										<i class="user icon"></i>按授课教师搜索
									</div>
							  	</div>
							</div>
							
					      	<input type="text" name="searchtext" placeholder="按课程名称" id="searchInput" style="margin-left:10px">
					      	<i class="search icon"></i>
					    </div>
				    </form>
				  </div>
				</div>
			</div>
			<c:if test="${!empty requestScope.searchtype && requestScope.searchtype != 0}">
					  <script>
					  	onSelected(${requestScope.searchtype });
					  	document.getElementById("searchInput").value="${requestScope.searchtext }";
					  </script>
				  </c:if>
			<!-- 条目 -->
			<div class="ui twelve wide column">
				<div class="ui divided items">
				<c:forEach items="${requestScope.coursepage.list}" var="course">
					<div class="item">
					<div class="blurring dimmable image" style="width:100px;height:100px">
						<div class="ui inverted dimmer">
							<div class="content">
								<div class="center">
									<button class="ui inverted button" type="button" onclick="window.location.href='course_getPage.action?courseid=${course.courseid}'">“戳”</button>
								</div>
							</div>
						</div>
						<img src="images/elliot.jpg">
					</div>
					 
					    <div class="content">
					      <a class="header" href="course_getPage.action?courseid=${course.courseid }" style="margin-top:10px">${course.coursename }</a>
							<span class="date" style="color: rgba(0, 0, 0, 0.4);font-size: 0.875em;">
								有用${course.averageRatingsUsefulness } 有趣${course.averageRatingsVividness } 占时${course.averageRatingsSpareTimeOccupation } 给分${course.averageRatingsScoring } 点名${course.averageRatingsRollCall }
								</span>
					      <div class="meta">
					        <span class="cinema"><div class="ui mini star rating" data-rating="${course.recommendationScore }" data-max-rating="5" style="margin-top:10px"></div></span>
					      </div>
					      <div class="description">
					        <p></p>
					      </div>
					      <div class="extra">
					      	<div class="ui basic horizontal label" style="margin-top:10px">教师
					      		<c:forEach items="${course.teacherList }" var="teacher"><a class="ui detail" href="teacher_getPage.action?teacherid=${teacher.teacherid}">${teacher.teachername }</a></c:forEach>
					      	</div>
					      	<button class="ui black right floated mini basic button" onclick="window.location.href='comment_getPage.action?courseid=${course.courseid}'" style="margin-right:200px">
							  <i class="comments outline icon"></i>
							  老司机有话要讲
							</button>
					      </div>
					    </div>
					</div>
				</c:forEach>
				</div>
				
				
				<!-- 翻页按钮 -->
				<div class="ui right floated pagination menu">
					<!-- 如果总页数少于六页 -->
					<c:if test="${requestScope.coursepage.totalPage <= 6 }">
						<!-- 如果不是第一页，显示上一页键 -->
						<c:if test="${requestScope.coursepage.currentPage > 1 }">
							<a class="item" onclick="getPage(${requestScope.coursepage.currentPage-1 })">上一页</a>
						</c:if>
						<c:forEach begin="1" end="${requestScope.coursepage.totalPage}" step="1" var="i">
							<c:if test="${i==requestScope.coursepage.currentPage}">
								<a class="disabled item">${i }</a>
							</c:if>
							<c:if test="${i!=requestScope.coursepage.currentPage}">
								<a class="item" onclick="getPage(${i })">${i }</a>
							</c:if>
						</c:forEach>
						<!-- 如果不是最后一页，显示下一页键 -->
						<c:if test="${requestScope.coursepage.currentPage < requestScope.coursepage.totalPage }">
							<a class="item" onclick="getPage(${requestScope.coursepage.currentPage+1  })">下一页</a>
						</c:if>
					</c:if>
					<!-- 如果总页数多于六页 -->
					<c:if test="${requestScope.coursepage.totalPage > 6 }">
						<!-- 如果不是第一页，显示上一页键 -->
						<c:if test="${requestScope.coursepage.currentPage > 1 }">
							<a class="item" onclick="getPage(${requestScope.coursepage.currentPage-1 })">上一页</a>
							<a class="item" onclick="getPage(1)">1</a>
						</c:if>
						<!-- 如果是第一页 -->
						<c:if test="${requestScope.coursepage.currentPage == 1 }">
							<a class="disabled item">1</a>
							<a class="item" onclick="getPage(2)">2</a>
							<a class="item" onclick="getPage(3)">3</a>
							<a class="disabled item">...</a>
						</c:if>
						<!-- 如果是最后一页 -->
						<c:if test="${requestScope.coursepage.currentPage == requestScope.coursepage.totalPage }">
							<a class="disabled item">...</a>
							<a class="item" onclick="getPage(${requestScope.coursepage.totalPage - 2 })">${requestScope.coursepage.totalPage - 2 }</a>
							<a class="item" onclick="getPage(${requestScope.coursepage.totalPage - 1 })">${requestScope.coursepage.totalPage - 1 }</a>
							<a class="disabled item">${requestScope.coursepage.totalPage }</a>
						</c:if>
						<!-- 如果不是第一页也不是最后一页 -->
						<c:if test="${requestScope.coursepage.currentPage != 1 && requestScope.coursepage.currentPage != requestScope.coursepage.totalPage }">
							<c:if test="${requestScope.coursepage.currentPage-1 > 2  }">
								<a class="disabled item">...</a>
							</c:if>
							<c:if test="${requestScope.coursepage.currentPage-1 > 1  }">
								<a class="item" onclick="getPage(${requestScope.coursepage.currentPage - 1 })">${requestScope.coursepage.currentPage - 1 }</a>
							</c:if>
							<a class="disabled item">${requestScope.coursepage.currentPage }</a>
							<c:if test="${requestScope.coursepage.currentPage+1 < requestScope.coursepage.totalPage }">
								<a class="item" onclick="getPage(${requestScope.coursepage.currentPage + 1 })">${requestScope.coursepage.currentPage + 1 }</a>
							</c:if>
							<c:if test="${requestScope.coursepage.currentPage+1 < requestScope.coursepage.totalPage - 1 }">
								<a class="disabled item">...</a>
							</c:if>
						</c:if>
						<!-- 如果不是最后一页，显示下一页键 -->
						<c:if test="${requestScope.coursepage.currentPage < requestScope.coursepage.totalPage }">
							<a class="item" onclick="getPage(${requestScope.coursepage.totalPage })">${requestScope.coursepage.totalPage }</a>
							<a class="item" onclick="getPage(${requestScope.coursepage.currentPage+1  })">下一页</a>
						</c:if>
					</c:if>
				</div>
				
				
			</div>
		
		
		</div>
	</div>


	


	<div class="ui fixed inverted vertical footer segment">
		<div class="ui left aligned container">
			<div class="ui stackable inverted divided grid">
				<div class="three wide column">
					<h4 class="ui inverted header">关于</h4>
					<div class="ui inverted link list">
						<a href="homepage.jsp" class="item">网站介绍</a> 
						<a href="about.jsp" class="item">联系我们 </a>
					</div>
				</div>
				<div class="ten wide column">
					<h4 class="ui inverted header">大众点评课</h4>
					<p>只做给你看的选课攻略。</p>
					<i class="github icon"></i>
					<a href="https://github.com/Jingxiashan/CourseRatingSystem"style="color:#B0B0B0">https://github.com/Jingxiashan/CourseRatingSystem</a>
				</div>
			</div>
			<div class="ui inverted section divider"></div>
		</div>
	</div>
</body>
<script>
$(document).ready(function() {
	$('.ui .rating').rating('disable');
});

$('.image').dimmer({
	on : 'hover'
});
$('.ui .dropdown')
  .dropdown({
	  on:'hover'
  })
;
function sort(sortby){
	switch(${requestScope.searchtype }){
	case 0:
		//全部显示
		var tempform = document.createElement("form");        
		tempform.action = "course_findAll";        
		tempform.method = "post";        
        var opt = document.createElement("textarea");        
        opt.name = "sortby";        
        opt.value = sortby;
        tempform.appendChild(opt);   
    	document.body.appendChild(tempform);  
        tempform.submit();
		break;
	case 1:
		//按课程名称搜索
		var tempform = document.createElement("form");        
		tempform.action = "course_findByName";        
		tempform.method = "post";        
        var opt1 = document.createElement("textarea");        
        opt1.name = "sortby";        
        opt1.value = sortby;
        opt2 = document.createElement("textarea");        
        opt2.name = "searchtext";        
        opt2.value = "${requestScope.searchtext }";
        tempform.appendChild(opt1);   
        tempform.appendChild(opt2);   
    	document.body.appendChild(tempform);  
        tempform.submit();
		break;
	case 2:
		//按老师搜索
		var tempform = document.createElement("form");        
		tempform.action = "course_findByTeacher";        
		tempform.method = "post";        
        var opt1 = document.createElement("textarea");        
        opt1.name = "sortby";        
        opt1.value = sortby;
        opt2 = document.createElement("textarea");        
        opt2.name = "searchtext";        
        opt2.value = "${requestScope.searchtext }";
        tempform.appendChild(opt1);   
        tempform.appendChild(opt2); 
    	document.body.appendChild(tempform);  
        tempform.submit();
		break;
	}
}


function getPage(page){
	var sortby = "${requestScope.sortby }";
	switch(${requestScope.searchtype }){
	case 0:
		//全部显示
		var tempform = document.createElement("form");        
		tempform.action = "course_findAll";        
		tempform.method = "post";        
        var opt1 = document.createElement("textarea");        
        opt1.name = "sortby";        
        opt1.value = sortby;    
        var opt2 = document.createElement("textarea");        
        opt2.name = "currentPage";        
        opt2.value = page;
        tempform.appendChild(opt1); 
        tempform.appendChild(opt2);  
    	document.body.appendChild(tempform);  
        tempform.submit();
		break;
	case 1:
		//按课程名称搜索
		var tempform = document.createElement("form");        
		tempform.action = "course_findByName";        
		tempform.method = "post";        
        var opt1 = document.createElement("textarea");        
        opt1.name = "sortby";        
        opt1.value = sortby;
        opt2 = document.createElement("textarea");        
        opt2.name = "searchtext";        
        opt2.value = "${requestScope.searchtext }";    
        var opt3 = document.createElement("textarea");        
        opt3.name = "currentPage";        
        opt3.value = page;
        tempform.appendChild(opt1);   
        tempform.appendChild(opt2);   
        tempform.appendChild(opt3);   
    	document.body.appendChild(tempform);  
        tempform.submit();
		break;
	case 2:
		//按老师搜索
		var tempform = document.createElement("form");        
		tempform.action = "course_findByTeacher";        
		tempform.method = "post";        
        var opt1 = document.createElement("textarea");        
        opt1.name = "sortby";        
        opt1.value = sortby;
        opt2 = document.createElement("textarea");        
        opt2.name = "searchtext";        
        opt2.value = "${requestScope.searchtext }";
        var opt3 = document.createElement("textarea");        
        opt3.name = "currentPage";        
        opt3.value = page;
        tempform.appendChild(opt1);   
        tempform.appendChild(opt2);   
        tempform.appendChild(opt3); 
    	document.body.appendChild(tempform);  
        tempform.submit();
		break;
	}
}
</script>
</html>

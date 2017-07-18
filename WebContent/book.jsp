<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link rel="stylesheet prefech" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.9/semantic.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.10/semantic.js"></script>
<title>Insert title here</title>
</head>
<body>

<div class="ui container">
<!--  <form action="Bookadd" name="form1" method="post">-->
<div class="ui middle aligned center aligned segment" style="margin-top:2rem">
          <div class="ui left icon input">
            <i class="user icon"></i>
            <input type="text" name="bookname" placeholder="BookName">
          </div>
           <div class="ui left icon input">
            <i class="user icon"></i>
            <input type="text" name="bookprice" placeholder="BookPrice">
          </div>
<table class="ui middle aligned center aligned compact celled definition table" style="margin-top:2rem">
  <thead class="full-width">
    <tr>
      <th>BookID</th>
      <th>BookName</th>
      <th>BookPrice</th>
      <th>BookUpdate</th>
      <th>BookDelete</th>
    </tr>
  </thead>
  <tbody>
    <tr>
       <c:forEach items="${requestScope.bookPage.dataList}" var="book">
            <tr>
            <td>${book.bookid}</td>
            <td>${book.bookname }</td>
            <td>${book.bookprice }</td>
            <td>
            <div class="ui labeled button" tabindex="0">
             <div class="ui red button"><i class="heart icon"></i><a href="book_findById?bookid=${book.bookid}"> Update</a> </div>
             <a class="ui basic red left pointing label">
             ${book.bookid}
            </a>
            </div>
          </td>
          <td>
          <div class="ui labeled button" tabindex="0">
          <div class="ui basic blue button"><i class="fork icon"><a href="book_delete?bookid=${book.bookid}"></i> Delete </div>
          <a class="ui basic left pointing blue label">
           ${book.bookid}
          </a>
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
        <button class="ui right floated small primary labeled icon button" type="submit"><i class="user icon"></i> Add Book </button>
      </th>
    </tr>
  </tfoot>
 
</table>
<tr>
			<td>
				Each page&nbsp;&nbsp;${requestScope.bookPage.pageSize}&nbsp;&nbsp;records&nbsp;&nbsp;Total${requestScope.bookPage.totalPage}pages
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				Current page:at${requestScope.bookPage.currentPage} &nbsp;&nbsp;/ &nbsp;&nbsp;${requestScope.bookPage.totalPage}page
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				Choose:
				<c:forEach begin="1" end="${requestScope.bookPage.totalPage}" step="1" var="i">
					<c:if test="${i==requestScope.bookPage.currentPage}">
						[${i}]
					</c:if>
					<c:if test="${i!=requestScope.bookPage.currentPage}">
						<a href="book_search?currentPage=${i}">${i}</a>
					</c:if>
				</c:forEach>
				page
			
			</td>
		
		
		
		</tr>
 
</div>
<!--  </form>-->

</div>

</body>
</html>
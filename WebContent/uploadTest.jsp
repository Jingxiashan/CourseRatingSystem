<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js">
	</script>
<script type="text/javascript">  
function preImg(sourceId, targetId) {  
    if (typeof FileReader === 'undefined') {  
        alert('Your browser does not support FileReader...');  
        return;  
    }  
    var reader = new FileReader();  
  
    reader.onload = function(e) {  
        var img = document.getElementById(targetId);  
        img.src = this.result;  
    }  
    reader.readAsDataURL(document.getElementById(sourceId).files[0]);  
}  
function upload(){
	$.ajax({
		type:'post',
		url:"${pageContext.request.contextPath}/photoUpload.action",
		data:{"file":imgOne.files,"userid":"1"},
		success:function(){
			alert("success");
		}
	})
}
</script>  
</head>
<body>
       <form action="photoUpload.action"  method="post" enctype="multipart/form-data">
            <label for="upload">上传头像:</label> <input type="file" name="file" id="imgOne" onchange="preImg(this.id,'imgPre')"> 
            <img id="imgPre" src="" style="display: block;" /> 
            <input type="text" name="userid"> 
            <br> <br> <button onclick="upload();">上传</button>
      </form>
        <img src="/CourseRatingSystem/userphoto/1.jpg"/>
</body>
</html>
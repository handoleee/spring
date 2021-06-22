<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
		function mypage() {
			
		}
	</script>
</head>
<body>
	<h2>마이페이지(mypage.jsp)</h2>
	<button onclick="location='memberupdate.jsp'">정보수정</button>
	<a href="likelist?=${loginMember}">찜한 목록</a>
	
	
	
</body>
</html>
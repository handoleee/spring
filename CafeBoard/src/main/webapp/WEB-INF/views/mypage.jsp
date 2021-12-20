<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- <script>
		function memberUpdate() {
			location.href='memberupdate?mid='${sessionScope.loginMember};
		} 
		function likeList() {
			location.href="likelist"?${loginMember};
		}
	</script> -->
</head>
<body>
	<h2>마이페이지(mypage.jsp)</h2>
	
	<a href="memberupdate?mid=${sessionScope.loginMember}">정보수정</a>
	<a href="likelist?lid=${sessionScope.loginMember}">찜목록</a>
	
	<!-- <button onclick="memberUpdate()">정보수정</button>
	<button onclick="likeList()">찜목록</button> -->
	
	<!-- <form action="likelist" method="get"> 
	<input type="submit" value="찜목록">
	</form> -->
	
	<!-- <button onclick="likeList()">찜목록</button> -->
	
	
	
</body>
</html>
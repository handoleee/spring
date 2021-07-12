<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
		function memberUpdate() {
			location.href="memberupdate";
		} 
		/* function likeList() {
			location.href="likelist"?${loginMember};
		} */
	</script>
</head>
<body>
	<h2>마이페이지(mypage.jsp)</h2>
	<button onclick="memberUpdate()">정보수정</button>
	<form action="likelist" method="get"> 
	<input type="submit" value="찜목록">
	</form>
	<!-- <button onclick="likeList()">찜목록</button> -->
	
	
	
</body>
</html>
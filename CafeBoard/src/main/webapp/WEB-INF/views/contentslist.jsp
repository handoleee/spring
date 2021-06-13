<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
		function logout() {
			location.href="./";
		}
		function mypage() {
			if(${sessionScope.loginMember} != null){
			location.href="mypage";}
		}
	</script>
</head>
<body>
	<h2>메뉴contentslist</h2>
	if(${sessionScope.loginMember}!=null) {}
	로그인 아이디 : ${sessionScope.loginMember}<br>
	<button onclick="logout()">로그아웃</button>
	<a href="mypage">마이페이지</a>
	<!-- 체크박스 넣기 -->
	<form action="">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		h2{
			color:#db7093;}
	</style>
</head>
<body>
	<h2>로그인</h2>

	<form action="memberlogin" method="post">
		아이디 : <input type="text" name="mid"><br>
		비밀번호 : <input type="text" name="mpassword"><br>
		<input type="submit" value="로그인">
	</form>
</body>
</html>
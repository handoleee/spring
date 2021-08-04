<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>로그인페이지</title>
	<link rel="stylesheet" href="resources/css/style.css" type="text/css">
</head>
<body>
	<div style="width: 1400px; left: 50%; margin-left: 700px;">
	<h2>memberlogin.jsp</h2><br>
	<form action="memberlogin" method="post">
		아이디 : <input type="text" name="mid"><br>
		비밀번호 : <input type="text" name="mpassword"><br>
		<input type="submit" value="로그인">
	</form>
	</div>
</body>
</html>
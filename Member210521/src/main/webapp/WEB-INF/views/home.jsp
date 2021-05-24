<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="joinpage">회원가입</a>
<a href="loginpage">로그인</a>
<!-- 아래 링크는 DB에서 정보를 가져와서 memberlist.jsp에 출력하기 위한 링크 -->
<a href="memberlist">회원목록</a>
</body>
</html>

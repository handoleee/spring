<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>welcome.jsp</h2>
<!-- welcomemsg 라는 주소로 msg라는 파라미터에 데이터를 담아서 전송 -->
<!-- form태그 전송방식 : get, post -->
<form action="welcomemsg" method="get">
입력메시지 : <input type="text" name="msg"><br>
입력메시지2 : <input type="text" name="msg2"><br>
<input type="submit" value="전송">
</form>

<!-- 링크를 통해 파라미터 전송하기 -->
<a href="linkmsg?val1=데이터1&val2=데이터2">링크로데이터전송</a>
</body>
</html>
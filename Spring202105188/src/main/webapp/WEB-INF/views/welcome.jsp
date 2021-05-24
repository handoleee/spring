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
<!-- 첫번쨰 welcomemsg -->
<!-- <form action="welcomemsg">
입력메시지 : <input type="text" name="msg" placeholder="입력하세요"><br>
<input type="submit" value="전송">
</form> -->
<form action="welcomemsg">
입력메시지1 : <input type="text" name="msg" placeholder="입력메시지1"><br>
입력메시지2 : <input type="text" name="msg2" placeholder="입력메시지2"><br>
<input type="submit" value="전송"> 

<a href="linkmsg?val1&val2">링크로 데이터 전송</a>
</form>
</body>
</html>
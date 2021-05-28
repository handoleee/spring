<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>boardwrite.jsp</h2>
	<form action="boardwrite" method="post">
		글제목 : <input type="text" name="btitle"><br>
		글비번 : <input type="text" name="bpassword"><br>
		작성자 : <input type="text" name="bwriter"><br>
		내용 : <textarea name="bcontents" rows="5"></textarea><br>
		<input type="submit" value="작성">
		<a href="./">홈으로</a>
	</form>
</body>
</html>
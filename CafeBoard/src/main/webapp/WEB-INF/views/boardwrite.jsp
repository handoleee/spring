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
<h2>게시판 글쓰기</h2>
	<form action="boardwrite" method="post" enctype="multipart/form-data">
		작성자 : <input type="text" name="bwriter" placeholder="" value="${sessionScope.loginMember}" readonly><br>
		제목 : <input type="text" name="btitle"><br>
		내용 : <textarea name="bcontents" rows="5"></textarea><br> 
		파일 : <input type="file" name="bpic"><br>
		<input type="submit" value="작성">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>boardview.jsp</h2>
	글번호 : ${boardView.bnumber}<br>
	글제목 : ${boardView.btitle}<br>
	비밀번호 : ${boardView.bpassword}<br>
	작성자 : ${boardView.bwriter}<br>
	내용 : ${boardView.bcontetns}<br>
	작성일자 : ${boardView.bdate}<br>
	조회수 : ${boardView.bhits}<br>
	<a href="boardlist">목록</a>


<a href="boardupdate?bnumber=${board.bnumber}">수정</a>
<!--  -->
</body>
</html>
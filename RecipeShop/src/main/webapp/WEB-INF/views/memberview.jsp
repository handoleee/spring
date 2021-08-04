<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>memberview.jsp</h2>
	아이디 : ${member.mid}<br>
	이름 : ${member.mname}<br>
	전화번호 : ${member.mphone}<br>
	주소 : ${member.maddr1} ${member.maddr2} ${member.maddr3}<br>
	이메일 : ${member.memail}<br>
	포인트 : ${member.mpoint}<br>
	<a href="adminpage">이전화면으로</a>
</body>
</html>
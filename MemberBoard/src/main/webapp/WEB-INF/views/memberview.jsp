<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원정보 조회</h2>
	아이디 : ${memberView.mid}<br>
	비밀번호 : ${memberView.mpassword}<br>
	이름 : ${memberView.mname}<br>
	전화번호 : ${memberView.mphone}<br>
	이메일 : ${memberView.memail}<br>
	이미지: <img src="resources/profile/${member.mprofilename}" height="200" width="200"> <br>
	
	<a href="./">홈으로</a>
	<a href="memberlist">회원목록</a>
	
</body>
</html>
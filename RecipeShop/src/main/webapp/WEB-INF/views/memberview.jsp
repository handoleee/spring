<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/style.css" type="text/css">
</head>
<body>
	<h2 style="color: #7fad39"><b>회원조회</b></h2>
		<nav class="header__menu">
        	<ul>
				<li><a href="./">홈</a></li>
				<li class="active"><a href="memberlist">회원목록/포인트지급</a></li>
				<li><a href="addshoppage">쇼핑몰 상품등록</a></li>
	 			<li><a href="reportlist">신고내역</a></li>
 			</ul>
		</nav>
	아이디 : ${member.mid}<br>
	이름 : ${member.mname}<br>
	전화번호 : ${member.mphone}<br>
	주소 : ${member.maddr1} ${member.maddr2} ${member.maddr3}<br>
	이메일 : ${member.memail}<br>
	포인트 : ${member.mpoint}<br>
</body>
</html>
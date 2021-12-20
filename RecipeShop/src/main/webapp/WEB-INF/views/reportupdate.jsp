<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신고 답변</title>
<link rel="stylesheet" href="resources/css/style.css" type="text/css">
</head>
<body>
	<h2 style="color: #7fad39"><b>신고 답변</b></h2>
		<nav class="header__menu">
        	<ul>
				<li><a href="./">홈</a></li>
				<li><a href="memberlist">회원목록/포인트지급</a></li>
				<li><a href="addshoppage">쇼핑몰 상품등록</a></li>
	 			<li class="active"><a href="reportlist">신고내역</a></li>
 			</ul>
		</nav>
	<form action="reportupdateprocess" method="post">
		
		신고번호 : <input type="text" name="rpnumber" value="${reportupdate.rpnumber}" readonly><br>
		레시피번호 : <input type="text" name="rprnumber" value="${reportupdate.rprnumber}" readonly><br>
		신고자 : <input type="text" name="rpname" value="${reportupdate.rpname}" readonly><br>
		신고내용 : <input type="text" name="rpcontents" value="${reportupdate.rpcontents}" readonly><br>
		<input type="hidden" name="rpcheck" value="y">
		신고답변내용 : <input type="text" name="rpanswer" value="${reportupdate.rpanswer}"><br>
		<input type="submit" value="답변완료">
	</form>
</body>
</html>
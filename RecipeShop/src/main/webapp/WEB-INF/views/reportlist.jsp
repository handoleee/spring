<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/style.css" type="text/css">
</head>
<body>
	<h2 style="color: #7fad39"><b>신고내역</b></h2>
	<nav class="header__menu">
        <ul>
			<li><a href="./">홈</a></li>
			<li><a href="memberlist">회원목록/포인트지급</a></li>
			<li><a href="addshoppage">쇼핑몰 상품등록</a></li>
	 		<li class="active"><a href="reportlist">신고내역</a></li>
 		</ul>
	</nav>
	<div id="container__list">
		<table>
			<tr>
				<th>신고번호</th>
				<th>레시피번호</th>
				<th>신고자</th>
				<th>신고 내용</th>
				<th>답변 여부</th>
				<th>답변 내용</th>
			</tr>
		<c:forEach var="total" items="${totalreport}">
			<tr>
				<td>${total.rpnumber}</td>
				<td>${total.rprnumber}</td>
				<td>${total.rpname}</td>
				<td>${total.rpcontents}</td>
				<td>${total.rpcheck}</td>
				<td>${total.rpanswer}</td>
				<td><a href="reportview?rpnumber=${total.rpnumber}">조회</a></td>
			</tr>
		</c:forEach>
		</table>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
	table, tr,th, td{
		border: solid black 1px;
		border-collapse: collapse;
		}
	h2{
		color:#db7093;}
</style>
</head>

<body>
	<h2>회원목록</h2>
	<button onclick="location='contentslist'">메뉴목록</button>
	<table>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>휴대폰번호</th>
		</tr>
		<c:forEach var="member" items="${memberList}">
		<tr>
			<td>${member.mid}</td>
			<td>${member.mname}</td>
			<td>${member.mphone}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
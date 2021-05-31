<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, tr, th, td {
border : solid black 1px;
border-collapse: collapse;
}
</style>
</head>
<body>
<h2>boardlist.jsp</h2>
	<table>
		<tr>
			<th>글번호</th>
			<th><a href="boardview">글제목</a></th>
			<th>비밀번호</th>
			<th>작성자</th>
			<th>내용</th>
			<th>작성일자</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="board" items="${boardList}">
		<tr>
			<td>${board.bnumber}</td>
			<td>${board.btitle}</td>
			<td>${board.bpassword}</td>
			<td>${board.bwriter}</td>
			<td>${board.bcontents}</td>
			<td>${board.bdate}</td>
			<td>${board.bhits}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
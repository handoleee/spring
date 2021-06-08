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
<h2>내가 쓴 글 목록</h2>
	<table>
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>내용</th>
			<th>파일</th>
			<th>조회수</th>
			<th>작성일자</th>
		</tr>
		
		<c:forEach var="myboardlist" items="${myboardList}">
		<th>여기출력</th>
		<tr>			
		
			<td>${myboardList.bnumber}</td>
			<td>${myboardList.bwriter}</td>
			<td><a href="boardview?bnumber=${myboardList.bnumber}">${myboardList.btitle}</a></td>
			<td>${myboardList.bcontents}</td>
			<td>${myboardList.bfile}</td>
			<td>${myboardList.bhits}</td>
			<td>${myboardList.bdate}</td>
		</tr>
		<td>tr안쪽</td>
		</c:forEach>
	</table>
</body>
</html>
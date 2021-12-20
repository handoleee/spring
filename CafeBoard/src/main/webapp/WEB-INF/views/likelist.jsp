<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<h2>즐겨찾는 메뉴</h2>
	
	 <table>		
		<tr>
			<!-- <th>브랜드</th>
			<th>등록번호</th>
			<th>메뉴이름</th>
			<th>가격</th>
			<th>용량</th> -->
			<th>브랜드</th>
			<th>메뉴</th>
			<th>가격</th>
			<th>용량</th>
		</tr>
		
		<c:forEach var="likelist" items="${likelist}" varStatus="i">
			<tr>
				<td>${likelist.cbrand}</td>
				<td>${likelist.cname}</td>
				<td>${likelist.cprice}</td>
				<td>${likelist.csize}</td>
				<%-- <td><a href="menuview?cnumber=${likelist.cnumber}">${likelist.cnumber}</a></td>
				<td>${likelist.name}</td>
				<td>${likelist.cprice}</td>
				<td>${likelist.csize}</td> --%>
			</tr>
		</c:forEach>
		</table> 
	
</body>
</html>
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
	<h2>reportlist.jsp(신고내역)</h2>
		<table>
			<tr>
				<th>신고번호</th>
				<th>레시피번호</th>
				<th>신고자</th>
				<th>신고 내용</th>
				<th>신고 답변 여부</th>
				<th>신고 답변 내용</th>
			</tr>
		<c:forEach var="total" items="${totalreport}">
			<tr>
				<td>${total.rpnumber}</td>
				<td>${total.rprnumber}</td>
				<td>${total.rpname}</td>
				<td>${total.rpcontents}</td>
				<td>${total.rpcheck}</td>
				<td>${total.rpanswer}</td>
				<td><a href="reportlist?rpnumber=${total.rpnumber}">조회</a></td>
				<td><button onclick="totalviewAjax('${member.mid}')">조회(ajax)</button></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
	function update() {
		location.href="memberupdate";
	}
	</script>
</head>
<body>
	<h2>게시판</h2>
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
		<c:forEach var="board" items="${boardList}">
		<tr>
			<td>${board.bnumber}</td>
			<td>${board.bwriter}</td>
			<td><a href="boardview?bnumber=${board.bnumber}">${board.btitle}</a></td>
			<td>${board.bcontents}</td>
			<td>${board.bfile}</td>
			<td>${board.bhits}</td>
			<td>${board.bdate}</td>
		</tr>
		</c:forEach>
	</table>
	<a href="writepage">글쓰기</a>
	<button onclick="update()">회원정보수정</button>
</body>
</html>
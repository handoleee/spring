<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
	function logout() {
		location.href="./";
	}
	
	function mypage() {
		location.href="mypage";
	}
	</script>
</head>
<body>
	<h2>게시판</h2>
	로그인 아이디 : ${sessionScope.loginMember}<br>
	<button onclick="logout()">로그아웃</button>
	<a href="mypage">마이페이지</a><br>
	
	<a href="paging?page=${page}">페이징목록으로 가기</a><br>
	
	<a href="writepage">글쓰기</a>
	
	<c:if test="${sessionScope.loginMember eq 'admin'}"><br>
		<a href="memberlist">회원목록</a>
	</c:if>
	
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
</body>
</html>
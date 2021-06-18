<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
		function boardupdate() {
			location.href='boardupdate?bnumber='+${board.bnumber};
			}
		
		function boardDelete() {
			location.href='boarddelete?bnumber='+${board.bnumber};
			if(confirm("삭제하시겠습니까?") == true){
				alert('삭제되었습니다.');
			}
		}
	</script>
</head>
<body>
<h2>글조회(boardview.jsp)</h2>

	글번호 : ${board.bnumber}<br>
	작성자 : ${board.bwriter}<br>
	제목 : ${board.btitle}<br>
	내용 : ${board.bcontents}<br>
	조회수 : ${board.bhits}<br>
	작성일자 : ${board.bdate}<br>
	첨부사진 : <img src="resources/boardpicture/${board.bpicname}" height="200" width="200">
	
	<c:set var="bwriter" value="${board.bwriter}" />
		<c:choose>
		<c:when test="${sessionScope.loginMember eq ('admin')}">
		<button onclick="boardupdate()">수정</button>
		<button onclick="boardDelete()">삭제</button>
		</c:when>
		<c:when test="${sessionScope.loginMember eq bwriter}">
		<button onclick="boardupdate()">수정</button>
		<button onclick="boardDelete()">삭제</button>
		</c:when>
		</c:choose>
</body>
</html>
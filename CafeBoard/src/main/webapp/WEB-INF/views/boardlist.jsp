<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		table,tr,th,td {
			border: 1px solid black;
			border-collapse: collapse;
		}
	</style>
<script>
	function boardWrite(){
		
	}
</script>
</head>
<body>
	<h2>게시판(boardlist.jsp)</h2>

	<a href="writepage">글작성</a>
	<a href="contentslist">메뉴 조회</a>
	<form action="boardsearch" method="get">
		<select name="searchtype">
			<option value="btitle">제목</option>
			<option value="bwriter">작성자</option>
			<option value="bcontents">내용</option>
		</select>
		<input type="text" name="keyword" placeholder="검색어입력">
		<input type="submit" value="검색">
	</form>
	<table>
	
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>내용</th>
			<th>조회수</th>
			<th>작성일자</th>
			<th>파일</th>
		</tr>
		<c:forEach var="board" items="${board}">	
		<tr>
				
			<td>${board.bnumber}</td>
			<td>${board.bwriter}</td>
			<td><a href="boardview?bnumber=${board.bnumber}&page=${paging.page}">${board.btitle}</a></td>
			<td>${board.bcontents}</td>
			<td>${board.bhits}</td>
			<td>${board.bdate}</td>
			<td>${board.bpic}</td>
		</tr>
		</c:forEach>
	</table>
	<c:choose>
		<c:when test="${paging.page<=1}">
			[이전]&nbsp;
		</c:when>
		<c:otherwise>
			<a href="boardlist?page=${paging.page-1}">[이전]</a>&nbsp;
		</c:otherwise>
	</c:choose>
	
	<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i" step="1">
		<c:choose>
			<c:when test="${i eq paging.page}">
				${i}
			</c:when>
			<c:otherwise>
				<a href="boardlist?page=${i}">${i}</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>

	<c:choose>
		<c:when test="${paging.page>=paging.maxPage}">
			[다음]
		</c:when>
		<c:otherwise>
			<a href="boardlist?page=${paging.page+1}">[다음]</a>
		</c:otherwise>
	</c:choose>
</body>
</html>
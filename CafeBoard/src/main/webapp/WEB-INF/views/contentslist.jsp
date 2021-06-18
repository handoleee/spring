<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
/* $("input[name=cbrand]:checked").each(function() {
	var test = $(this).val();
} */
/* function selectbrand(){
	const query = 'input[name="cbrand"]:checked';

} */
/* $('input:checkbox[name="checkbox"]').is(":checked") == true
$('input[name="checkbox"]').is(":checked") */

/* $("input[name=cbrand]:checked").each(function() {
	var test = $(this).val();
	console.log("벨류값 : "+test);
} */

</script>
<style>
table{
	text-align: center;
}
</style>
</head>
<body>
	<h2>메뉴 contentslist</h2>
	로그인 아이디 : ${sessionScope.loginMember}
	<br>
	<c:if test="${not empty sessionScope.loginMember}">
		<a href="logout">로그아웃</a>
	<!-- <button onclick="logout()">로그아웃</button> -->
		<a href="mypage">마이페이지</a>
		<a href="boardlist">게시판</a>
	</c:if>
	<c:if test="${sessionScope.loginMember eq ('admin')}">
		<a href="adminmenupage">메뉴 추가, 삭제</a>
		<a href="memberlist">회원조회</a><br>
		
	</c:if>
	
	<c:if test="${empty sessionScope.loginMember}">
		<a href="./">홈으로</a><br>
	</c:if>
	
	<form action="menusearch" method="get">
		<select name="searchtype">
			<option value="cbrand">브랜드</option>
			<option value="cname">메뉴 이름</option>
		</select>
		<input type="text" name="keyword" placeholder="검색어입력">
		<input type="submit" value="검색">
	</form>
	
		<!-- <form name="checkboxform" id="selectbrand">
		<input type="checkbox" name="cbrand" value="starbucks">스타벅스
		<input type="checkbox" name="cbrand" value="coffeebean">커피빈
		<input type="checkbox" name="cbrand" value="hollys">할리스
		<input type="checkbox" name="cbrand" value="paik">빽다방
		<input type="checkbox" name="cbrand" value="mega">메가커피
		</form>
		<br> -->
		
	메뉴 사진<br>
	<c:forEach items="${contents}" var="i">
	
	<a href="menuview?cnumber=${i.cnumber}"><img src="resources/menupicture/${i.cpicname}" height="150" width="150"></a><br>
	</c:forEach>
		<table>
		<c:forEach var="contents" items="${contentsList}">
		
		<tr>
			<th>브랜드</th>
			<th>등록번호</th>
			<th>메뉴이름</th>
			<th>가격</th>
			<th>용량</th>
		</tr>
		<tr>
			<td>${contents.cbrand}</td>
			<td><a href="menuview?cnumber=${contents.cnumber}&page=${paging.page}">${contents.cnumber}</a></td>
			<td>${contents.cname}</td>
			<td>${contents.cprice}</td>
			<td>${contents.csize}</td>
		</tr>
		</c:forEach>
		</table>
	
	 <c:choose>
		<c:when test="${paging.page<=1}">
			[이전]&nbsp;
		</c:when>
		<c:otherwise>
			<a href="contentspaging?page=${paging.page-1}">[이전]</a>&nbsp;
		</c:otherwise>
	</c:choose>
	
	<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i" step="1">
		<c:choose>
			<c:when test="${i eq paging.page}">
				${i}
			</c:when>
			<c:otherwise>
				<a href="contentspaging?page=${i}">${i}</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>

	<c:choose>
		<c:when test="${paging.page>=paging.maxPage}">
			[다음]
		</c:when>
		<c:otherwise>
			<a href="contentspaging?page=${paging.page+1}">[다음]</a>
		</c:otherwise>
	</c:choose>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<style>
		table {
			text-align: center;
		}
		
		h2{
		color:#db7093;}
	</style>
</head>
<body>
	<h2>메뉴목록</h2>
	로그인 아이디 : ${sessionScope.loginMember}
	<br>
	<c:if test="${not empty sessionScope.loginMember}">
		<a href="logout">로그아웃</a>
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
	<%-- <form action="brandlist" method="get">
		<ul>
		<li><input type="checkbox" name="brand" value="1" onclick="change_cate()"><label for="스타벅스">스타벅스</label></li>
		<li><input type="checkbox" name="brand" value="2" onclick="change_cate()"><label for="커피빈">커피빈</label></li>
		<li><input type="checkbox" name="brand" value="3" onclick="change_cate()"><label for="할리스">할리스</label></li>
		<li><input type="checkbox" name="brand" value="4" onclick="change_cate()"><label for="빽다방">빽다방</label></li>
		<li><input type="checkbox" name="brand" value="5" onclick="change_cate()"><label for="메가커피">메가커피</label></li>
	</ul>
	</form> --%>
	
	<form action="menusearch" method="get">
		<select name="searchtype">
			<option value="cbrand">브랜드</option>
			<option value="cname">메뉴 이름</option>
		</select>
		<input type="text" name="keyword" placeholder="검색어입력">
		<input type="submit" value="검색">
	</form>
	
	메뉴 사진<br>
	<c:forEach items="${contents}" var="i">
	
	<a href="menuview?cnumber=${i.cnumber}"><img src="resources/menupicture/${i.cpicname}" height="150" width="150"></a><br>
	</c:forEach>
	
		<table>		
		<tr>
			<th>브랜드</th>
			<th>등록번호</th>
			<th>메뉴이름</th>
			<th>가격</th>
			<th>용량</th>
		</tr>
		
		<c:forEach var="contents" items="${contents}">
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
			<a href="contentslist?page=${paging.page-1}">[이전]</a>&nbsp;
		</c:otherwise>
	</c:choose>
	
	<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i" step="1">
		<c:choose>
			<c:when test="${i eq paging.page}">
				${i}
			</c:when>
			<c:otherwise>
				<a href="contentslist?page=${i}">${i}</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>

	<c:choose>
		<c:when test="${paging.page>=paging.maxPage}">
			[다음]
		</c:when>
		<c:otherwise>
			<a href="contentslist?page=${paging.page+1}">[다음]</a>
		</c:otherwise>
	</c:choose>
	
	<script>
	/* function search_keyword(){
		var key = $("#brand").val();
		var chked_val = "";
		$(":checkbox[name = 'brand']:checked").each(function(pi,po){
			if( po.value == "all" || chked_val == "all"){
				chked_val = "all";
			} else{
				chked_val += po.value + ",";
			console.log("함수 search_keyword")}
		})}; */
	
	/* function change_cate(){
		var skeyword = $("#skeyword").val();
		var chked_val = "";
		var brandname = document.getElementsByName('brand');
		$(":checkbox[name = 'brand']:checked").each(function(pi,po){
			if( po.value == "all" || chked_val == "all"){
				chked_val = "all";
			} else{
				chked_val += po.value + ",";
			}
			console.log("함수 change_cate");
			console.log(chked_val);
		
		}); 
		 location.replace("/brandlist?chked_val="+chked_val+"&skeyword="+skeyword+"${brandname}"); 
		} */
		
	</script>
</body>
</html>
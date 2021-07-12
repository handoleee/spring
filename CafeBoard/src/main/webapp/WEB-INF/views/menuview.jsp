<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
		function menuUpdate() {
			location.href='menuupdate?cnumber='+${contents.cnumber};
			}
	
		function menuDelete() {
			location.href='menudelete?cnumber='+${contents.cnumber};
			if(confirm("삭제하시겠습니까?") == true){
				alert('삭제되었습니다.');
			}
		}
			
		function addLikeList() {
			location.href='addlikelist?cnumber='+${contents.cnumber}+'&loginId='+${loginMember};
			if(confirm("즐겨찾는 메뉴에 추가하시겠습니까?") == true){
				alert('추가되었습니다.');
			}
			
		}
	</script>
	<style>
		h2{
		color:#db7093;}
	</style>
</head>
<body>
	<h2>메뉴 상세조회</h2>

		브랜드 이름 : ${contents.cbrand}<br>
		메뉴 번호 : ${contents.cnumber}<br>
		메뉴 이름 : ${contents.cname}<br>
		가격 : ${contents.cprice}<br>
		용량 : ${contents.csize}<br>
		알레르기 : ${contents.call}<br>
		메뉴설명 : ${contents.cscri}<br>
		사진 : <img src="resources/menupicture/${contents.cpicname}" height="150" width="150"><br>
		<a href="contentslist">목록</a>
		<c:if test="${sessionScope.loginMember != null}">
		<form name="addlikelist" method="post" action=addlikelist>
			<input type="hidden" name="likenumber" value="${likelist.lbrandnum}">
			<input type="submit" value="찜목록">
		</form>
		</c:if>
		<c:if test="${sessionScope.loginMember eq ('admin')}">
			<button onclick="menuUpdate()">수정</button>
			<button onclick="menuDelete()">삭제</button>
		</c:if>
</body>
</html>
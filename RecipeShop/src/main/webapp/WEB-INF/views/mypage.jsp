<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script>
		function memberDelete(id) {
			location.href='memberdelete?mid='+id;
			if(confirm("탈퇴하시겠습니까?") == true){
				alert('탈퇴되었습니다.');
				location.href="./"
			}
			else{
				location.href='./mypage';
			}
		}
		$(function() {
			$("#update_get").click(function() {
			$("#update").load("./memberupdate");
			});
		});
		$(function() {
			$("#myreport_get").click(function() {
			$("#myreport").load("./reportlist");
			});
		});
	
	</script>
	<link rel="stylesheet" href="resources/css/style.css" type="text/css">
</head>
<body>
	<h2>mypage.jsp(마이페이지)</h2>
	<nav class="header__menu">
        	<ul>
				<li class="active"><a href="./">홈</a></li>
				<li><a id="myrecipelist">내 레시피</a></li>
				<li><a id="mybuyrecipe">구매한 레시피</a></li>
	 			<li><a id="update_get">회원정보수정</a></li>
 				<li><a id="myreport_get">신고내역</a></li>
 				<li><a onclick="memberDelete('${sessionScope.loginMember}')">회원탈퇴</a></li>
	      	<!-- <ul class="header__menu__dropdown">
	      <li><a href="memberlist">회원목록</a></li>
	   <li><a href="memberview">회원상세조회</a></li>
	   <li><a href="reportlist">회원신고내역</a></li> -->
	     </ul>                       
		</nav>
	<ul>
		<li><a href="myrecipelist">내 레시피</a></li>
		<li><a href="mybuyrecipe">구매한 레시피</a></li>
		<li><a href="memberupdate">회원정보수정</a></li>
		<li><a href="myreport">신고내역</a></li>
		<li><a onclick="memberDelete('${sessionScope.loginMember}')">회원탈퇴</a></li>
	</ul>
	<div id="update"></div>
</body>
</html>
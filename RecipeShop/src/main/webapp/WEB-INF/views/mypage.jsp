<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script>
		function memberDelete(id) {
			if(confirm("탈퇴하시겠습니까?") == true){
				alert('탈퇴되었습니다.');
				location.href='memberdelete?mid='+id;
			}
			else{
				location.href='mypage';
			}
		}
	</script>
	<link rel="stylesheet" href="resources/css/style.css" type="text/css">
</head>
<body>
	<h2 style="color: #7fad39"><b>마이페이지</b></h2>
	<nav class="header__menu" style="cursor:pointer">
        <ul>
			<li class="active"><a href="./">홈</a></li>
			<li><a href="myrecipelist?rname=${sessionScope.loginMember}">내 레시피</a></li>
			<!-- <li><a href="buyrecipe">구매한 레시피</a></li> -->
	 		<li><a href="memberupdate">회원정보수정</a></li>
 			<li><a href="myreport?rpname=${sessionScope.loginMember}">내 신고내역</a></li>
 			<li><a onclick="memberDelete('${sessionScope.loginMember}')">회원탈퇴</a></li>	
	    </ul>                       
		</nav>
</body>
</html>
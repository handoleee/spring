<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 신고내역</title>
<link rel="stylesheet" href="resources/css/style.css" type="text/css">
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
	<style>
		table, th, tr, td {
			border: solid black 1px;
			border-collapse: collapse;
		}
	</style>
</head>
<body>
	<h2 style="color: #7fad39"><b>내 신고내역</b></h2>
		<nav class="header__menu" style="cursor:pointer">
	        <ul>
				<li><a href="./">홈</a></li>
				<li><a href="myrecipelist?rname=${sessionScope.loginMember}">내 레시피</a></li>
				<!-- <li><a href="mybuyrecipe">구매한 레시피</a></li> -->
		 		<li><a href="memberupdate">회원정보수정</a></li>
	 			<li class="active"><a href="myreport?rpname=${sessionScope.loginMember}">내 신고내역</a></li>
	 			<li><a onclick="memberDelete('${sessionScope.loginMember}')">회원탈퇴</a></li>
		     </ul>                       
		</nav>
	
	<table>
			<tr>
				<th>글번호</th>
				<th>레시피번호</th>
				<th>신고내용</th>
				<th>확인여부</th>
				<th>답변내용</th>
			</tr>
			
		<c:forEach items="${myreport}" var="myr">
		
			<tr>
				<td><a href="reportview?rpnumber=${myr.rpnumber}">${myr.rpnumber}</a></td>
				<td>${myr.rprnumber}</td>
				<td>${myr.rpcontents}</td>
				<td>${myr.rpcheck}</td>
				<td>${myr.rpanswer}</td>
				
			
			</tr>
	
		</c:forEach>
	</table>
</body>
</html>
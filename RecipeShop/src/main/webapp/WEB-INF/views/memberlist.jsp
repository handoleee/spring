<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<link rel="stylesheet" href="resources/css/style.css" type="text/css">

	<script>
	
		function deletefn(id) {
			location.href="memberdelete?mid="+id;
		}
		
		function adminPoint(id) {
			location.href="adminpoint?mid="+id;
		}
		function memberviewAjax(mid) {
			console.log(mid);
			$.ajax({
				type: 'post',
				url: 'memberviewajax',
				data: {'mid': mid},
				dataType: 'json',
				success: function(result) {
					console.log(result);
					console.log(result.mid);
					console.log(result.mname);
					console.log(result.mphone);
					console.log(result.maddr1);
					console.log(result.maddr2);
					console.log(result.maddr3);
					console.log(result.memail);
					console.log(result.mpoint);
					
					var output = "<table>";
					output += "<tr><th>ID</th> <th>NAME</th> <th>PHONE</th> <th>ADDRESS</th> <th>EMAIL</th> <th>POINT</th>";
					output += "<th>포인트지급</th></tr>";
					output += "<tr>";
					output += "<td>"+result.mid+"</td>";
					output += "<td>"+result.mname+"</td>";
					output += "<td>"+result.mphone+"</td>";
					output += "<td>"+result.maddr1+result.maddr2+result.maddr3+"</td>";
					output += "<td>"+result.memail+"</td>";
					output += "<td>"+result.mpoint+"</td>";
					output += "<td>"+result.mpoint+"</td>";
					output += "</tr>";
					output += "</table>";
					
					document.getElementById('memberviewdiv').innerHTML = output; 
				},
				error: function() {
					console.log('문제발생');
				}
			});
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
	<h2 style="color: #7fad39"><b>회원목록/포인트지급</b></h2>
		<nav class="header__menu">
	        <ul>
				<li><a href="./">홈</a></li>
				<li class="active"><a href="memberlist">회원목록/포인트지급</a></li>
				<li><a href="addshoppage">쇼핑몰 상품등록</a></li>
		 		<li><a href="reportlist">신고내역</a></li>
	 		</ul>
		</nav>
	<div id="container__list">
		<table>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>이메일</th>
				<th>포인트</th>
				<th>상세조회</th>
				<th>삭제</th>
			</tr>
			
		<c:forEach var="member" items="${memberlist}">
			<tr>
				<td>${member.mid}</td>
				<td>${member.mname}</td>
				<td>${member.mphone}</td>
				<td>${member.maddr1} ${member.maddr2} ${member.maddr3}</td>
				<td>${member.memail}</td>
				<td>${member.mpoint}</td>
				<td class="active"><a href="memberview?mid=${member.mid}">조회</a></td>
				<td><button onclick="deletefn('${member.mid}')">삭제</button></td>
				<td><button onclick="adminPoint('${member.mid}')">지급</button></td>
			</tr>
		</c:forEach>
		</table>
	</div>
</body>
</html>
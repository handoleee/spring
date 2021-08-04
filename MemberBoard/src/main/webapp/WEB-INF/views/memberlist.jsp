<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script>
		function deletefn(id) {
			location.href="memberdelete?mid="+id;
			if(confirm("탈퇴하시겠습니까?") == true){
				alert('탈퇴되었습니다.');
			}
		}
	</script>
	<style>
	table, th, tr, td {
		border: solid black 1px;
		border-collapse: collapse;
		}
	</style>
	<script>
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
					console.log(result.mpassword);
					console.log(result.mname);
					console.log(result.mphone);
					console.log(result.memail);
					
					var output = "<table>";
					output += "<tr><th>ID</th> <th>PASSWORD</th> <th>NAME</th> <th>PHONE</th>";
					output += "<th>EMAIL</th></tr>";
					output += "<tr>";
					output += "<td>"+result.mid+"</td>";
					output += "<td>"+result.mpassword+"</td>";
					output += "<td>"+result.mname+"</td>";
					output += "<td>"+result.mphone+"</td>";
					output += "<td>"+result.memail+"</td>";
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
</head>
<body>
	<h2>회원목록</h2>
	<c:if test="${sessionScope.loginMember eq 'admin'}">
	<table>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>상세조회</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="member" items="${memberList}">
		<tr>
			<td>${member.mid}</td>
			<td>${member.mpassword}</td>
			<td>${member.mname}</td>
			<td>${member.mphone}</td>
			<td>${member.memail}</td>
			<td><a href="memberview?mid=${member.mid}">조회</a></td>
			<td><button onclick="deletefn('${member.mid}')">삭제</button></td>
			<td><button onclick="memberviewAjax('${member.mid}')">조회(ajax)</button></td>
		</tr>
		</c:forEach>
	</table>
	
	<div id="memberviewdiv"></div>
	</c:if>
	<a href="./">홈으로</a>
</body>
</html>
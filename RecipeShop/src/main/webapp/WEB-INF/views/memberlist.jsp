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
<div id="container">
<h2>회원목록</h2>
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
			<td><a href="memberview?mid=${member.mid}">조회</a></td>
			<td><button onclick="deletefn('${member.mid}')">삭제</button></td>
			<td><button onclick="adminPoint('${member.mid}')">지급</button></td>
		</tr>
		</c:forEach>
	</table>
	</div>
	<div id="memberviewdiv"></div>
</body>
</html>
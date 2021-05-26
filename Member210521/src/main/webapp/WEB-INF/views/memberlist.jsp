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
	function memberviewAjax(mid) {
		console.log(mid);
		/* 
			ajax를 이용하여 id를 컨트롤러로 보냄
			DB에서 해당 id의 정보를 리턴받고 리턴받은 값을 화면에 출력
			json(javascript object notation) : 데이터형식
		*/
		$.ajax({
			type: 'post',
			url: 'memberviewajax',
			data: {'mid': mid},
			// data : {'mid': {'aa': aa, 'bb': bb, 'cc':{'dd': dd}}}
			dataType: 'json',
			success: function(result) {
				// result : controller에서 member
				console.log(result);
				console.log(result.mid);
				console.log(result.mpassword);
				console.log(result.mname);
				console.log(result.memail);
				
				var output = "<table>";
				output += "<tr><th>ID</th> <th>PASSWORD</th> <th>NAME</th>";
				output += "<th>EMAIL</th></tr>";
				output += "<tr>";
				output += "<td>"+result.mid+"</td>";
				output += "<td>"+result.mpassword+"</td>";
				output += "<td>"+result.mname+"</td>";
				output += "<td>"+result.memail+"</td>";
				output += "</tr>";
				output += "</table>";
				
				document.getElementById('memberviewdiv').innerHTML = output; 
			},
			error: function(){
				console.log('문제발생');
			}
		});
	}
</script>
<style>
table, tr, td, th{
border : solid black 1px;
border-collapse : collapse;}
</style>
</head>
<body>
<h2>memberlist.jsp</h2>

로그인아이디 : ${sessionScope.loginMember}<br>

	<table>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>이메일</th>
			<th>상세조회</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="member" items="${memberList}">
		<tr>
			<td>${member.mid}</td>
			<td>${member.mpassword}</td>
			<td>${member.mname}</td>
			<td>${member.memail}</td>
			<!-- 조회 링크를 클릭하면 memberview.jsp에 해당 회원의 정보만 출력 -->
			<td><a href="memberview?mid=${member.mid}">조회</a></td>
			<!--http://localhost:8081/member/memberview?mid=bb 
				memberview라는 주소를 요청하면서 mid 파라미터에 aa를 담아서 간다-->
			<td><button onclick="deletefn('${member.mid}')">삭제</button></td>
			<td><button onclick="memberviewAjax('${member.mid}')">조회(ajax)</button></td>
		</tr>
		</c:forEach>
	</table>
	
	<!-- ajax로 가져온 상세조회 데이터를 아래 div에 출력 -->
	<div id="memberviewdiv"></div>
	
	<script>
	function deletefn(id) {
		console.log('삭제할아이디'+id);
		location.href="memberdelete?mid="+id;
		// location.href="memberdelete?mid=+id"; (X)
		
	}
	</script>
</body>
</html>
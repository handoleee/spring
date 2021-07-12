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
		function update() {
			location.href='boardupdate?bnumber='+${board.bnumber};
			}
		
		function boardDelete() {
			location.href='boarddelete?bnumber='+${board.bnumber};
		}
	</script>
	<style>
		table, tr, th, td{
			border: 1px solid black;
			border-collapse: collapse;}
	</style>
	
</head>
<body>
<h2>boardview.jsp</h2>

	글번호 : ${board.bnumber}<br>
	작성자 : ${board.bwriter}<br>
	제목 : ${board.btitle}<br>
	내용 : ${board.bcontents}<br>
	조회수 : ${board.bhits}<br>
	작성일자 : ${board.bdate}<br>
	첨부파일 : <img src="resources/file/${board.bfilename}" height="200" width="200">
	<a href="boardlist">목록으로 돌아가기</a><br>
	<br>
		<c:set var="bwriter" value="${board.bwriter}" />
		<c:choose>
		<c:when test="${sessionScope.loginMember eq ('admin')}">
		<button onclick="update()">수정</button>
		<button onclick="boardDelete()">삭제</button>
		</c:when>
		<c:when test="${sessionScope.loginMember eq bwriter}">
		<button onclick="update()">수정</button>
		<button onclick="boardDelete()">삭제</button>
		</c:when>
		</c:choose>
		
	<div id="comment-write">
		작성자 : <input name="cwriter" placeholder="" value="${sessionScope.loginMember}" readonly><br>
		내용 : <input type="text" id="ccontents"><br>
		<button id="cwrite-btn">댓글등록</button>
	</div>

	<div id="comment-list">
		<table border="1">
			<tr>
				<th>작성자</th>
				<th>내용</th>
			</tr>
			<c:forEach var="comment" items="${commentList}">
				<tr>
					<td>${comment.cwriter}</td>
					<td>${comment.ccontents}</td>
				</tr>
			</c:forEach>	
		</table>
	</div>
	
	<script>
		$(document).ready(function(){
			$("#cwrite-btn").click(function(){
				var cwriter = '${sessionScope.loginMember}';
				var ccontents = document.getElementById('ccontents').value;
				var cbnumber = '${board.bnumber}';
				console.log(cwriter);
				console.log(ccontents);
				console.log(cbnumber);
				$.ajax({
					type: 'post',
					url: 'comment/commentwrite',
					data: {
						'cwriter': cwriter,
						'ccontents': ccontents,
						'cbnumber': cbnumber},
					dataType: 'json',
					success: function(list) {
						console.log(list);
						var output = "<table border='1'>";
						output += "<tr><th>작성자</th>";
						output += "<th>내용</th></tr>";
						for(var i in list){
							output += "<tr>";
							output += "<td>"+list[i].cwriter+"</td>";
							output += "<td>"+list[i].ccontents+"</td>";
							output += "</tr>";
						}
						output += "</table>";
						document.getElementById('comment-list').innerHTML = output;
						document.getElementById('cwriter');
						document.getElementById('ccontents').value='';
					},
					error: function() {
						console.log('문제있음.');
					}
				});
			});
		});
	</script>
</body>
</html>
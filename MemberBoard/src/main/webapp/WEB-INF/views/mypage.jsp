<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function update() {
		location.href="memberupdate";
	}
</script>
</head>
<body>
	<h2>마이페이지</h2>
	<button onclick="update()">회원정보수정</button>	
	<a href="myboardlist">내가 쓴 글목록</a>
</body>
</html>
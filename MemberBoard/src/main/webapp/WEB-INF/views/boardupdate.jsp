<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
		function updatefn() {
			updateform.submit();
		}
	</script>
</head>
<body>
	<h2>글수정</h2>
	<form action="updateprocess" method="post" name="updateform">
		<!--  type="hidden" 이면 안보임. -->
		글번호 : <input type="text" name="bnumber" value="${boardUpdate.bnumber}" readonly><br>
		작성자 : <input type="text" name="bwriter" value="${boardUpdate.bwriter}" readonly><br>
		제목 : <input type="text" name="btitle" value="${boardUpdate.btitle}"><br>
		내용 : <textarea rows=5 name="bcontents">${boardUpdate.bcontents}</textarea><br>
		<input type="button" onclick="updatefn()" value="수정">
	</form>

</body>
</html>
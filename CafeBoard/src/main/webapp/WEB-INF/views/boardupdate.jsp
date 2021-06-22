<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
		function bupdatefn() {
			bupdateform.submit();
		}
	</script>
</head>
<body>
	<h2>글수정(boardupdate.jsp)</h2>
	<form action="boardupdateprocess" method="post" name="bupdateform">
		<input type="hidden" name="bnumber" value="${boardUpdate.bnumber}" readonly>
		작성자 : ${boardUpdate.bwriter}<br>
		제목 : <input type="text" name="btitle" value="${boardUpdate.btitle}"><br>
		내용 : <textarea rows=5 name="bcontents">${boardUpdate.bcontents}</textarea><br>
		작성일자 : ${boardUpdate.bdate}<br>
	<input type="button" onclick="bupdatefn()" value="수정">
	</form>

</body>
</html>
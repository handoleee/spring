<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
		function updatefn(){
			updateform.submit();
		}
	</script>
</head>
<body>
	<h2>메뉴 수정(menuupdate.jsp)</h2>
	<form action="menuupdateprocess" method="post" name="updateform">
		<input type="hidden" name="cnumber" value="${menuUpdate.cnumber}" readonly>
		브랜드 이름 : <input type="text" name="cbrand" value="${menuUpdate.cbrand}" readonly><br>
		메뉴 이름 : <input type="text" name="cname" value="${menuUpdate.cname}"><br>
		가격 : <input type="text" name="cprice" value="${menuUpdate.cprice}"><br>
		용량 : <input type="text" name="csize" value="${menuUpdate.csize}"><br>
		알레르기 : <input type="text" name="call" value="${menuUpdate.call}"><br>
		메뉴설명 : <input type="text" name="cscri" value="${menuUpdate.cscri}"><br>
		<input type="button" onclick="updatefn()" value="수정">
	</form>
</body>
</html>
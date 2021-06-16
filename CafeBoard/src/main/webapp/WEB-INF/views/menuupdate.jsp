<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
		function menuupdatefn(){
			menuupdateform.submit();
		}
	</script>
</head>
<body>
	<h2>메뉴 수정(menuupdate.jsp)</h2>
	<form action="menuupdateprocess" method="post" name="menuupdateform">
		브랜드 이름 : <input type="text" name="cbrand" value="${contents.cbrand}" readonly><br>
		메뉴 이름 : <input type="text" name="cname" value="${contents.cname}"><br>
		가격 : <input type="text" name="cprice" value="${contents.cprice}"><br>
		용량 : <input type="text" name="csize" value="${contents.csize}"><br>
		알레르기 : <input type="text" name="call" value="${contents.call}"><br>
		메뉴설명 : <input type="text" name="cscri" value="${contents.cscri}"><br>
		<input type="button" onclick="menuupdatefn()" value="수정">
	</form>
</body>
</html>
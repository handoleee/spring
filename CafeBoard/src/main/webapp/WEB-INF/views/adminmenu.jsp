<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
		function menuupdate() {
			location.href='menuupdate?cnumber='+${contents.cnumber};
		}
		function menudelete() {
			
		}
		
	</script>
</head>
<body>
	<h2>(관리자 전용)메뉴 등록, 삭제 adminmenu.jsp</h2>
	<h3>메뉴 등록</h3>
	<!--  name="addmenuform" -->
	<form action="adminmenu" method="post" enctype="multipart/form-data">
		브랜드 이름 : <input type="text" name="cbrand"><br>
		<!-- <select id="test">
			<option value="1">스타벅스</option>
			<option value="2">커피빈</option>
			<option value="3">할리스</option>
			<option value="4">빽다방</option>
			<option value="5">메가커피</option>
				${menuList.rbrand}가 아닌 것같음.. 
				꼭 이렇게 해야만 하는지? db에서 가져오면 안되나..
			</select><br>	 -->		
		메뉴 이름 : <input type="text" name="cname"><br>
		가격 : <input type="text" name="cprice"><br>
		용량 : <input type="text" name="csize"><br>
		알레르기 : <input type="text" name="call"><br>
		메뉴설명 : <input type="text" name="cscri"><br>
		메뉴 사진 : <input type="file" name="cpic"><br>
		<input type="submit" value="등록">
	</form>
	<button onclick="menuupdate()">수정</button>
</body>
</html>
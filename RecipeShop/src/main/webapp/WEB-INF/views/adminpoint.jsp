<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
		function pointUpdatefn() {
			pointupdateform.submit();
		}
		/* function memberList(){
		document.getElementById('memberlist').innerHTML;
		} */
	</script>
</head>
<body>
	<h2>adminpoint.jsp</h2>
	<!-- <div id="memberlist"></div> -->
	
	<form action="adminpointprocess" method="post" name="pointupdateform">
		아이디<br>
			<input type="text" name="mid" value="${adminpoint.mid}" readonly><br>
		포인트<br>
			<input type="text" name="mpoint" value="${adminpoint.mpoint}">
			<input type="button" onclick="pointUpdatefn()" value="지급">
	</form>
</body>
</html>
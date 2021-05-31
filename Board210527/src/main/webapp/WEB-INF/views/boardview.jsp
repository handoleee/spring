<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	/* onclick 사용시 */
		function update() {
		location.href='boardupdate?bnumber='+${board.bnumber};
		}
		
		function boardDelete() {
			var pwd = prompt('비밀번호를 입력하세요');
			var bpassword = '${board.bpassword}';
			if(pwd == bpassword){
				location.href="boarddelete?bnumber="+${board.bnumber};
			} else {
				alert('비밀번호 불일치');
			}
			
		}
	</script>
</head>
<body>
	<h2>boardview.jsp</h2>
	글번호 : ${board.bnumber}<br>
	글제목 : ${board.btitle}<br>
	비밀번호 : ${board.bpassword}<br>
	작성자 : ${board.bwriter}<br>
	내용 : ${board.bcontents}<br>
	작성일자 : ${board.bdate}<br>
	조회수 : ${board.bhits}<br>
	첨부파일 : ${board.bfilename}<br>
	이미지 : <img src="resources/upload/${board.bfilename}" height="200" width="200"><br>
	<a href="boardlist">목록으로 돌아가기</a>


<a href="boardupdate?bnumber=${board.bnumber}">수정</a>
<button onclick="update()">수정버튼</button>
<button onclick="boardDelete('${board.bnumber}')">삭제</button>
	<!-- 위의 수정링크를 클릭하면 con ser dao db거쳐 데이터를 가지고 boardupdate.jsp출력 
	boardupdate.jsp에서 수정할 내용을 입력받고 DB에 update 쿼리 수행-->
</body>
</html>
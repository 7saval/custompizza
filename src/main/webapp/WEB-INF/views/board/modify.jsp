<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ include file="../include/include.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>수정화면</title>
</head>
<body>

<%@ include file="../header.jsp" %>


	<h2>수정</h2>
<%-- 	${board}
	${bflist} --%>
	<form action="${path}/board/modify" method="post" enctype="multipart/form-data">
		<table border="1">
					<tr>
				<th>이메일</th>
				<td><input type="text" name="email" value="${sessionScope.email}" readonly> </td>
			</tr>
			<tr>
				<th>리뷰</th>
				<td><input type="text" name="subject"> </td>
			</tr>
			
			<tr>
				<th>파일 <br><button onclick="fileAdd(event)">+</button></th>
				<td>
					<div id="divFiles">
						<input type="file" name="files"> <br>
					</div>
					
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button>저장</button>
					<button>취소</button>
				</td>
			</tr>
			
			
		</table>
	
	</form>



</body>
</html>
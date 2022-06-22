<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/include.jsp" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추가화면</title>
<script type="text/javascript" src="${path}/resources/js/fileAdd.js"></script>
</head>
<body>
<div class="container">
	<%@ include file="../header.jsp" %>
	<h2>리뷰 추가</h2>
	<form action="${path}/board/add" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="email" value="${sessionScope.email}" readonly> </td>
			</tr>
			<tr>
				<th>리뷰</th>
				<td><input type="text" name="subject"> </td>
			</tr>
			
			<tr>
				<th>사진리뷰 <br><button onclick="fileAdd(event)">+</button></th>
				<td>
					<div id="divFiles">
						<input type="file" name="files"> <br>
					</div>
					
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button onclick="location.href='${path}/board/list'">저장</button>
					<button type="reset">취소</button>
				</td>
			</tr>
			
			
		</table>
	
	</form>
</div>	
</body>
</html>
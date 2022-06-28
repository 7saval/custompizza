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
	<h2>공지 추가</h2>
	<form action="${path}/notice/add" method="post" >
		<table>
			<tr>
				<th>제목</th>
				<td><input type="text" name="n_subject"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="n_content" rows="5" cols="25"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button>공지추가</button>
					<button type="reset">취소</button>
				</td>
			</tr>
		</table>
	</form>
</div>
	<%@ include file="../footer.jsp" %>
</body>
</html>
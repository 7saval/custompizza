<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정화면</title>
</head>
<body>
	<div class="container">
	<%@ include file="../header.jsp"%>
	<h2>수정</h2>
	<form id="frmModify" action="${path}/notice/modify" method="post">
		<table border="1">
			<tr>
				<th>NO</th>
				<td><input type="text" name="n_num" value="${notice.n_num}" readonly="readonly"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="n_subject" value="${notice.n_subject}"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="5" cols="25" name="n_content">${notice.n_content}</textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button>수정</button>
					<button type="reset">취소</button>
				</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>
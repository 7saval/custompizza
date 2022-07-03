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
		<table  border="1" class="table">
			<tr>
				<th class="table-danger">제목</th>
				<td>
					<div class="form-group">
						<input class="form-control" type="text" name="n_subject">
					</div>
				</td>
			</tr>
			<tr>
				<th scope="row" class="table-danger">내용</th>
				<td>
					<div class="form-group">
						<textarea  class="form-control" name="n_content" rows="5" cols="25"></textarea>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button class="btn btn-dark">공지추가</button>
					<button class="btn btn-dark" type="reset">취소</button>
				</td>
			</tr>
		</table>
	</form>
</div>
	<%@ include file="../footer.jsp" %>
</body>
</html>
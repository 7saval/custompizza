<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/include.jsp"%>
<%@ include file="../include/sessionCheck.jsp" %> 
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
		<table border="1" class="table">
			<tr>
				<th scope="row" class="table-danger">NO</th>
				<td>
					<div class="form-group">
						<input class="form-control"  type="text" name="n_num" value="${notice.n_num}" readonly="readonly">
					</div>	
				</td>
			</tr>
			<tr>
				<th scope="row" class="table-danger">제목</th>
				<td class="col-sm-10">
					<div class="form-group">
						<input class="form-control" type="text" name="n_subject" value="${notice.n_subject}">
					</div>
				</td>
			</tr>
			<tr>
				<th scope="row" class="table-danger">내용</th>
				<td>
					<div class="form-group">
						<textarea class="form-control"  rows="5" cols="25" name="n_content">${notice.n_content}</textarea>
					</div>	
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button class="btn btn-dark">수정</button>
					<button class="btn btn-dark" type="reset">취소</button>
				</td>
			</tr>
		</table>
	</form>
	</div>
		<%@ include file="../footer.jsp" %>
</body>
</html>
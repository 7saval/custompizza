<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/include.jsp" %>
<%@ include file="../include/sessionCheck.jsp" %> 

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
		<table border="1" class="table">
			<tr>
				<th scope="row" class="table-danger">이메일</th>
				<td>
					<div class="form-group">
						<input class="form-control" type="text" name="email" value="${sessionScope.email}" readonly> 
					</div>
				</td>
			</tr>
			<tr>
				<th scope="row" class="table-danger">제목</th>
				<td>
					<div class="form-group">
						<input class="form-control" type="text" name="subject">
					</div>
				</td>
			</tr>
			<tr>
				<th scope="row" class="table-danger">내용</th>
				<td> 
					<div class="form-group">
						<textarea class="form-control" name="content" rows="5" cols="25"></textarea>
					</div>
				</td>
			</tr>
			<tr>
				<th scope="row" class="table-danger">사진첨부 <br><button onclick="fileAdd(event)">+</button></th>
				<td>
					<div id="divFiles">
						<input type="file" name="files"> <br>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button class="btn btn-dark">저장</button>
					<button class="btn btn-dark" type="reset">취소</button>
				</td>
			</tr>		
		</table>	
	</form>
</div>
<%@ include file="../footer.jsp" %>
</body>
</html>
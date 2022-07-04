<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/include.jsp"%>
<%@ include file="../include/sessionCheck.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정화면</title>
<script type="text/javascript" src="${path}/resources/js/fileAdd.js"></script>
</head>
<body>
	<div class="container">
	<%@ include file="../header.jsp"%>
	<h2>수정</h2>
	<%-- 	${board}
	${bflist} --%>
	<form id="frmModify" action="${path}/board/modify" method="post"
		enctype="multipart/form-data">
		<table border="1" class="table">
			<tr>
				<th scope="row" class="table-danger">NO</th>
				<td>
					<div class="form-group">
						<input class="form-control" type="text" name="bnum" value="${board.bnum}" readonly="readonly">
					</div>	
				</td>
			</tr>
			<tr>
				<th scope="row" class="table-danger">작성자</th>
				<td class="col-sm-10">
					<div class="form-group">
						<input class="form-control" type="text" name="email" value="${board.email}" readonly="readonly">
					</div>
				</td>
			</tr>
			<tr>
				<th scope="row" class="table-danger">제목</th>
				<td>
					<div class="form-group">
						<input class="form-control" type="text" name="subject" value="${board.subject}">
					</div>
				</td>
			</tr>
			<tr>
				<th scope="row" class="table-danger">내용</th>
				<td>
					<div class="form-group">
						<textarea class="form-control" rows="5" cols="25" name="content">${board.content}</textarea>
					</div>
				</td>
			</tr>
			<tr>
				<th scope="row" class="table-danger">사진첨부 <br><button onclick="fileAdd(event)">+</button></th>
				<!-- 기존파일리스트 -->
				
				<td>
					<div class="form-group">
						<!-- 이미지 -->
						<c:forEach var="boardfile" items="${bflist}">
							<img alt="" src="${path}/savedir/${boardfile.filename}"
								width="300">
						</c:forEach>
						<hr>
						<!-- 파일명 -->
						<c:forEach var="boardfile" items="${bflist}">
						${boardfile.filename} <input type="checkbox" name="removeFiles" value="${boardfile.bfnum}">삭제 <br>
						</c:forEach>
						<hr>
						<div id="divFiles">
							<input type="file" name="files"> <br>
						</div>
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
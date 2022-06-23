<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/include.jsp"%>
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
		<table border="1">
			<tr>
				<th>NO</th>
				<td id="bnum">${board.bnum}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${board.email}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${board.subject}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="5" cols="25">${board.content}</textarea></td>
			</tr>
			<tr>
				<th>사진첨부 <br><button onclick="fileAdd(event)">+</button></th>
				<!-- 기존파일리스트 -->
				
				<td>
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
				</td>
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
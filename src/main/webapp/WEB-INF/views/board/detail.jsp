<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/include.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세조회화면</title>
<script type="text/javascript" src="${path}/resources/js/boardDetail.js"></script>
</head>
<body>
	<%@ include file="../header.jsp" %>
	<h2>상세조회</h2>
	${bflist}
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
			<td> <textarea rows="5" cols="25" readonly="readonly">${board.content}</textarea></td>
		</tr>
		<tr>
			<th>파일</th>
			<td>
				<c:forEach var="boardfile" items="${bflist}">
					<img alt="" src="${path}/savedir/${boardfile.filename}" width="300">
				</c:forEach>
				<hr>
				<c:forEach var="boardfile" items="${bflist}">
					${boardfile.filename} <br>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<th>등록일자</th>
			<td><fmt:formatDate value="${board.regidate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
		</tr>
		<tr>
			<th>수정일자</th>
			<td><fmt:formatDate value="${board.modidate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${board.readcnt}</td>
		</tr>
		<tr>
			<!-- 좋아요 -->
			<th><i class="fas fa-thumbs-up" id="like"></i></th>
			<td id="likecnt">${board.likecnt}</td>
		</tr>	
		<tr>
			<!-- 싫어요 -->
			<th><i class="fas fa-thumbs-down" id="dislike"></i></th>
			<td id="dislikecnt">${board.dislikecnt}</td>
		</tr>
		<tr>
			<td colspan="2">
				<button onclick="location.href='${path}/board/modify?bnum=${board.bnum}'">수정하기</button>
				<button id="replyAddShow">댓글</button>
				<button onclick="removeCheck('${path}', ${board.bnum})">삭제하기</button>
				<button onclick="location.href='${path}/board/list'">리스트</button>
			</td>
		</tr>
	</table>
	<hr id="hr">
	
	
	
	<!-- 댓글추가 -->
	
	
	<!-- 일단주석처리 @@@@@@@@@@@@@뭘까?? -->
	<%-- <div class="card mb-2" id="divReplyAdd">
		<div class="card-header bg-light">
		        <i class="fa fa-comment fa"></i> REPLY 추가
		        <input type="hidden" id="restep" size="3">
		        <input type="hidden" id="relevel" size="3">
		</div>
		<div class="card-body">
			<ul class="list-group list-group-flush">
			    <li class="list-group-item">
				<div class="form-inline mb-2">
					<label for="replyemail"><i class="fas fa-envelope"></i></label>
					<input type="email" class="form-control ml-2" id="replyemail" value="${sessionScope.email}" readonly>
				</div>
				<textarea class="form-control" id="replycontent" rows="3"></textarea>
				<button type="button" class="btn btn-dark mt-3" id="replyAdd">추가</button>
				<button type="button" class="btn btn-dark mt-3" id="replyCancel">취소</button>
			    </li>
			</ul>
		</div>
	</div>	
	
	<!-- 댓글수정 -->
	
	<div class="card mb-2" id="divReplyModify">
		<div class="card-header bg-light">
			<i class="fa fa-comment fa"></i> REPLY 수정
			<input type="hidden" id="replyrnumModify">
		</div>
		<div class="card-body">
			<ul class="list-group list-group-flush">
			    <li class="list-group-item">
				<textarea class="form-control" id="replycontentModify" rows="3"></textarea>
				<button type="button" class="btn btn-dark mt-3" id="replyModify">저장</button>
				<button type="button" class="btn btn-dark mt-3" id="replyModifyCancel">취소</button>
			    </li>
			</ul>
		</div>
	</div>

	
	
	<!-- 댓글리스트 -->
	<div id="divReplyList"></div>
</div>	 --%>

</body>
</html>
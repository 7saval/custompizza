<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/include.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지상세조회</title>
<script type="text/javascript" src="${path}/resources/js/noticeDetail.js"></script>
</head>
<body>
	<div class="container">
	<%@ include file="../header.jsp" %>
	<h2>상세조회</h2>
	<table border="1">
		<tr>
			<th>NO</th>
			<td id="n_num">${notice.n_num}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${notice.n_subject}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td> <textarea rows="5" cols="25" readonly="readonly">${notice.n_content}</textarea></td>
		</tr>
		<tr>
			<th>등록일자</th>
			<td><fmt:formatDate value="${notice.n_regidate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
		</tr>
		<tr>
			<th>수정일자</th>
			<td><fmt:formatDate value="${notice.n_modidate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
		</tr>
		
		<tr>
			<th>조회수</th>
			<td>${notice.n_readcnt}</td>
		</tr>
		<tr>
			<td colspan="2">
				<button onclick="location.href='${path}/notice/modify?n_num=${notice.n_num}'">수정하기</button>
				<button onclick="removeCheck('${path}', ${notice.n_num})">삭제하기</button>
				<button onclick="location.href='${path}/notice/list'">리스트</button>
			</td>
		</tr>
	</table>
	</div>
	<%@ include file="../footer.jsp" %>
</body>
</html>
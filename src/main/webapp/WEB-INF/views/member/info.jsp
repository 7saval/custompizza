<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/include.jsp" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
<script type="text/javascript" src="${path}/resources/js/memberJoin.js"></script>
</head>
<body>
<div class="container">
	<%@ include file="../header.jsp" %>
	<h2>회원정보</h2>
	<%-- ${member} --%>
	
	<table border="1">
		<tr>
			<th>이메일</th>
			<td>${member.email}</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${member.username}</td>
		</tr>
		<tr>
			<th>휴대전화</th>
			<td>${member.mobile}</td>
		</tr>
		<tr>
			<th>우편번호</th>
			<td>${member.zipcode}</td>
		</tr>
		<tr>
			<th>도로명주소</th>
			<td>${member.addrload}</td>
		</tr>
		<tr>
			<th>상세주소</th>
			<td>${member.addrdetail}</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<button onclick="location.href='${path}/member/modify'"> 정보수정</button>
			<button onclick="removeCheck('${path}', '${member.email}')">탈퇴하기</button> 
		</td>
		</tr>
	</table>
</div>	
<%@ include file="../footer.jsp" %>	
</body>
</html>

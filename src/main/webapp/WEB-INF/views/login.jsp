<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커스텀 피자</title>
</head>
<body>
<div class="container">
	<%@ include file="header.jsp" %>
	<h2>로그인</h2>
	<form action="frmLogin" action="${path}/login" method="post">
		<table>
			<tr>
				<td> <input type="email" name="name" id="email" placeholder="이메일"></td>
			</tr>
			<tr>
				<td> <input type="password" name="passwd" id="passwd" placeholder="비밀번호"></td>
			</tr>
			<tr>
				<td><button>로그인</button></td> 
			</tr>
			<tr>
				<td><button type="reset">취소</button></td> 
			</tr>
			<tr>
				<td><a href=""><img alt="" src="${path}/resources/images/naver.png" width="150"></a></td> 
			</tr>
		</table>
	</form>
	<%@ include file="footer.jsp" %>
</div>
</body>
</html>
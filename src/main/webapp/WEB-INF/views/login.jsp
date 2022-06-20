<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커스텀 피자</title>
<script type="text/javascript" src="${path}/resources/js/login.js"></script>
</head>
<body>
<div class="container">
	<%@ include file="header.jsp" %>
	<h2 class="form-signin-heading" style="text-align: center;">로그인</h2>
	<div class="d-flex justify-content-center">	
		<form class="form-signin" id="frmLogin" action="${path}/login" method="post">
			<table>
				<tr>
					<td> <input type="email" name="email" id="email" class="form-control" placeholder="이메일" required autofocus></td>
				</tr>
				<tr>
					<td> <input type="password" name="passwd" id="passwd" class="form-control" placeholder="비밀번호" required></td>
				</tr>
				<tr>
					<td align="right"><a href="${path}/findId">아이디 찾기</a></td>
				</tr>
				<tr>
					<td><button class="btn btn-lg btn-primary btn-block" id="login">로그인</button></td> 
				</tr>
				<tr>
					<td><button class="btn btn-lg btn-secondary btn-block" type="reset">취소</button></td> 
				</tr>
				<tr>
					<td><a href="${apiURL}"><img alt="" src="${path}/resources/images/naver_1.png" width="320" height="50"></a></td> 
				</tr>
				<tr>
					<td> <br> 아직 회원이 아니십니까? <br>
						회원가입을 하시고 다양한 혜택을 받아보세요
					</td>
				</tr>
				<tr>
					<td><a href="${path}/member/join" class="btn btn-lg btn-dark btn-block" id="join">회원가입</a></td> 
				</tr>
			</table>
		</form>
	</div>
</div>
	<%@ include file="footer.jsp" %>
</body>
</html>
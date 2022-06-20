<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일 찾기</title>
</head>
<body>
<div class="container">
	<%@ include file="header.jsp" %>
	<h2 class="form-signin-heading" style="text-align: center;">이메일 찾기</h2>
	<div class="d-flex justify-content-center">	
	<form action="${path}/findId" method="post">
		<table>
			<tr>
				<td><input type="text" name="username" id="username" placeholder="회원명" style="height: 45;"></td>
			</tr>
			<tr>
				<td><button class="btn btn-lg btn-primary btn-block" id="find">찾기</button></td> 
			</tr>
		</table>	
	</form>
	</div>
</div>
	<%@ include file="footer.jsp" %>
</body>
</html>
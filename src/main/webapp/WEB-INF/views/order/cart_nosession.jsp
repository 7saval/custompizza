<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/include.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="${path}/resources/css/order.css">
</head>
<body>
<div class="container">
	<%@ include file="../header.jsp" %>
	<h2>장바구니</h2>
	
	<hr>
	<br>
	<p>장바구니가 비었습니다</p>
	<br><br><br>
		
	<div id="goOrder"  OnClick="location.href ='${path}/order/'"> 
		<br>주문하러 가기 <br><br>
	</div>
	</hr>
	
	
	
</div>
<%@ include file="../footer.jsp" %>
</body>
</html>
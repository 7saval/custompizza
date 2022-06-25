<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/include.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<%@ include file="../header.jsp" %>
	<h2>장바구니</h2>
	
	<hr>
		장바구니가 비었습니다
		
		
		<div  OnClick="location.href ='${path}/order/'" style="cursor:pointer; text-align: center; background-color:blue; color:white"> 
		
		주문하러 가기 
		
		</div>
	</hr>
	
	
	
</div>
<%@ include file="../footer.jsp" %>
</body>
</html>
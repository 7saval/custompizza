<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커스텀 피자</title>
<script type="text/javascript" src="${path}/resources/js/home.js"></script>
</head>
<body>
<div class="container">
	<%@ include file="header.jsp" %>
	<div class="bxslider">
        <div><img src="${path}/resources/images/pizza1.jpg"></div>
        <div><img src="${path}/resources/images/pizza2.jpg"></div>
        <div><img src="${path}/resources/images/pizza3.jpg"></div>
    </div>
</div>
	<%@ include file="footer.jsp" %>
</body>
</html>
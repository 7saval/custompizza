<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커스텀피자</title>
<script type="text/javascript" src="${path}/resources/js/header.js"></script>
</head>
<body>
	<header>
		<h2> <a href="${path}">CUSTOM PIZZA</a></h2>
		<div>
			<!-- 컨택스트패스 -->
			<input type="hidden" value="${path}" id="contextPath">
			<span id="sessionEmail">${sessionScope.email}</span>
			<a href="${path}/login" id="pLogin">로그인</a>
			<a href="${path}/logout" id="pLogout">로그아웃</a>
			<a href="${path}/member/join" id="pJoin">회원가입</a>
			<a href="${path}/member/info" id="pMyPage">마이페이지</a>
		</div>
	</header>
	<hr>
	<nav>
		<div class="navbar navbar-light" style="background-color: #e3f2fd;">
			<a href="${path}/notice/">공지사항</a>
			<a href="${path}/order/store">주문하기</a>
			<a href="${path}/basket/info">장바구니<span class="badge badge-light">1</span></a>
			<a href="${path}/board/">리뷰게시판</a>
		</div>
	</nav>
	<hr>
</body>
</html>
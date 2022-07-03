<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커스텀피자</title>
<script type="text/javascript" src="${path}/resources/js/header.js"></script>
<style type="text/css">
@font-face {
    font-family: 'Vitro_core';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-10-21@1.0/Vitro_core.woff') format('woff');
    font-weight: normal;
    font-style: normal;
	}
    h2 {color:red; font-family:'Vitro_core';}
    h4 {font-family:'Vitro_core';}

</style>
</head>
<body>
	<header class="d-flex justify-content-between">
		<a href="${path}"><img alt="" src="${path}/resources/images/logo.png" width="300"></a>
		<div>
			<!-- 컨택스트패스 -->
			<input type="hidden" value="${path}" id="contextPath">
			<span id="sessionEmail">${sessionScope.email}</span>
			<a href="${path}/login" id="pLogin" class="text-danger font-weight-bold">로그인</a>
			<a href="${path}/logout" id="pLogout" class="text-danger font-weight-bold">로그아웃</a>
			<a href="${path}/member/join" id="pJoin" class="text-danger font-weight-bold">회원가입</a>
			<a href="${path}/member/info" id="pMyPage" class="text-danger font-weight-bold">마이페이지</a>
		</div>
	</header>
	<hr>
	<nav>
		<div class="navbar navbar-dark bg-dark">
			<a href="${path}/notice/" class="text-light font-weight-bold">공지사항</a>
			<a href="${path}/order/" class="text-light font-weight-bold">주문하기</a>
			<a href="${path}/order/cart" class="text-light font-weight-bold">장바구니<span class="badge badge-light"></span></a>
			<a href="${path}/board/" class="text-light font-weight-bold">리뷰게시판</a>
			<a href="${path}/store" class="text-light font-weight-bold">찾아오시는길</a>
		</div>
	</nav>
	<hr>
	
<span id="sessionOrder" style="display: none">${order.details}</span>
</body>
</html>
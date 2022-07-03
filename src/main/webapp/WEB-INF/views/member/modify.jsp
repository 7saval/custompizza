<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/include.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 수정</title>
<script type="text/javascript" src="${path}/resources/js/memberJoin.js"></script>

</head>
<body>
<div class = "container">
	<%@ include file="../header.jsp" %>
	<h2>회원 수정</h2>
	<%-- ${memeber} --%>
	<form name="frmModify" id="frmModify" action="${path}/member/modify" method="post" enctype="multipart/form-data">
		<table border="1" class="table">
			<tr>
				<th scope="row" class="table-danger">이메일</th>
				<td>
					<div class="form-group">
						<input  class="form-control"  type="email" name="email" id="email" value="${member.email}" readonly> 
					</div>
				</td>
			</tr>
			<tr>
				<th scope="row" class="table-danger">기존비밀번호</th>
				<td>
					<div class="form-group">
						<input  class="form-control"  type="password" name="passwd" id="oldPasswd">
					</div>
				</td>
			</tr>
			<tr>
				<th scope="row" class="table-danger">변경비밀번호</th>
				<td>
					<div class="form-group">
						<input  class="form-control"  type="password" name="newPasswd" id="newPasswd">
					</div>
				</td>
			</tr>
			<tr>
				<th scope="row" class="table-danger">변경비밀번호확인</th>
				<td>
					<div class="form-group">
						<input  class="form-control"  type="password" id="newPasswdConfirm">
					</div>
				</td>
			</tr>					
			<tr>
				<th scope="row" class="table-danger">이름</th>
				<td>
					<div class="form-group">
						<input  class="form-control"  type="text" name="username" value="${member.username}"> 
					</div>
				</td>
			</tr>
			<tr>
				<th scope="row" class="table-danger">휴대전화</th>
				<td>
					<div class="form-group">
						<input  class="form-control"  type="text" name="mobile" value="${member.mobile}"> 
					</div>
				</td>
			</tr>
			<tr>
				<th scope="row" class="table-danger">우편번호</th>
				<td>
					<div class="form-group">
						<div class="input-group flex-nowrap">
							<input class="form-control col-4"  type="text" name="zipcode" size="5" value="${member.zipcode}">
							<button class="btn btn-dark col-2"  type="button" onclick="goPopup('${path}')">조회</button>
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<th scope="row" class="table-danger">도로명주소</th>
				<td>
					<div class="form-group">
						<input  class="form-control"  type="text" name="addrload" size="35" value="${member.addrload}"> 
					</div>
				</td>
			</tr>
			<tr>
				<th scope="row" class="table-danger">상세주소</th>
				<td>
					<div class="form-group">
						<input  class="form-control"  type="text" name="addrdetail" size="35" value="${member.addrdetail}">
					</div>
				</td>
			</tr>						
			<tr>
				<td colspan="2" align="center">
					<button class="btn btn-dark" onclick="modifyCheck(event)">수정</button> 
					<button  class="btn btn-dark" type = "reset">취소</button>
				</td>
			</tr>	
		</table>
	</form>
</div>
<%@ include file="../footer.jsp" %>	
</body>
</html>
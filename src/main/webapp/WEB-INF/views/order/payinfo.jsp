<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 정보</title>
</head>
<body>
<div class="container">
	<%@ include file="../header.jsp" %>
	<h2>결제 정보</h2>
	
		<table width="750px">
	
			<tr>
				<th width="150px">수령날짜</th>
				<td><fmt:formatDate value="${master.sales_date}" pattern="yyyy-MM-dd"/> </td>
			</tr>
			<tr>
				<th width="150px">수령시간</th>
				<td>${master.receipt_time}</td>
			</tr>
			<tr>
				<th width="150px">매장</th>
				<td>${master.store}</td>
			</tr>
			<tr>
				<th width="150px"> 주문정보 </th>
				<td> 
					<c:forEach var="detail" items="${dlist}">
						${detail.lname}
					</c:forEach>
				</td>
			</tr>
			<tr>
				<th width="150px">금액</th>
				<td>${master.price}</td>
			</tr>
			
		</table>

</div>
<%@ include file="../footer.jsp" %>
</body>
</html>
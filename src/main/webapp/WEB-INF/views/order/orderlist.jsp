<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/include.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문내역</title>
</head>
<body>
	<div class="container">
	<%@ include file="../header.jsp" %>
	
	<h2>주문내역</h2>
	🍕주문내역은 최근 10건의 내역만 조회가 가능합니다.

	<br><br>
	<table class="table">
		<thead class="thead-light">
			<tr>
				<th scope="col">주문번호</th>
				<th scope="col">수령날짜/시간</th>
				<th scope="col">매장</th>
				<th scope="col">주문정보</th>
				<th scope="col">금액</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="order_master" items="${omlist}">
				<tr>
					<td scope="row">${order_master.order_no}</td>
					<td><fmt:formatDate value="${order_master.sales_date}" pattern="yyyy-MM-dd"/> ${order_master.receipt_time} </td>
					<td>${order_master.store}</td>
					<td>
						<c:set var="no" value="no${order_master.order_no}"  />
						<c:forEach var="detail" items="${dlists[no]}">
							${detail.lname}
						</c:forEach>
					</td>
					<td>${order_master.price}</td>
				</tr>
			</c:forEach>
		</tbody>
		
	
	</table>
	
	
	</div>
	<%@ include file="../footer.jsp" %>
</body>
</html>
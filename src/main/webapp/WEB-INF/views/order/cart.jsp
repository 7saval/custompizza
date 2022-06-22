<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/include.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<script type="text/javascript">
	

</script>

</head>
<body>
	<h2>장바구니</h2>

<%-- 
	${order} <hr> 
	${order.details} <hr>
--%>
	
	<hr>
	<table>
		<tr>
			<th>주문내역</th>
			<th>금액</th>
		<tr>
		<tr>
			<td>
			 	<c:forEach var="detail" items="${order.details}">
					<c:if test="${detail.lcode ne null}">
						${detail.hname} = ${detail.lname} <br>
					</c:if>
				
				</c:forEach>
			</td>
			<td>
				<c:set var="price_sum" value="0"/>
				
				<c:forEach var="detail" items="${order.details}" varStatus="status">
					<c:if test="${detail.lcode ne null}">
					
						<c:set var="price_sum" value="${price_sum + detail.price}"/>
					</c:if>
				</c:forEach>
				
				${price_sum} 원
				
			</td>
		</tr>
	</table>
	
	<br>
	
	<form action="${path}/order/pay" method="post">
		<table>
			<tr>
				<th>매장선택</th>
			</tr>
			<tr>
				<td>
					<select name="order_master.store">
						<option value="신림점">신림점</option>
						<option value="강남점">강남점</option>
					</select>
				</td>
			</tr>
		</table>
		<br>
		<table>
			<tr>
				<th>수령시간선택</th>
			</tr>
			<tr>
				<td>
					<fmt:formatDate value="<%= new java.util.Date() %>" pattern="yyyy-MM-dd"/> 
					<input type="time"  min="11:00" max="20:00"  step="900" name="order_master.receipt_time">
				</td>
			</tr>
		</table>
		<br>
		<table>
			<tr>
				<th>결제방법</th>
			</tr>
			<tr>
				<td>
					<input type="radio" name="order_master.payment" value="0"> 현금 <br>
					<input type="radio" name="order_master.payment" value="1"> 카드 <br>
					<input type="radio" name="order_master.payment" value="2"> 네이버페이 <br>
				</td>
			</tr>
		</table>
		
		<input type="text" name="order_master.price" value="${price_sum}">
	
		<hr>
	<button>결제하기</button>
	</form>
</body>
</html>
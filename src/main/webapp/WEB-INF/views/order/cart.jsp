<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/include.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<script type="text/javascript">
	if('${order.details}' == ''){
		location.href='${path}/order/cart_nosession';
		
	}
</script>

</head>
<body>

	<div class="container">
	<%@ include file="../header.jsp" %>
	<h2>장바구니</h2>

	<hr>
	<table>
		<tr>
			<th width="300px">주문내역</th>
			<th>금액</th>
		<tr>
		<tr>
			<td width="300px">
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
					<input type="time"  min="11:00" min="<%= new java.util.Date() %>" max="20:00"  step="600" name="order_master.receipt_time">
				</td>
			</tr>
			<tr>
				<td> 🍕오전 11시부터 오후 8시까지 10분 단위로 선택해주세요 </td>
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
		
		<input type="hidden" name="order_master.price" value="${price_sum}">
	
		<hr>
		<button onclick="paycheck(event)">결제하기</button>
	</form>
	</div>
	<%@ include file="../footer.jsp" %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/include.jsp" %> 

<c:set var="today" value="<%= new java.util.Date() %>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<script type="text/javascript">

	if('${order.details}' ==''){
		location.href='${path}/order/cart_nosession';
		
	}

</script>
<script type="text/javascript" src="${path}/resources/js/pizzamake.js?ver=1"></script>
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
</head>
<body>

	<div class="container">
	<%@ include file="../header.jsp" %>
	<h2>장바구니</h2>

	<hr>
	
	<table>
		<tr>
			<th width="500px"><h4>주문내역</h4></th>
			<th><h4>금액</h4></th>
		<tr>
		<tr>
			<td width="500px">
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
	
	<br><br>
	
	<form action="${path}/order/pay" method="post" id='Frmorder_master'>
		<h4>매장선택</h4>
		<div class="form-group" style="width:150px">
			<select class="form-control start-0 translate-middle " name="order_master.store">
				<option value="신림점">신림점</option>
				<option value="강남점">강남점</option>
			</select>
		</div>

		
		<br><br>
		<h4>수령시간선택</h4>
		
		<div class="input-group mb-3">
			<fmt:formatDate value="${today}" pattern="yyyy-MM-dd"/> &nbsp;
			<input  class="form-control col-2"  name="order_master.receipt_time" id="receipt_time">
		</div>
		
		<br><br>
		<h4>결제방법</h4>
		<input type="radio" name="order_master.payment" value="0" id="pay0">
		<label for="pay0">현금</label><br>
		<input type="radio" name="order_master.payment" value="1" id="pay1"> 
		<label for="pay1">카드</label><br>
		<input type="radio" name="order_master.payment" value="2" id="pay2"> 
		<label for="pay2">네이버페이</label><br>
		

		
		<input type="hidden" name="order_master.price" value="${price_sum}">
	
		<hr>
		<button class="btn btn-dark" onclick="paycheck(event)">결제하기</button>
	</form>
	</div>
	<%@ include file="../footer.jsp" %>
	
<script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
</body>
</html>
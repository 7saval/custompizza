<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/include.jsp" %> 
<%@ include file="../include/sessionCheck.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>피자만들기</title>
<script type="text/javascript" src="${path}/resources/js/pizzamake.js"></script>
<link rel="stylesheet" href="${path}/resources/css/order.css">

</head>
<body >
<div class="container">
	<%@ include file="../header.jsp" %>
	<h2>피자만들기</h2>
	<%-- ${olist } --%>
	
	<form action="${path}/order/pizzamake" method="post" id="frmOrder">
		<c:set var="bhcode" value="first"/>

	    <c:forEach var="option" items="${olist}" varStatus="status" >
	     	
			<c:if test="${bhcode eq 'first'}"> 
				<h4 id="${option.hcode}">${option.hname} 선택</h4>
				<div class="container_pm">	
			</c:if>
			<c:if test="${bhcode ne 'first' && option.hcode ne bhcode}"> 
	 			</div> 
				<br>
				<h4 id="${option.hcode}">${option.hname} 선택</h4>
				<div class="container_pm">
	 		</c:if>
	    	
	    	
			<c:if test="${option.hcode eq'h001' || option.hcode eq 'h002' || option.hcode eq 'h003'}">
	           <div class="box">
	                 <img alt="${option.lname}" src="${path}/savedir/lowoption/${option.filename}" width="200">
	                 <input type ="hidden" name ="details[${status.index}].hcode" value="${option.hcode}">
	                 <input type ="hidden" name ="details[${status.index}].hname" value="${option.hname}">
	                 <input type ="hidden" name ="details[${status.index}].lname" value="${option.lname}">
	                 <input type ="hidden" name ="details[${status.index}].price" value="${option.price}">
	                 
	                 <input type="radio"  id="${option.hcode}_${option.lcode}" name="details[${status.index}].lcode" 
	                 		value="${option.lcode}"  class="${option.hcode}" onclick="selectRadio(event)">
	                 <label for="${option.hcode}_${option.lcode}" > ${option.lname} (${option.price}원)</label>
	            </div>
			</c:if>	            
			<c:if test="${option.hcode eq 'h004' || option.hcode eq 'h005' || option.hcode eq 'h006' }">
	           <div class="box">
	                 <img alt="${option.lname}" src="${path}/savedir/lowoption/${option.filename}" width="200">
	                 <input type ="hidden" name ="details[${status.index}].hcode" value="${option.hcode}">
	                 <input type ="hidden" name ="details[${status.index}].hname" value="${option.hname}">
	                 <input type ="hidden" name ="details[${status.index}].lname" value="${option.lname}">
	                 <input type ="hidden" name ="details[${status.index}].price" value="${option.price}">
	                 
	                 <input type="checkbox"  id="${option.hcode}_${option.lcode}"  name="details[${status.index}].lcode" value="${option.lcode}">
	                  <label for="${option.hcode}_${option.lcode}" > ${option.lname} (${option.price}원)</label>
	            </div>

			</c:if>	         
	
	    	<c:set var="bhcode" value="${option.hcode}"/> <!-- bhcode에 hcode넣기 -->
	
		</c:forEach>
			</div> 

		<hr>
		<button type="reset">다시선택</button>
		<button onclick="orderCheck(event)" >주문하기</button>
	</form>

</div>
<%@ include file="../footer.jsp" %>
</body>
</html>
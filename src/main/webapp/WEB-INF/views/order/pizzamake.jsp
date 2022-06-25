<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/include.jsp" %> 
<%@ include file="../include/sessionCheck.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>피자만들기</title>
<style type="text/css">
	.container_pm{
		display:flex;
		flex-direction: row;
		flex-wrap:wrap;
		width : 90%
	}
	
	.box {
		width : 200px;
		height : 230px;
		margin : 10px;
	}
</style>
<script type="text/javascript">
	function selectRadio(e) {
		
		const gcode = e.target.className;
		console.log(gcode);
		
		var radios = document.getElementsByClassName(gcode);
		console.log(radios);
		
		for(var i=0; i< radios.length; i++ ){
			if(e.target == radios[i])
				radios[i].checked = true;
			else
				radios[i].checked = false;
		}
	}

</script>
</head>
<body >
<div class="container">
	<%@ include file="../header.jsp" %>
	<h2>피자만들기</h2>
	<%-- ${olist } --%>
	
	<form action="${path}/order/pizzamake" method="post">
		<c:set var="bhcode" value="first"/>

	    <c:forEach var="option" items="${olist}" varStatus="status" >
	     	
			<c:if test="${bhcode eq 'first'}"> 
				<h4>${option.hname} 선택</h4>
				<div class="container_pm">	
			</c:if>
			<c:if test="${bhcode ne 'first' && option.hcode ne bhcode}"> 
	 			</div> <!-- 열어준 container 닫기 -->
				<br>
				<h4>${option.hname} 선택</h4>
				<div class="container_pm">
	 		</c:if>
	    	
	    	<!-- hcode가 전과 같으면 박스만들기 X -->
			<c:if test="${option.hcode eq'h001' || option.hcode eq 'h002' || option.hcode eq 'h003'}">
	           <div class="box">
	                 <img alt="${option.lname}" src="${path}/savedir/lowoption/${option.filename}" width="200">
	                 <input type ="hidden" name ="details[${status.index}].hcode" value="${option.hcode}">
	                 <input type ="hidden" name ="details[${status.index}].hname" value="${option.hname}">
	                 <input type ="hidden" name ="details[${status.index}].lname" value="${option.lname}">
	                 <input type ="hidden" name ="details[${status.index}].price" value="${option.price}">
	                 <%-- <input type ="hidden" name ="details[${status.index}].lcode" value="${option.lcode}"> --%>
	                 
	                 <input type="radio" name="details[${status.index}].lcode" value="${option.lcode}"  class="${option.hcode}" onclick="selectRadio(event)">
	                 ${option.lname} (${option.price}원)
	            </div>
			</c:if>	            
			<c:if test="${option.hcode eq 'h004' || option.hcode eq 'h005' || option.hcode eq 'h006' }">
	           <div class="box">
	                 <img alt="${option.lname}" src="${path}/savedir/lowoption/${option.filename}" width="200">
	                 <input type ="hidden" name ="details[${status.index}].hcode" value="${option.hcode}">
	                 <input type ="hidden" name ="details[${status.index}].hname" value="${option.hname}">
	                 <input type ="hidden" name ="details[${status.index}].lname" value="${option.lname}">
	                 <input type ="hidden" name ="details[${status.index}].price" value="${option.price}">
	                 <%-- <input type ="hidden" name ="details[${status.index}].lcode" valrue="${option.lcode}"> --%>
	                 
	                 <input type="checkbox" name="details[${status.index}].lcode" value="${option.lcode}"> ${option.lname} (${option.price}원)
	            </div>

	     
			</c:if>	         
	
	    	<c:set var="bhcode" value="${option.hcode}"/> <!-- bhcode에 hcode넣기 -->
	
		</c:forEach>
			</div> <!-- 열어준 container 닫기 --> 

		<hr>
		<button type="button">다시선택</button>
		<button>주문하기</button>
	</form>

</div>
<%@ include file="../footer.jsp" %>
</body>
</html>
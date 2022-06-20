<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
<title>찾아오시는길</title>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=ukqfsgw1gc"></script>
<script>
	$(function(){		
		$('#mapAdd').click(function(){
			const storeMap = $('.storeMap').val();
			switch(storeMap){
			case "1" :
				//강남점
				//map id에 맵 생성
				var map = new naver.maps.Map('map', {
				    center: new naver.maps.LatLng(37.50165503431403, 127.02642086613072),
				    zoom: 18
				});
				//마커 생성
				var marker = new naver.maps.Marker({
				    position: new naver.maps.LatLng(37.50165503431403, 127.02642086613072),
				    map: map
				});
			break;
			case "2" :
				//신림점
				//map id에 맵 생성
				var map = new naver.maps.Map('map', {
				    center: new naver.maps.LatLng(37.48389246872603, 126.93023449183205),
				    zoom: 18
				});
				//마커 생성
				var marker = new naver.maps.Marker({
				    position: new naver.maps.LatLng(37.48389246872603, 126.93023449183205),
				    map: map
				});
			break;
			}
			
		});
	});
	
</script>
</head>
<body>
<div class="container">
	<%@ include file="header.jsp" %>
	<h2>매장 찾기</h2>
		<label>매장명</label>
			<select class="storeMap" name="storeMap" id="storeMap" style="width: 300px; height: 22px">
				<option value="선택">선택</option>
				<option value="1">강남점</option>
				<option value="2">신림점</option>
			</select>
		<button id="mapAdd">검색</button>
	<hr>
	<div id="map" style="width:100%;height:400px;"></div>
</div>
	<%@ include file="footer.jsp" %>
</body>
</html>
/**
 * 헤더
 */
//document가 준비되었을 때
$(function(){
	//컨택스트 패스
	const path = $('#contextPath').val();
	//세션 이메일
	const sessionEmail = $('#sessionEmail').text().trim();
	//세션 오더
	const sessionOrder = $('#sessionOrder').html();
	console.log(sessionOrder);
	if(!sessionEmail){ //로그인 전
		$('#pLogin').show();
		$('#pLogout').hide();
		$('#pJoin').show();
		$('#pDropDown').hide();

	}else{ //로그인 후
		$('#pLogin').hide();
		$('#pLogout').show();
		$('#pJoin').hide();

		$('#pDropDown').show();

	}

	
	//로그아웃 버튼을 클릭했을 때
	$('#pLogout').click((e)=>{
		e.preventDefault();
		if(confirm('로그아웃 하시겠습니까?')){
			location.href= `${path}/logout`;
		}
	});
	
	if(sessionOrder == ''){
		$('.badge').text('');
	}else{
		$('.badge').text('new');
	}
	
});
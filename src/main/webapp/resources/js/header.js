/**
 * 헤더
 */
//document가 준비되었을 때
$(function(){
	//컨택스트 패스
	const path = $('#contextPath').val();
	
	const sessionEmail = $('#sessionEmail').text().trim();

	if(!sessionEmail){ //로그인 전
		$('#pLogin').show();
		$('#pLogout').hide();
		$('#pJoin').show();
		$('#pMyPage').hide();
	}else{ //로그인 후
		$('#pLogin').hide();
		$('#pLogout').show();
		$('#pJoin').hide();
		$('#pMyPage').show();
	}
	
	//로그아웃 버튼을 클릭했을 때
	$('#pLogout').click((e)=>{
		e.preventDefault();
		if(confirm('로그아웃 하시겠습니까?')){
			location.href= `${path}/logout`;
		}
	});
});
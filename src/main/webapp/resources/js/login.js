/**
 * 
 */
$(function(){
	//로그인 버튼을 클릭했을 때
	$('#login').click(e=>{
		e.preventDefault();
		const email = $('#email');
		const passwd = $('#passwd');
		if(!email.val()){
			alert('이메일을 입력해주세요');
			email.focus();
			return;
		}else if(!passwd.val()){
			alert('비밀번호를 입력해주세요');
			passwd.focus();
			return;
		}
		$('#frmLogin').submit();
	});
});
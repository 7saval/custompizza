/**
 * 
 */
$(function(){
	//쿠키값 읽어오기
	const mail = getCookie('CookieEmail');
	if(mail){
		$('#email').val(mail);
		$('#savecheck').attr("checked",true);
	}
	
	//로그인 버튼을 클릭했을 때
	$('#login').click(e=>{
		e.preventDefault();
		const email = $('#email');
		const passwd = $('#passwd');
		const savecheck = $('#savecheck').is(':checked');
		if(!email.val()){
			alert('이메일을 입력해주세요');
			email.focus();
			return;
		}else if(!passwd.val()){
			alert('비밀번호를 입력해주세요');
			passwd.focus();
			return;
		}else if(savecheck){
			setCookie('CookieEmail',email,7);
		}else{
			deleteCookie('CookieEmail');
		}
		$('#frmLogin').submit();
	});
	
	function setCookie(cookieName, value, exdays){
		const exdate = new Date();
		exdate.setDate(exdate.getDate() + exdays); //쿠키 저장 기간
		const cookieValue = escape(value) + ((exdays==null)?"":";expires=" + exdate.toGMTString());
		document.cookie = cookieName + "=" + cookieValue;
	}
	
	function getCookie(cookieName){
		cookieName = cookieName + '=';
		const cookieData = document.cookie;
		const start = cookieData.indexOf(cookieName);
		const cookieValue = '';
		
		if(start != -1){
			start += cookieName.length;
			var end = cookieData.indexOf(';',start);
		}
		if(end == -1){
			end = cookieData.length;
			cookieValue = cookieData.substring(start,end);
		}
		return unescape(cookieValue);
	}
	
	function deleteCookie(cookieName){
		const expireDate = new Date();
		expireDate.setDate(expireDate.getDate()-1);
		document.cookie = cookieName + "= "+";expires="+expireDate.toGMTString();
	}
	
	
	
});
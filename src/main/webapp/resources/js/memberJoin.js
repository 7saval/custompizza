//회원가입 js


function removeCheck(path, email){
	if(!confirm('삭제 하시겠습니까?')) return ;
	location.href=path+'/member/remove?email='+email;
}
// 주소검색을 수행할 팝업 페이지를 호출합니다.
// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
function goPopup(path){
	//컨트롤러에 jusoPopup.jsp호출 요청	
	var pop = window.open(path + "/member/jusoPopup","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
}
//주소팝업 호출후 실행할 함수
function jusoCallBack(zipNo,roadAddrPart1,addrDetail){
	const forms = document.getElementsByTagName('form');
	console.log(forms[0].name);
	// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
	forms[0].zipcode.value = zipNo;
	forms[0].addrload.value = roadAddrPart1;
	forms[0].addrdetail.value = addrDetail;
}
	
//회원가입 버튼을 가입했을때 
function joinCheck(e){
	e.preventDefault(); //기본
	const email = document.getElementById('email');
	const passwd = document.getElementById('passwd');
	const passwdConfirm = document.getElementById('passwdConfirm');
	console.log(email.value);
	console.log(passwd.value);
	console.log(passwdConfirm.value);
	if (!email.value){
		alert('이메일을 입력해주세요!');
		email.focus();
		return ;
	}
	if (!passwd.value){
		alert('비밀번호를 입력해주세요!');
		passwd.focus();
		return ;
	}
	if (!passwdConfirm.value){
		alert('비밀번호 확인을 입력해주세요!');
		passwdConfirm.focus();
		return ;
	}
	if (passwd.value !== passwdConfirm.value){
		alert('비밀번호가 일치하지 않습니다!');
		passwdConfirm.focus();
		return ;
	}
	
	document.getElementById('frmJoin').submit();
}
	//수정버튼클릭했을때
	function modifyCheck(e){
		e.preventDefault(); //기본
		const oldPasswd = document.getElementById('oldPasswd'); //
		const newPasswd = document.getElementById('newPasswd'); //
		const newPasswdConfirm = document.getElementById('newPasswdConfirm');
		
		
		if (!oldPasswd.value){
			alert('기존비밀번호를 입력해주세요!');
			oldPasswd.focus();
			return ;
		}
	
		if (newPasswd.value !== newPasswdConfirm.value){
			alert('변경 비밀번호가 일치하지 않습니다!');
			newPasswd.focus();
			return ;
		}
		
		document.getElementById('frmModify').submit();
	
}
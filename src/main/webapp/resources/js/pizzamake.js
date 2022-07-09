

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
		
	
function orderCheck(e){
	e.preventDefault();
	
	const h001 = document.getElementsByClassName('h001');
	const h002 = document.getElementsByClassName('h002');
	const h003 = document.getElementsByClassName('h003');
	console.log(h001);
	console.log(h002);
	console.log(h003);
	
	//메시지 뿌려주기 위해서
	const h001name = document.getElementById('h001').innerText; //사이즈 선택
	const h002name = document.getElementById('h002').innerText;
	const h003name = document.getElementById('h003').innerText;
	console.log(h001name);
	console.log(h002name);
	console.log(h003name);

	//필수선택 배열 
	const selArr = [
		{
			code : h001, //배열(L, M)
			name : h001name,
		},
		{
			code : h002,
			name : h002name,
		},
		{
			code : h003,
			name : h003name,
		},
		
	];
		for(var i =0; i < selArr.length ; i++){
			var selCheck = false; 
			for(var j=0; j< selArr[i].code.length; j++){
				if (selArr[i].code[j].checked){
					selCheck = true; 
					break;
				}
			}
			if (!selCheck) { //한개라도 체크가 안되어 있다면
				alert(selArr[i].name);
				return ; //함수의 종료
			}
		}
		

	document.getElementById('frmOrder').submit();
}


function paycheck(e){
	e.preventDefault();
	
	const receipt_time = document.getElementById('receipt_time');
	const payment = document.getElementsByName('order_master.payment');
	
	var selCheck = null;
	
	if(receipt_time.value == ''){
		alert('수령시간을 입력해주세요');
		return;
	}
	
	
	for(var i=0; i<payment.length; i++){
		if(payment[i].checked == true){
			selCheck=payment[i].value;
		}
	}
	if(!selCheck){
		alert('결제수단을 입력해주세요');
		return;
	}
	
	document.getElementById('Frmorder_master').submit();
}


$(document).ready(function(){
 
    $('#receipt_time').timepicker({
    timeFormat: 'H:mm ',
    interval: 10,
    minTime: '11:00',
    maxTime: '20:00',
    dynamic: false,
    dropdown: true,
    scrollbar: true
	});
    
    
});


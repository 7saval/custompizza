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
			code : h001, //배열(L, M, S)
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
	
	//사이즈(h001) : L, M , S 
	//도우선택(h002) :
	//소스선택(h003)
	for(var i =0; i < selArr.length ; i++){ //3번 반복
		var selCheck = false; //선택이 안되어 있다고 가정
		for(var j=0; j< selArr[i].code.length; j++){
			if (selArr[i].code[j].checked){
				selCheck = true; //선택이 됬음
				break;
			}
		}
		if (!selCheck) { //한개라도 체크가 안되어 있다면
			alert(selArr[i].name);
			return ; //함수의 종료
		}
	}
		

/*		if(!h001[0].checked && !h001[1].checked){
			alert('사이즈를 선택해주세요');
			return;
		}else if (!h002[0].checked && !h002[1].checked && !h002[2].checked ){
			alert('도우를 선택해주세요');
			return;
		}else if (!h003[0].checked && !h003[1].checked && !h003[2].checked){
			alert('베이스 소스를 선택해주세요');
			return;
		} 
	*/
	document.getElementById('frmOrder').submit();
}
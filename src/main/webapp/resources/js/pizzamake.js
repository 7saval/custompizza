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
	
	const h001name = document.getElementById('h001').innerText;
	const h002name = document.getElementById('h002').innerText;
	const h003name = document.getElementById('h003').innerText;
	console.log(h001name);
	console.log(h002name);
	console.log(h003name);

	//필수선택 배열 
	const selArr = [
		{
			code : h001,
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
		if (!selCheck) {
			alert(selArr[i].name);
			return ;
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
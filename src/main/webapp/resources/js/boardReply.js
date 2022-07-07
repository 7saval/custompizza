/**
 * 게시물 댓글
 */

 //윈도우가 로딩이 완료된 후
$(()=>{
	//컨택스트 패스
	const path = $('#contextPath').val();	
	//console.log(path);
	//핸들바에서 사용 : 헬퍼만들기 (댓글 처리시 들여쓰기)
	Handlebars.registerHelper('levelSpace', function(relevel){
		let result = '';
		for(var i=0; i<relevel; i++)
			result += '<div class ="divSpace"></div>';
		return result;
	});

	//댓글창 초기화
	const replyInit = ()=>{
		//입력된 내용 지우기
		$('#replycontent').val('');
		
		//댓글추가 div 이동
		$('#hr').after($('#divReplyAdd'));
		
		//댓글추가 창 숨기기
		$('#divReplyAdd').hide();
		
		//댓글수정 div 이동
		$('#hr').after($('#divReplyModify'));

		//댓글수정 창 숨기기
		$('#divReplyModify').hide();
		
	};
	
	//댓글의 리스트 
	const replyList = ()=>{
		
		replyInit();//댓글창 초기화
		
		//게시물 번호
		const bnum = $('#bnum').text();

		//ajax 서버 호출(get)
		fetch(`${path}/reply/list/${bnum}`)
		.then(res=>res.json())
		.then(data=>{
			console.log(data);
			/*탬플릿소스가져오기*/
			const source = document.getElementById('template_source').innerHTML;
			console.log(source);
			//소스컴파일
			const template = Handlebars.compile(source);
			//컴파일된 데이터를 div넣기 
			document.getElementById('divReplyList').innerHTML= template(data);
			
		})
		.catch(console.err);
		
	};
	
	replyList(); //댓글의 리스트 출력 함수 호출
	
	//게시물의 댓글 버튼을 클릭했을때
	document.getElementById('replyAddShow').addEventListener('click',()=>{
			//부모의 restep,relevel
			document.getElementById('restep').value = 0;
			document.getElementById('relevel').value = 0;
			
			//댓글추가 div 이동
			const hr = document.getElementById(`hr`);
			const divReplyAdd = document.getElementById('divReplyAdd');
			hr.after(divReplyAdd);
			
			//댓글추가 div 보이기
			divReplyAdd.style.display = '';
		
	});
	
	//댓글추가창에서 취소버튼을 클릭했을때
	document.getElementById('replyCancel').addEventListener('click', ()=>{
		//댓글추가 창 숨기기
		document.getElementById('divReplyAdd').style.display = 'none';	
	});
	
	
	//부모를 선택하고 자식엘리먼트에 이벤트 달기
	//댓글리스트의 댓글버튼을 클릭했을때
	$('#divReplyList').on('click','.reReplyAddShow', (e)=>{
		//rnum,restep,relevel 가져오기
		const rnum = e.target.value;
		//console.log(rnum); 
		const restep = document.getElementById(`restep${rnum}`).innerText;
		//console.log(restep); 
		const relevel = document.getElementById(`relevel${rnum}`).innerText;
		//console.log(relevel); 
		//부모의 restep, relevel
		document.getElementById('restep').value = restep;
		document.getElementById('relevel').value = relevel;
		
		//댓글추가 div 이동
		const reply = document.getElementById(`reply${rnum}`);
		const divReplyAdd = document.getElementById('divReplyAdd');
		reply.after(divReplyAdd);
		
		//댓글추가 div 보이기
		divReplyAdd.style.display = '';
	});
	//댓글리스트의 삭제 버튼을 클릭했을때
	$('#divReplyList').on('click', '.reReplyRemove', (e)=>{
		if (!confirm('삭제하시겠습니까?')) return ;
		
		const rnum = e.target.value;
		console.log(rnum);

		//ajax 서버 호출		
		$.ajax({
			url : `${path}/reply/${rnum}`,
			type : 'delete',
			dataType : 'text',
			success : (text)=>{ //컨트롤러 리턴값
				alert(text);
				replyList(); //댓글의 리스트 호출
			},
			error : console.error 
		});
	});
	
	//댓글리스트의 수정 버튼을 클릭했을때
	$('#divReplyList').on('click', '.reReplyModify', (e)=>{
		const rnum = e.target.value;
		console.log(rnum);
		//댓글수정 div 이동
		const reply = document.getElementById(`reply${rnum}`);
		const divReplyModify = document.getElementById('divReplyModify');
		reply.after(divReplyModify);
		//댓글수정 창 보이기
		divReplyModify.style.display = '';
	
		//기존 rnum, content 세팅
		document.getElementById(`replyrnumModify`).value = rnum;
		const content = document.getElementById(`content${rnum}`).innerText;
		document.getElementById(`replycontentModify`).innerHTML = content;		
	});
	
	//추가댓글의 추가버튼 클릭시
	$('#replyAdd').click(()=>{
		//추가할 내용 읽어오기
		const bnum = $('#bnum').text();
		const email = $('#replyemail').val();
		const content = $('#replycontent').val();
		const restep = $('#restep').val(); // 댓글의 순서
		const relevel = $('#relevel').val(); // 댓글의 레벨
		
		//전송할 데이터(자바스트립트 객체)
		const data ={
			bnum,
			email,
			content,
			restep,
			relevel,
		};
		console.log(data);
		console.log(typeof(data));
		
		//jquery 서버 호출
		$.ajax({
			url : `${path}/reply/`,
			type : 'post',
			contentType : 'application/json', //보내는 데이터의 타입
			data: JSON.stringify(data), //보내는 데이터  json의 문자열
			dataType : 'text', //받을 데이터의 타입 문자열로
			success : (text)=>{
				//alert(text);
				console.log(text);
				replyList(); //댓글의 리스트 호출
			},
			error : function(err){
				console.log(err);
			}
			
		});
		
	});
	
	//댓글수정의 저장버튼을 클릭했을때
	$('#replyModify').click(()=>{
		//rnum, content
		const rnum = $('#replyrnumModify').val();
		const content = $('#replycontentModify').val();
		console.log(rnum);
		console.log(content);
		//보낼데이터 객체 생성
		const data = {
			rnum,
			content,
		};
		
		$.ajax({
			url : `${path}/reply/`,
			type : 'put',
			contentType : 'application/json',
			data : JSON.stringify(data),//보낼데이터 json문자열 변환
			success : (text)=>{
				alert(text);
				replyList(); //댓글의 리스트 호출				
			},
			error : console.error
		});
	
	});
	
	//댓글수정창에서 취소버튼을 클릭했을때
	document.getElementById('replyModifyCancel').addEventListener('click', ()=>{
		//댓글수정 창 숨기기
		document.getElementById('divReplyModify').style.display = 'none';	
	});
});

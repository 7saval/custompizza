/**
 * 게시물 상세 조회
 */
 //삭제버튼 클릭시
function removeCheck(path, bnum){
	if(!confirm('삭제 하시겠습니까?')) return ;
	location.href=path+'/board/remove?bnum='+bnum;
}

//로딩이 완료된후
$(()=>{
	//컨택스트 패스
	const path = $('#contextPath').val();	
	//console.log(path);
	//게시물 번호
	const bnum = $('#bnum').text();
	
	//이벤트 달기 : 좋아요+1
	$('#like').click(()=>{
		//jquery 비동기방식 서버 호출
		$.ajax({
			url : `${path}/board/like/${bnum}`,
			type : 'put',
			dataType : 'text', //전송받은 데이터 문자열로 
			success : function(text){
				//alert(text);
				console.log('리턴값:',text); //좋아요 likecnt
				$('#likecnt').text(text);
			},
			error : function(err){
				console.log(err);
			}
		});
	});
	
	
	//싫어요+1
	$('#dislike').click(()=>{
		//jquery 비동기방식 서버 호출
		$.ajax({
			url : `${path}/board/dislike/${bnum}`,
			type : 'put',
			dataType : 'text', //전송받은 데이터 문자열로 
			success : function(text){
				console.log('리턴값:',text); //좋아요 likecnt
				$('#dislikecnt').text(text);
			},
			error : function(err){
				console.log(err);
			}
		});
	}); //dislike click이벤트 닫기
	
});

 

/**
 * 게시물 상세 조회
 */
 //삭제버튼 클릭시
function removeCheck(path, n_num){
	if(!confirm('삭제 하시겠습니까?')) return ;
	location.href=path+'/notice/remove?n_num='+n_num;
}
 

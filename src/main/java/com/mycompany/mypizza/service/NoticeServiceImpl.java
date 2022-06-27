package com.mycompany.mypizza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.mypizza.advice.ErrorCode;
import com.mycompany.mypizza.dto.Notice;
import com.mycompany.mypizza.dto.Page;
import com.mycompany.mypizza.repository.BoardRepository;
import com.mycompany.mypizza.repository.NoticeRepository;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	
	@Autowired
	private NoticeRepository noticeRepository;
	

	@Override
	public List<Notice> selectList(Page page) {
		//페이징 처리
		int curPage = page.getCurPage(); //현재페이지
		int perPage = page.getPerPage(); //한페이지당 게시물수
		int perBlock = page.getPerBlock(); //페이지 블럭의 수
		
		//1)게시물의 시작번호(mysql은 시작번호 0번 부터)
		//오라클은 + 1
		int startNum = (curPage-1) * perPage;
		//2)게시물의 끝번호
		int endNum = startNum + perPage -1;
		
		//3)전체페이지수
		int totalCnt = noticeRepository.selectTotalCnt(page); //전체게시물수
		int totPage = totalCnt/perPage;
		if (totalCnt%perPage!=0) totPage++; //나머지가 있으면 +1
		
		//4)페이지블럭의 시작페이지
		int startPage= curPage - ((curPage-1)%perBlock);
		//5)페이지블럭의 끝페이지
		int endPage = startPage + perBlock - 1;
		if (endPage>totPage) endPage=totPage; //endPage는 totPage보다 작거나 같아야 한다

		
		//page 세팅
		page.setStartNum(startNum);
		page.setEndNum(endNum);
		page.setStartPage(startPage);
		page.setEndPage(endPage);
		page.setTotPage(totPage);
				
		return noticeRepository.selectList(page);
	}

	@Override
	public Notice selectOne(int n_num) {
		return noticeRepository.selectOne(n_num);
	}

	@Override
	public ErrorCode insert(Notice notice) throws Exception {
		noticeRepository.insert(notice);
		return ErrorCode.SUCCESS_ADD;
	}

	
	@Override
	public ErrorCode update(Notice notice) throws Exception {
		 noticeRepository.update(notice);
		 return ErrorCode.SUCCESS_MODIFY;
	}

	@Override
	public ErrorCode delete(int n_num) throws Exception {
		 noticeRepository.delete(n_num);
		 return ErrorCode.SUCCESS_REMOVE;
	}

	@Override
	public int updateReadCnt(int n_num) {
		return noticeRepository.updateReadCnt(n_num);
	}

}

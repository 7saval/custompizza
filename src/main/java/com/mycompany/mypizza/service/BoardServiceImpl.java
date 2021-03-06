
  package com.mycompany.mypizza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.mypizza.advice.ErrorCode;
import com.mycompany.mypizza.dto.Board;
import com.mycompany.mypizza.dto.BoardFile;
import com.mycompany.mypizza.dto.Page;
import com.mycompany.mypizza.repository.BoardFileRepository;
import com.mycompany.mypizza.repository.BoardRepository;


@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository boardRepository;
	@Autowired
	private BoardFileRepository boardFileRepository; 
	
	@Autowired
	private FileService fileService;
	
	@Override
	public List<Board> selectList(Page page) {
		//페이징 처리
		int curPage = page.getCurPage(); //현재페이지
		int perPage = page.getPerPage(); //한페이지당 게시물수
		int perBlock = page.getPerBlock(); //페이지 블럭의 수
		
		int startNum = (curPage-1) * perPage;
		int endNum = startNum + perPage -1;
		int totalCnt = boardRepository.selectTotalCnt(page); //전체게시물수
		int totPage = totalCnt/perPage;
		if (totalCnt%perPage!=0) totPage++; 
		int startPage= curPage - ((curPage-1)%perBlock);
		int endPage = startPage + perBlock - 1;
		if (endPage>totPage) endPage=totPage;
		
		//page 세팅
		page.setStartNum(startNum);
		page.setEndNum(endNum);
		page.setStartPage(startPage);
		page.setEndPage(endPage);
		page.setTotPage(totPage);
		
		return boardRepository.selectList(page);
	}

	@Override
	public Board selectOne(int bnum) {
		return boardRepository.selectOne(bnum);
	}

	//트랜잭션 관리(commit,rollback)
	@Transactional(rollbackFor = {Exception.class, Error.class})
	@Override
	public ErrorCode insert(Board board) throws Exception {
		boardRepository.insert(board);
		boardFilesSave(board);
		
		return ErrorCode.SUCCESS_ADD;
		
	}

	@Override
	public int updateReadCnt(int bnum) {
		return boardRepository.updateReadCnt(bnum);
	}
	
	
	@Transactional(rollbackFor = {Exception.class, Error.class})
	@Override
	public ErrorCode update(Board board, List<Integer> removeFiles) throws Exception {
		boardRepository.update(board);
		if (removeFiles!= null) {
			for(int bfnum : removeFiles) {
				boardFileRepository.delete(bfnum);
			}
		}
		boardFilesSave(board);
		
		return ErrorCode.SUCCESS_MODIFY;
	}
	
	private void boardFilesSave(Board board) throws Exception {
		//게시물 파일들 저장
		List<MultipartFile> files = board.getFiles();
		for(MultipartFile file:files) {
			String filename = fileService.fileUpload(file); 		//파일을 저장
			if (filename.equals("")) continue;  //파일이름이 공백일경우 저장하지 않는다

			//게시물파일db저장 
			BoardFile boardFile = new BoardFile();
			boardFile.setBnum(board.getBnum()); //게시물의 bnum세팅
			boardFile.setFilename(filename);
			boardFileRepository.insert(boardFile);
		}
	}

	
	@Override
	public int updateLikeCnt(int bnum) {
		return boardRepository.updateLikeCnt(bnum);
	}

	@Override
	public int updateDisLikeCnt(int bnum) {
		return boardRepository.updateDisLikeCnt(bnum);
		
	}

	@Override
	public ErrorCode delete(int bnum) throws Exception {
		boardRepository.delete(bnum);
		return ErrorCode.SUCCESS_REMOVE;
	}

	
	

}

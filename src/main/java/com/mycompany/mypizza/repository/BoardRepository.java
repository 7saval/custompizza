package com.mycompany.mypizza.repository;

import java.util.List;

import com.mycompany.mypizza.dto.Board;
import com.mycompany.mypizza.dto.Page;

public interface BoardRepository {

	
	int insert(Board board);
	int update(Board board);
	int delete(int bnum);
	Board selectOne(int bnum);
	List<Board> selectList(Page page); 
	
	//전체게시물수 구하기
	int selectTotalCnt(Page page);
	
	//조회수+1
	int updateReadCnt(int bnum);
	//좋아요+1
	int updateLikeCnt(int bnum);
	//싫어요 + 1
	int updateDisLikeCnt(int bnum);
	
}

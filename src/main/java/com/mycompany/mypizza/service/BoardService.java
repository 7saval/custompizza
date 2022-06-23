package com.mycompany.mypizza.service;

import java.util.List;

import com.mycompany.mypizza.advice.ErrorCode;
import com.mycompany.mypizza.dto.Board;
import com.mycompany.mypizza.dto.Page;

public interface BoardService {
	List<Board> selectList(Page page);
	
	Board selectOne(int bnum);
	//열거형 반환
	ErrorCode insert(Board board) throws Exception;
	ErrorCode update(Board board,List<Integer> removeFiles) throws Exception;
	ErrorCode delete(int bnum) throws Exception;
	
	//조회수+1
	int updateReadCnt(int bnum);
	//좋아요+1
	int updateLikeCnt(int bnum);
	//싫어요+1
	int updateDisLikeCnt(int bnum);

}

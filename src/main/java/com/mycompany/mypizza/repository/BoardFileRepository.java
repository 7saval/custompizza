package com.mycompany.mypizza.repository;

import java.util.List;

import com.mycompany.mypizza.dto.BoardFile;

public interface BoardFileRepository {

	int insert(BoardFile boardFile);
	int update(BoardFile boardFile);
	int delete(int bfnum);
	BoardFile selectOne(int bfnum);
	List<BoardFile> selectList(int bnum);
	int deleteAll(int bnum);
	
}

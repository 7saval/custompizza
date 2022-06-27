package com.mycompany.mypizza.service;

import java.util.List;

import com.mycompany.mypizza.dto.BoardFile;

public interface BoardFileService {

	List<BoardFile> selectList(int bnum);
	int deleteAll(int bnum);
	
}

package com.mycompany.mypizza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.mypizza.dto.BoardFile;
import com.mycompany.mypizza.repository.BoardFileRepository;

@Service
public class BoardFileServiceImpl implements BoardFileService {
	
	@Autowired
	private BoardFileRepository boardFileRepository;

	@Override
	public List<BoardFile> selectList(int bnum) {
		// TODO Auto-generated method stub
		return boardFileRepository.selectList(bnum);
	}

	@Override
	public int deleteAll(int bnum) {
		return boardFileRepository.deleteAll(bnum);
	}

}

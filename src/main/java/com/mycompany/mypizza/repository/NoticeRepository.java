package com.mycompany.mypizza.repository;

import java.util.List;
import java.util.Map;

import com.mycompany.mypizza.dto.Notice;
import com.mycompany.mypizza.dto.Page;


public interface NoticeRepository {
	
	int insert(Notice notice);
	int update(Notice notice);
	int delete(int n_num);
	Notice selectOne(int n_num);
	List<Notice> selectList(Page page);
	
	//전체게시물수 구하기
	int selectTotalCnt(Page page);
		
	int updateReadCnt(int n_num); //조회수

}

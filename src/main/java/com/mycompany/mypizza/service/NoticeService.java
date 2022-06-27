package com.mycompany.mypizza.service;

import java.util.List;

import com.mycompany.mypizza.advice.ErrorCode;
import com.mycompany.mypizza.dto.Notice;
import com.mycompany.mypizza.dto.Page;



public interface NoticeService {

	List<Notice> selectList(Page page);
	Notice selectOne(int n_num);
	ErrorCode insert(Notice notice) throws Exception;
	ErrorCode update(Notice notice) throws Exception;
	ErrorCode delete(int n_num) throws Exception;
	
	//조회수+1
	int updateReadCnt(int bnum);
	
	
}

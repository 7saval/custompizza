package com.mycompany.mypizza.repository;

import java.util.List;
import java.util.Map;

import com.mycompany.mypizza.dto.Notice;


public interface NoticeRepository {
	
	int insert(Notice notice);
	int update(Notice noice);
	int delete(int n_num);
	Notice selectOne(int n_num);
	List<Notice> selectList(Map<String,String> map);
	

}

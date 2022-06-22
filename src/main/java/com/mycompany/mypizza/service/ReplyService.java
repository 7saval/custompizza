package com.mycompany.mypizza.service;

import java.util.List;

import com.mycompany.mypizza.dto.Reply;

public interface ReplyService {
	
	int insert(Reply reply);

	List<Reply> selectList(int bnum);

	int delete(int rnum);

	int update(Reply reply);
	

}

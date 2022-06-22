package com.mycompany.mypizza.repository;

import java.util.List;

import com.mycompany.mypizza.dto.Reply;

//댓글 
public interface ReplyRepository {
	int insert(Reply reply);
	int update(Reply reply);
	int delete(int rnum);
	Reply selectOne(int rnum);
	List<Reply> selectList(int bnum);
	
	/* 글순서 재수정 */
	int updateRestep(Reply reply);
}

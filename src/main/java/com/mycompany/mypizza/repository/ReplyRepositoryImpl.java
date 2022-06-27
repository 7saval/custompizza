package com.mycompany.mypizza.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.mypizza.dto.Reply;

@Repository
public class ReplyRepositoryImpl implements ReplyRepository {

	
	@Autowired
	private SqlSession sqlSession; 

	@Override
	public int insert(Reply reply) {
		return sqlSession.insert("com.mycompany.mypizza.ReplyMapper.insert", reply);
	}

	@Override
	public int update(Reply reply) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.mycompany.mypizza.ReplyMapper.update", reply);
	}

	@Override
	public int delete(int rnum) {
		// TODO Auto-generated method stub
		return sqlSession.delete("com.mycompany.mypizza.ReplyMapper.delete", rnum);
	}

	@Override
	public Reply selectOne(int rnum) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.mycompany.mypizza.ReplyMapper.selectOne", rnum);
	}

	@Override
	public List<Reply> selectList(int bnum) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("com.mycompany.mypizza.ReplyMapper.selectList", bnum);
	}

	@Override
	public int updateRestep(Reply reply) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.mycompany.mypizza.ReplyMapper.updateRestep", reply);
	}

	
}

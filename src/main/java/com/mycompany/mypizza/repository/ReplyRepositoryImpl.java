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
		return sqlSession.insert("com.company.mypizza.ReplyMapper.insert", reply);
	}

	@Override
	public int update(Reply reply) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.company.mypizza.ReplyMapper.update", reply);
	}

	@Override
	public int delete(int rnum) {
		// TODO Auto-generated method stub
		return sqlSession.delete("com.company.mypizza.ReplyMapper.delete", rnum);
	}

	@Override
	public Reply selectOne(int rnum) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.company.mypizza.ReplyMapper.selectOne", rnum);
	}

	@Override
	public List<Reply> selectList(int bnum) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("com.company.mypizza.ReplyMapper.selectList", bnum);
	}

	@Override
	public int updateRestep(Reply reply) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.company.mypizza.ReplyMapper.updateRestep", reply);
	}

	
}

package com.mycompany.mypizza.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.mypizza.dto.Board;
import com.mycompany.mypizza.dto.Page;

@Repository
public class BoardRepositoryImpl implements BoardRepository {
	
	@Autowired
	private SqlSession sqlSession;
	

	@Override
	public int insert(Board board) {
		// TODO Auto-generated method stub
		return sqlSession.insert("com.mycompany.mypizza.BoardMapper.insert",board);
	}

	@Override
	public int update(Board board) {
		// TODO Auto-generated method stub
		return  sqlSession.update("com.mycompany.mypizza.BoardMapper.update", board);
	}

	@Override
	public int delete(int bnum) {
		// TODO Auto-generated method stub
		return sqlSession.delete("com.mycompany.mypizza.BoardMapper.delete", bnum);
	}

	@Override
	public Board selectOne(int bnum) {
		return sqlSession.selectOne("com.mycompany.mypizza.BoardMapper.selectOne", bnum);
	}

	@Override
	public List<Board> selectList(Page page) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("com.mycompany.mypizza.BoardMapper.selectList", page);
	}

	@Override
	public int selectTotalCnt(Page page) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.mycompany.mypizza.BoardMapper.selectTotalCnt", page);
	}

	@Override
	public int updateReadCnt(int bnum) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.mycompany.mypizza.BoardMapper.updateReadCnt", bnum);
	}

	@Override
	public int updateLikeCnt(int bnum) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.mycompany.mypizza.BoardMapper.updateLikeCnt", bnum);
	}

	@Override
	public int updateDisLikeCnt(int bnum) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.mycompany.mypizza.BoardMapper.updateDisLikeCnt", bnum);
	}

}

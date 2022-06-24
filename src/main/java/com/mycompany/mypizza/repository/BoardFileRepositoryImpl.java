package com.mycompany.mypizza.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.mypizza.dto.BoardFile;

@Repository
public class BoardFileRepositoryImpl  implements BoardFileRepository{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(BoardFile boardFile) {
		
		return sqlSession.insert("com.mycompany.mypizza.BoardFileMapper.insert", boardFile);
	}

	@Override
	public int update(BoardFile boardFile) {
	
		return sqlSession.insert("com.mycompany.mypizza.BoardFileMapper.insert", boardFile);
	}

	@Override
	public int delete(int bfnum) {
		
		return sqlSession.delete("com.mycompany.mypizza.BoardFileMapper.delete", bfnum);
	}

	@Override
	public BoardFile selectOne(int bfnum) {
		
		return sqlSession.selectOne("com.mycompany.mypizza.BoardFileMapper.selectOne", bfnum);
	}

	@Override
	public List<BoardFile> selectList(int bnum) {
		
		return sqlSession.selectList("com.mycompany.mypizza.BoardFileMapper.selectList", bnum);
	}

	@Override
	public int deleteAll(int bnum) {
		return sqlSession.delete("com.mycompany.mypizza.BoardFileMapper.deleteAll", bnum);
	}

}

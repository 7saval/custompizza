package com.mycompany.mypizza.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.mypizza.dto.Notice;
import com.mycompany.mypizza.dto.Page;

@Repository
public class NoticeRepositoryImpl implements NoticeRepository {
	
	@Autowired
	private SqlSession sqlSession; 
	@Override
	public int insert(Notice notice) {
		// TODO Auto-generated method stub
		return sqlSession.insert("com.mycompany.mypizza.NoticeMapper.insert",notice);
	}

	@Override
	public int update(Notice notice) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.mycompany.mypizza.NoticeMapper.update",notice);
	}

	@Override
	public int delete(int n_num) {
		// TODO Auto-generated method stub
		return sqlSession.delete("com.mycompany.mypizza.NoticeMapper.delete",n_num);
	}

	@Override
	public Notice selectOne(int n_num) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.mycompany.mypizza.NoticeMapper.selectOne",n_num);
	}

	@Override
	public List<Notice> selectList(Page page) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("com.mycompany.mypizza.NoticeMapper.selectList",page);
	}

	@Override
	public int updateReadCnt(int n_num) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.mycompany.mypizza.NoticeMapper.updateReadCnt",n_num);
	}

	@Override
	public int selectTotalCnt(Page page) {
		return sqlSession.selectOne("com.mycompany.mypizza.NoticeMapper.selectTotalCnt",page);
	}

}

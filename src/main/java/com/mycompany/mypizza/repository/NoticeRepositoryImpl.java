package com.mycompany.mypizza.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.mypizza.dto.Notice;

@Repository
public class NoticeRepositoryImpl implements NoticeRepository {
	
	@Autowired
	private SqlSession sqlSession; 
	@Override
	public int insert(Notice notice) {
		// TODO Auto-generated method stub
		return sqlSession.insert("com.mycompany.mypizza.dto.Notice.insert",notice);
	}

	@Override
	public int update(Notice noice) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.mycompany.mypizza.dto.Notice.update",noice);
	}

	@Override
	public int delete(int n_num) {
		// TODO Auto-generated method stub
		return sqlSession.delete("com.mycompany.mypizza.dto.Notice.delete",n_num);
	}

	@Override
	public Notice selectOne(int n_num) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.mycompany.mypizza.dto.Notice.selectOne",n_num);
	}

	@Override
	public List<Notice> selectList(Map<String, String> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("com.mycompany.mypizza.dto.Notice.selectList",map);
	}

}

package com.mycompany.mypizza.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginRepositoryImpl implements LoginRepository{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public String selectId(String username) {
		return sqlSession.selectOne("com.mycompany.mypizza.LoginMapper.selectId", username);
	}

}

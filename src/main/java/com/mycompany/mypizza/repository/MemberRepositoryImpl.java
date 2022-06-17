package com.mycompany.mypizza.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.mypizza.dto.Member;

@Repository
public class MemberRepositoryImpl implements MemberRepository {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(Member member) {
		return sqlSession.insert("com.mycompany.mypizza.MemberMapper.insert", member);
	}

	@Override
	public int update(Member member) {
		return sqlSession.update("com.mycompany.mypizza.MemberMapper.update", member);
	}

	@Override
	public int delete(String email) {
		return sqlSession.delete("com.mycompany.mypizza.MemberMapper.delete", email);
	}

	@Override
	public int update_emailauth(String email) {
		return sqlSession.update("com.mycompany.mypizza.MemberMapper.update_emailauth", email);
	}

	@Override
	public Member selectOne(String email) {
		return sqlSession.selectOne("com.mycompany.mypizza.MemberMapper.selectOne", email);
	}
	
	@Override
	public int insert_simplejoin(Member member) {
		//간편가입
		return sqlSession.insert("com.mycompany.mypizza.MemberMapper.insert_simplejoin", member);
	}
}

package com.mycompany.mypizza.repository;

import com.mycompany.mypizza.dto.Member;

public interface MemberRepository {
	int insert(Member member);
	int update(Member member);
	int delete(String email);
	int update_emailauth(String email);
	Member selectOne(String email);
	int insert_simplejoin(Member member);
	
}
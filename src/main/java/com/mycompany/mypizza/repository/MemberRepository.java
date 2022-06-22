package com.mycompany.mypizza.repository;

import java.util.List;
import java.util.Map;

import com.mycompany.mypizza.dto.Member;

public interface MemberRepository {
	int insert(Member member);
	int update(Member member);
	int delete(String email);
	int update_emailauth(String email);
	Member selectOne(String email);
	List<Member> selectList(Map<String, String> map);
	int insert_simplejoin(Member member);
	
}
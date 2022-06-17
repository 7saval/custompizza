package com.mycompany.mypizza.service;

import java.util.Map;

import com.mycompany.mypizza.dto.Member;

public interface MemberService {
	
	Map<String, Object> insert(Member member, String path) throws Exception;
	void update_emailauth(String email);
}

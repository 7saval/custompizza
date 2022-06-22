package com.mycompany.mypizza.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.mycompany.mypizza.advice.ErrorCode;
import com.mycompany.mypizza.dto.Member;

public interface MemberService {

	ErrorCode insert(Member member,HttpSession session, String path) throws Exception;
	
	void update_emailauth(String email);

	Member selectOne(String email);

	ErrorCode update(Member member, String newPasswd) throws Exception;
	
}
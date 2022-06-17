package com.mycompany.mypizza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mycompany.mypizza.advice.ErrorCode;
import com.mycompany.mypizza.dto.Member;
import com.mycompany.mypizza.repository.MemberRepository;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	//암호화 객체
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public ErrorCode loginCheck(String email, String passwd) {
		//code, msg
		//0 : 로그인 완료
		//1 : 이메일 미존재
		//2 : 비밀번호 불일치
		//3 : 이메일 미인증
		
		//한건 조회
		Member member = memberRepository.selectOne(email);
		//1)이메일이 없다면
		if(member == null) {
			return ErrorCode.ERROR_LOGIN_EMAIL;
		}
		//2)비밀번호
		//평문과 암호문을 비교(평문, 암호문)
		boolean match = bCryptPasswordEncoder.matches(passwd, member.getPasswd());
		if(!match) {
			return ErrorCode.ERROR_LOGIN_PASSWD;
		}
		//3)이메일 인증 체크
		if(!member.getEmailauth().equals("1")) {
			return ErrorCode.ERROR_LOGIN_EMAILAUTH;
		}
		//성공
		return ErrorCode.SUCCESS_LOGIN;
	}

}

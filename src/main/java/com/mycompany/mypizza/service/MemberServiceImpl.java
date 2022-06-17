package com.mycompany.mypizza.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.mypizza.dto.Member;
import com.mycompany.mypizza.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Autowired
	private MemberRepository memberRepository;
	
	//파일 저장 경로(root-context.xml)
	/*
	 * @Autowired private String savedir;
	 */
	
	//비밀번호 암호화
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//이메일 전송
	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	@Transactional //트랜잭션을 메소드단위로 제어(commit, rollback을 스프링이 관리)
	public Map<String, Object> insert(Member member, String path) throws Exception {
		//return : 0 정상, 1:중복아이디
		Map<String, Object> rmap = new HashMap<>();
		
		//1)중복이메일 체크
				Member dbmember = memberRepository.selectOne(member.getEmail());
				if (dbmember != null) {
					rmap.put("code", 1);
					rmap.put("msg", "이미 등록된 아이디");
					return rmap;
				}
				//3)비밀번호 암호화
				String cryptPasswd =  bCryptPasswordEncoder.encode(member.getPasswd());
				member.setPasswd(cryptPasswd);
				
				//4)저장
				int cnt = memberRepository.insert(member);
				
				//5)이메일전송
				String authCode = sendAuthMail(member.getEmail(), path);
				
				rmap.put("code", 0); //성공
				rmap.put("msg", "이메일 인증 진행해 주세요!");
				rmap.put("authCode", authCode); //이메일 인증번호
				return rmap;
	}
	
	//인증번호 램덤으로 6자리 만들기
	private String getAuthCode() {
		StringBuffer authCode = new StringBuffer();
		Random random = new Random();
		for(int i=0; i< 6; i++)
			authCode.append(random.nextInt(10)) ; //0~9사이의 정수
			
		return authCode.toString();
	}
	//이메일전송하고 인증번호를 리턴
	private String sendAuthMail(String email, String path) throws MessagingException {
		//6자리 인증번호
		String authCode = getAuthCode();
		
		//보낼 이메일 내용
		StringBuffer content = new StringBuffer();
		content.append(email + "님 반갑습니다. 아래링크를 클릭해 주세요<br> ");
		content.append("<a href='http://localhost:8081"+path+"/member/emailConfirm?authCode="+authCode+"&email="+email+"'>이메일인증확인</a>");
		
		//보낼메일 메시지 객체 생성
		MimeMessage message = mailSender.createMimeMessage();

		message.setSubject("회원가입 이메일 인증", "utf-8");
		message.setText(content.toString(), "utf-8", "html");
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
				
		//메일보내기
		mailSender.send(message);
					
		return authCode;
	}

	@Override
	public void update_emailauth(String email) {
		// 이메일 인증
		int cnt = memberRepository.update_emailauth(email);
		logger.info(cnt+"건 이메일 인증 수정");
		
	}

}

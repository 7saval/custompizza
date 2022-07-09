package com.mycompany.mypizza.service;

import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.mypizza.advice.ErrorCode;
import com.mycompany.mypizza.dto.Member;
import com.mycompany.mypizza.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

	@Autowired
	private MemberRepository memberRepository;

	// 파일 저장 경로(root-context.xml)
	/*
	 * @Autowired private String savedir;
	 */

	// 비밀번호 암호화
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	// 이메일 전송
	@Autowired
	private JavaMailSender mailSender;

	@Override
	@Transactional 
	public ErrorCode insert(Member member, HttpSession session, String path) throws Exception {

		// 1)중복이메일 체크
		Member dbmember = memberRepository.selectOne(member.getEmail());
		if (dbmember != null) {
			return ErrorCode.ERROR_MEMBER_EMAILEXIST;
		}
		// 3)비밀번호 암호화
		String cryptPasswd = bCryptPasswordEncoder.encode(member.getPasswd());
		member.setPasswd(cryptPasswd);

		// 4)저장
		int cnt = memberRepository.insert(member);

		// 5)이메일전송
		String authCode = sendAuthMail(member.getEmail(), path);

		session.setMaxInactiveInterval(60 * 60 * 2);
		session.setAttribute("authCode", authCode);// 이메일 인증번호

		return ErrorCode.ERROR_MEMBER_EMAILAUTH;
	}

	// 인증번호 램덤으로 6자리 만들기
	private String getAuthCode() {
		StringBuffer authCode = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < 6; i++)
			authCode.append(random.nextInt(10)); // 0~9사이의 정수

		return authCode.toString();
	}

	// 이메일전송하고 인증번호를 리턴
	private String sendAuthMail(String email, String path) throws MessagingException {
		// 6자리 인증번호
		String authCode = getAuthCode();

		// 보낼 이메일 내용
		StringBuffer content = new StringBuffer();
		content.append(email + "님 반갑습니다. 아래링크를 클릭해 주세요<br> ");

//		content.append("<a href='http://localhost:8081" + path + "/member/emailConfirm?authCode=" + authCode + "&email="
//				+ email + "'>이메일인증확인</a>"); 
		content.append("<a href='http://118.67.131.101:8080" + path + "/member/emailConfirm?authCode=" + authCode + "&email="
				+ email + "'>이메일인증확인</a>");	//실서버용

		// 보낼메일 메시지 객체 생성
		MimeMessage message = mailSender.createMimeMessage();

		message.setSubject("회원가입 이메일 인증", "utf-8");
		message.setText(content.toString(), "utf-8", "html");
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

		// 메일보내기
		mailSender.send(message);

		return authCode;
	}

	@Override
	public void update_emailauth(String email) {
		// 이메일 인증
		int cnt = memberRepository.update_emailauth(email);

	}

	@Override
	public Member selectOne(String email) {
		// TODO Auto-generated method stub
		return memberRepository.selectOne(email);
	}

	@Override
	public ErrorCode update(Member member, String newPasswd) throws Exception {
		// 한건 조회
		Member dbmember = memberRepository.selectOne(member.getEmail());
		// 1)기존비밀번호
		// 평문과 암호문을 비교(평문, 암호문)
		boolean match = bCryptPasswordEncoder.matches(member.getPasswd(), dbmember.getPasswd());
		if (!match) {
			return ErrorCode.ERROR_LOGIN_PASSWD;
		}
		// 2)새로운 비밀번호 암호화
		String cryptPasswd;
		if (!newPasswd.equals(""))
			cryptPasswd = bCryptPasswordEncoder.encode(newPasswd);
		else // 기존비밀번호 암호화
			cryptPasswd = bCryptPasswordEncoder.encode(member.getPasswd());

		member.setPasswd(cryptPasswd);
		// 3)저장
		memberRepository.update(member);
		return ErrorCode.SUCCESS_MODIFY;
	}
	
	@Override
	public ErrorCode delete(String email) throws Exception {
		memberRepository.delete(email);
		return ErrorCode.SUCCESS_REMOVE;
	}
	
}

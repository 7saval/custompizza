package com.mycompany.mypizza.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycompany.mypizza.advice.ErrorCode;
import com.mycompany.mypizza.dto.Member;
import com.mycompany.mypizza.repository.MemberRepositoryImpl;
import com.mycompany.mypizza.service.MemberService;
import com.mycompany.mypizza.service.MemberServiceImpl;

@Controller
@RequestMapping("member")
public class MemberController {

	@Autowired
	private MemberService memberService;

	// 가입폼으로 이동
	@GetMapping("join")
	public void join() {

	}

	// 가입버튼을 클릭시
	@PostMapping("join")
	public String join(@ModelAttribute Member member, Model model, RedirectAttributes rattr, HttpSession session,
			HttpServletRequest request) throws Exception {

		ErrorCode errorCode = memberService.insert(member, session, request.getContextPath());
		rattr.addFlashAttribute("msg", errorCode.getMsg());

		return "redirect:/"; // 홈으로 이동
	}

	// emailConfirm 처리
	// 메소드(http://localhost:8081/myapp/member/emailConfirm?authCode=046732)
	@GetMapping("emailConfirm")
	public String emailConfirm(@RequestParam String authCode, @RequestParam String email, HttpSession session,
			RedirectAttributes rattr) {
		// 세션의 authCode와 파라메터의 authCode가 일치여부
		String authCode_s = (String) session.getAttribute("authCode");
		System.out.println("세션의인증코드:" + authCode_s);
		if (authCode.equals(authCode_s)) {
			// db의 emailauth를 1로 변경
			memberService.update_emailauth(email);

			// redirect 리스트로 이동
			rattr.addFlashAttribute("msg", ErrorCode.SUCCESS_EMAILAUTH.getMsg());
		} else {
			rattr.addFlashAttribute("msg", ErrorCode.ERROR_EMAILAUTH.getMsg());
		}

		return "redirect:/"; // 홈으로 이동
	}

	@GetMapping("list")
	public void list() {
		//
	}

	// 주소를 호출
	@GetMapping("jusoPopup")
	public void jusoPopup() {
		// member/jusoPopup.jsp호출
	}

	// 주소검색후 callback
	@PostMapping("jusoPopup")
	public void jusoPopup(@RequestParam Map<String, String> jusomap, Model model) {
		model.addAttribute("jusomap", jusomap);
	}

	// 가입정보
	@GetMapping("info")
	public String info(HttpSession session, Model model) {
		String email = (String) session.getAttribute("email");
		// 한건조회
		Member member = memberService.selectOne(email);

		// forward방식 : 주소변경안됨, member + info.jsp =>response
		model.addAttribute("member", member);

		return "member/info";

	}

	// 회원정보수정
	@GetMapping("modify")
	public void modify(HttpSession session, Model model) {
		String email = (String) session.getAttribute("email");
		model.addAttribute("member", memberService.selectOne(email));
	}

	// 회원 수정 버튼 눌렀을때
	@PostMapping("modify")
	public String modify(Member member, String newPasswd, RedirectAttributes rattr, Model model) throws Exception {
		ErrorCode errorCode = memberService.update(member, newPasswd);
		if (errorCode.getCode() != 0) { // 실패시
			model.addAttribute("msg", errorCode.getMsg());
			return "member/modify";
		} else { // 성공시 info
			rattr.addFlashAttribute("msg", errorCode.getMsg());
			return "redirect:info";
		}
	}
	
	//삭제
	@GetMapping("remove")
	public String remove(@RequestParam String email,HttpSession session ,RedirectAttributes rattr) throws Exception {
		ErrorCode errorCode = memberService.delete(email);
		rattr.addFlashAttribute("msg", errorCode.getMsg());
		session.invalidate();
		return "redirect:/";
	}
	
	
	
	
}

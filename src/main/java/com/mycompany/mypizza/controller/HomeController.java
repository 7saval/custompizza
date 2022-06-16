package com.mycompany.mypizza.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

	//홈으로 이동
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	//로그인 폼으로 이동
	@GetMapping("login")
	public void login(HttpSession session,HttpServletRequest request, Model model) {
		
	}
	
	//로그인 버튼 클릭 시
	@PostMapping("login")
	public String login(@RequestParam String email, @RequestParam String passwd,
			RedirectAttributes rattr, HttpSession session) {
		//성공이면 홈 아니면 login으로 이동
		return "";
	}
	
	//로그아웃
	@GetMapping("logout")
	public String logout(HttpSession session, RedirectAttributes rattr) {
		//세션지우기
		session.invalidate();
		return "redirect:login";
	}
	//네이버 간편가입
//	1)네이버 로그인 요청(GET:로그인창으로 이동)
//	2)callback주소로 code, state 받기
//	3)code,state를 이용해서 access_token 얻기(회원정보 얻기위해서)
//	4)access_token를 이용해서 개인회원정보 요청
//	5)개인회원정보 저장
	
	//네이버 콜백 주소
	//code://네이버에서 만들어준 코드(정보제공동의)
	@GetMapping("naverCallback")
	public String naverCallback(@RequestParam String code, @RequestParam String state,
			HttpSession session, HttpServletRequest request, RedirectAttributes rattr) {
		return "";
	}
	
}

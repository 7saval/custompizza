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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycompany.mypizza.advice.ErrorCode;
import com.mycompany.mypizza.dto.OrderSession;
import com.mycompany.mypizza.service.LoginService;
import com.mycompany.mypizza.service.NaverService;

@Controller
@SessionAttributes("order") //세션에 담을 변수
public class HomeController {

	@Autowired
	private NaverService naverService;
	
	@Autowired
	private LoginService loginService;
	
	//세션을 생성
//	@GetMapping("/")
//	public String home(OrderSession order, Model model) {
//		model.addAttribute("order", order); //세션에 객체 할당
//		return "redirect:home";
//	}

	//홈으로 이동
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	//로그인 폼으로 이동
	@GetMapping("login")
	public void login(HttpSession session,HttpServletRequest request,OrderSession order,  Model model) throws Exception {
		//네이버 간편 가입 위해서 apiURL(네이버로그인 위해 이동할 주소) 얻기
		Map<String, String> rmap = naverService.getApiUrl(request.getContextPath());
		//세션에 state넣기(callback메소드에서 인증하기 위해서)
		session.setAttribute("state", rmap.get("state"));
		//jsp에 보내기
		model.addAttribute("apiURL", rmap.get("apiURL"));
		
		model.addAttribute("order", order); //세션에 객체 할당
	}
	
	//로그인 버튼 클릭 시
	@PostMapping("login")
	public String login(@RequestParam String email, @RequestParam String passwd,
			RedirectAttributes rattr, HttpSession session) {
		ErrorCode errorCode = loginService.loginCheck(email, passwd);
		rattr.addFlashAttribute("msg", errorCode.getMsg());
		//성공이면 홈 아니면 login으로 이동
		if(errorCode.getCode()==0) {//성공
			session.setAttribute("email", email);

			return "redirect:/";
		}
		return "redirect:login";
	}
	
	//로그아웃
	@GetMapping("logout")
	public String logout(HttpSession session, RedirectAttributes rattr, SessionStatus sessionStatus) {
		//오더세션 지우기
//		order.setDetails(null);
//		order.setOrder_master(null);
		
		//로그아웃 시 장바구니 지울 때
		//sessionStatus.setComplete();

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
			HttpSession session, HttpServletRequest request, RedirectAttributes rattr) throws Exception {
		//세션의 state와 파라메터의 인증키(state)가 일치한다면 정상 사용자
		String state_s = (String) session.getAttribute("state");
		if(state_s != null && state.equals(state_s)) {
			ErrorCode errorCode = naverService.naverLogin(code, state, request.getContextPath(), session);
			rattr.addFlashAttribute("msg", errorCode.getMsg());
			//code가 0이면 session에 email넣고 redirect방식 home으로 이동
			if(errorCode.getCode()==0) {
				return "redirect:/"; //컨트롤러 호출
			}
			//아니면(실패) redirect방식 login.jsp로 이동
			return "redirect:login"; //컨트롤러 호출
		}else {
			//state_s이 null이거나 state_s가 일치하지 않는다면
			rattr.addFlashAttribute("msg", ErrorCode.ERROR_NAVER_EMAILAUTH.getMsg());
			return "redirect:login";
		}
		
	}		
	
	//아이디찾기 폼 이동
	@GetMapping("findId")
	public void findId() {
		
	}
	
	//아이디찾기 버튼 클릭 시
	@PostMapping("findId")
	public String findId(@RequestParam String username, RedirectAttributes rattr) {		
		rattr.addFlashAttribute("msg", loginService.findId(username));
		return "redirect:login";
	}
	
	//매장정보(map)
	@GetMapping("store")
	public void store() {
		
	}
	
	
}

package com.mycompany.mypizza.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member")
public class MemberController {
	//가입폼으로 이동
	@GetMapping("join")
	public void join() {
		
	}
	
	//가입정보
	@GetMapping("info")
	public void info() {
		
	}

}

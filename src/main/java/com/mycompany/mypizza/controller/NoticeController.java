package com.mycompany.mypizza.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("notice")
public class NoticeController {
	@GetMapping("/")
	public String listhome(RedirectAttributes rattr) {
		
		return "redirect:/notice/list";
	}
	
	@GetMapping("list")
	public void list() {
		
	}

}

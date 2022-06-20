package com.mycompany.mypizza.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("order")
public class OrderController {
	
	@GetMapping("pizzamake")
	public void pizzamake() {
		
	}

}

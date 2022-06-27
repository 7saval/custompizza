package com.mycompany.mypizza.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mycompany.mypizza.dto.Lowoption;
import com.mycompany.mypizza.dto.OrderSession;
import com.mycompany.mypizza.dto.Order_detail;
import com.mycompany.mypizza.dto.Order_master;
import com.mycompany.mypizza.service.OrderService;

@Controller
@RequestMapping("order")
@SessionAttributes("order") //세션에 담을 변수
public class OrderController {
	@Autowired
	OrderService orderService;
	
	//pizzamake view (주문화면)으로 들어가기
	@GetMapping("/")
	public String gopizzamake(OrderSession order, Model model) { //세션객체생성(빈객체)
		List<Lowoption> olist = orderService.selectList_option(); 
		
		//세션에 객체할당
		model.addAttribute("order",order);
		
		//옵션리스트 view에 뿌리기
		model.addAttribute("olist",olist);
	

		return "/order/pizzamake";
	}
	
	//pizzamake에서 <주문> 버튼 눌렀을때 
	@PostMapping("pizzamake")
	public String pizzamake(@ModelAttribute("order")OrderSession order, Model model) {
		/* System.out.println(order); */


		//ordersession에 details(List<Order_detail>)담고 cart로 이동
		return "/order/cart";
	}

	
	//cart view (장바구니 화면)으로 들어가기
	@GetMapping("cart")
	public String gocart(OrderSession order, Model model) {
		model.addAttribute("order",order);	//세션에 객체 할당
		
		return "/order/cart";
	}
	
	
	//cart view에서 <결제> 버튼 눌렀을때
	@PostMapping("pay")
	public String cart(@ModelAttribute("order")OrderSession order, Model model, HttpSession session) {
		Order_master test = order.getOrder_master();
		String email = (String) session.getAttribute("email");
		
		test.setEmail(email);
		
		order.setOrder_master(test);
		orderService.insert_order(order);  //db에 저장
		
		Order_master master = orderService.selectOne_master(order, order.getOrder_master().getOrder_no());
		List<Order_detail> dlist =  orderService.selectList_detail(order, order.getOrder_master().getOrder_no());
		
		
		model.addAttribute("master",master);

		model.addAttribute("dlist", dlist);
		return "/order/payinfo";
	}
}

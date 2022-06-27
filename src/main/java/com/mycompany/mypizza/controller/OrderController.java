package com.mycompany.mypizza.controller;

import java.lang.ProcessBuilder.Redirect;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycompany.mypizza.dto.Lowoption;
import com.mycompany.mypizza.dto.OrderSession;
import com.mycompany.mypizza.dto.Order_detail;
import com.mycompany.mypizza.dto.Order_master;
import com.mycompany.mypizza.dto.Page;
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
	public String gocart(@ModelAttribute("order")OrderSession order, Model model) {
		//model.addAttribute("order",order);	//세션에 객체 할당
		
		return "/order/cart";
	}
	
	
	//cart view에서 <결제> 버튼 눌렀을때
	@PostMapping("pay")
	public String cart(@ModelAttribute("order")OrderSession order, HttpSession session, 
			RedirectAttributes rattr) {
		String email = (String) session.getAttribute("email");
		//order(session)에 email 세팅
		Order_master order_master = order.getOrder_master();
		order_master.setEmail(email);
		order.setOrder_master(order_master);

		orderService.insert_order(order);  //db에 저장
		
		rattr.addAttribute("order_no", order.getOrder_master().getOrder_no());

		return "redirect:payinfo"; //payinfo 호출
	}

	@GetMapping("payinfo")
	public String goPayinfo(int order_no, Model model) {
		Order_master master = orderService.selectOne_master(order_no);
		List<Order_detail> dlist =  orderService.selectList_detail(order_no);

		model.addAttribute("master",master);
		model.addAttribute("dlist", dlist);
		
		return "/order/payinfo";
	}
	
	
	//장바구니에 아무것도 없을때
	@GetMapping("cart_nosession")
	public void cart_nosession() {
	}
	
	


}

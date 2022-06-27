package com.mycompany.mypizza.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycompany.mypizza.advice.ErrorCode;
import com.mycompany.mypizza.dto.Notice;
import com.mycompany.mypizza.dto.Page;
import com.mycompany.mypizza.service.BoardService;
import com.mycompany.mypizza.service.NoticeService;

@Controller
@RequestMapping("notice")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private BoardService boardService;
	

	@GetMapping("/")
	public String listhome(Page page, Model model, RedirectAttributes rattr) { //2)page객체 생성
		//세션에 객체를 할당하기 위한 목적(@SessionAttributes이 존재시 session생성)
		model.addAttribute("page", page); //3)세션에 할당
		// redirect방식 controller를 재호출
		return "redirect:/notice/list";		
	}
	
	@GetMapping("list")
	public void list(@ModelAttribute("page") Page page, Model model) {
		model.addAttribute("nlist", noticeService.selectList(page));
	
	}
	

	@GetMapping("add")
	public void add() {
		//추가페이지이동		
	}
	
	//추가
	@PostMapping("add")
	public String add(Notice notice, HttpServletRequest request, RedirectAttributes rattr) throws Exception {
	
		ErrorCode errorCode =  noticeService.insert(notice);
		//board/ 로 이동해서 session page생성
		rattr.addFlashAttribute("msg", errorCode.getMsg());
		return "redirect:/notice/";
		
	}
	//상세조회 폼으로 이동
	@GetMapping("detail")
	public void detail(@RequestParam int n_num, Notice notice, Model model) {
		//조회수+1
		noticeService.updateReadCnt(n_num);
		//게시물 한건 조회
		model.addAttribute("notice", noticeService.selectOne(n_num));
	}
	
	//수정폼으로 이동
	@GetMapping("modify")
	public void modify(@RequestParam int n_num, Model model) {
		model.addAttribute("notice", noticeService.selectOne(n_num));
	}
	
	//수정버튼을 클릭했을때 
	//required = false :데이터가 없을때도 있다
	@PostMapping("modify")
	public String modify(Notice notice, 
			HttpServletRequest request,
			RedirectAttributes rattr) throws Exception {
		
		ErrorCode errorCode = noticeService.update(notice);
		
		//redirect방식, detail로 이동
		rattr.addFlashAttribute("msg", errorCode.getMsg()); //한번만 실행 파라메터
		rattr.addAttribute("n_num", notice.getN_num()); //url에 포함
		
		return "redirect:detail";
	}
	
	//삭제
	@GetMapping("remove")
	public String remove(@RequestParam int n_num, RedirectAttributes rattr) throws Exception {
		ErrorCode errorCode = noticeService.delete(n_num);
		rattr.addFlashAttribute("msg", errorCode.getMsg());
		return "redirect:/notice/list";
	}
	
	
	
	
	
}

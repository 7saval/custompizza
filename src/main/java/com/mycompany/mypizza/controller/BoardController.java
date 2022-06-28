package com.mycompany.mypizza.controller;

import java.util.List;

import javax.mail.Multipart;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycompany.mypizza.advice.ErrorCode;
import com.mycompany.mypizza.dto.Board;
import com.mycompany.mypizza.dto.BoardFile;
import com.mycompany.mypizza.dto.Page;
import com.mycompany.mypizza.service.BoardFileService;
import com.mycompany.mypizza.service.BoardService;

@Controller
@RequestMapping("board")
@SessionAttributes("page")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	@Autowired
	private BoardFileService boardFileService;

	@GetMapping("/")
	public String listhome(Page page, Model model, RedirectAttributes rattr) { //2)page객체 생성
		//세션에 객체를 할당하기 위한 목적(@SessionAttributes이 존재시 session생성)
		model.addAttribute("page", page); //3)세션에 할당
		// redirect방식 controller를 재호출
		return "redirect:/board/list";
		
	}
	
	@GetMapping("list")
	public void list(@ModelAttribute("page") Page page, Model model) {
		model.addAttribute("blist", boardService.selectList(page));
		//@ModelAttribute :뷰까지 전달
		//model.addAttribute("page", page); //서비스에서 page 계산
		// WEB-INF/views/board/list.jsp로 이동
		
	}

	@GetMapping("add")
	public void add() {
		//추가페이지이동		
	}
	
	//추가
	@PostMapping("add")
	public String add(Board board, HttpServletRequest request, RedirectAttributes rattr) throws Exception {
		//클라이언트 ip
		//board.setIp(request.getRemoteAddr());
		ErrorCode errorCode =  boardService.insert(board);
		
		//board/ 로 이동해서 session page생성
		rattr.addFlashAttribute("msg", errorCode.getMsg());
		
		return "redirect:/board/";
		
	}
	//상세조회 폼으로 이동
	@GetMapping("detail")
	public void detail(@RequestParam int bnum, Model model, Board board) {
		//조회수+1
		boardService.updateReadCnt(bnum);
		//게시물 한건 조회
		model.addAttribute("board", boardService.selectOne(bnum));
		//게시물 파일들 조회
		model.addAttribute("bflist", boardFileService.selectList(bnum));
	}
	
	//수정폼으로 이동
	@GetMapping("modify")
	public void modify(@RequestParam int bnum, Model model) {
		//1)게시물 조회
		model.addAttribute("board", boardService.selectOne(bnum));
		//2)게시물파일들 조회
		model.addAttribute("bflist", boardFileService.selectList(bnum));
		
		//board/modify.jsp로 이동
	}
	
	//수정버튼을 클릭했을때 
	//required = false :데이터가 없을때도 있다
	@PostMapping("modify")
	public String modify(Board board, 
			@RequestParam(required = false) List<Integer> removeFiles,
			HttpServletRequest request,RedirectAttributes rattr) throws Exception {
		//사용자의 ip
		//board.setIp(request.getRemoteAddr());
		
		ErrorCode errorCode = boardService.update(board, removeFiles);
		
		//redirect방식, detail로 이동
		rattr.addFlashAttribute("msg", errorCode.getMsg()); //한번만 실행 파라메터
		rattr.addAttribute("bnum", board.getBnum()); //url에 포함
		
		return "redirect:detail";
	}
	
	//삭제
	@GetMapping("remove")
	public String remove(@RequestParam int bnum, RedirectAttributes rattr) throws Exception {
		boardFileService.deleteAll(bnum);
		ErrorCode errorCode = boardService.delete(bnum);
		rattr.addFlashAttribute("msg", errorCode.getMsg());
		return "redirect:/board/list";
	}
	
	//좋아요+1
	@ResponseBody
	@PutMapping("like/{bnum}")
	public String likecnt(@PathVariable int bnum) {
		boardService.updateLikeCnt(bnum);
		Board board = boardService.selectOne(bnum);
		//좋아요를 문자로 변경후 리턴
		return String.valueOf(board.getLikecnt());
	}
	
	//싫어요+1
	@ResponseBody
	@PutMapping("dislike/{bnum}")
	public String dislikecnt(@PathVariable int bnum) {
		boardService.updateDisLikeCnt(bnum);
		Board board = boardService.selectOne(bnum);
		return String.valueOf(board.getDislikecnt());
	}
	
	
	
	
	
	
	
	

	
	
	
	
	
}
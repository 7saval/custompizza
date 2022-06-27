package com.mycompany.mypizza.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.mypizza.dto.Reply;
import com.mycompany.mypizza.service.ReplyService;

@RestController //레스트풀 사용하겠다.
@RequestMapping("reply")
public class ReplyController {
	
	@Autowired
	private ReplyService replyService;
	
	//댓글추가
	@PostMapping("/") //인서트(생성)
	//@RequestBody : json형태의 값을 바인딩
	public String add(@RequestBody Reply reply, HttpServletRequest request) {
		reply.setIp(request.getRemoteAddr());
		replyService.insert(reply);
		return "add success";
	}
	
	//댓글의 리스트
	@GetMapping("list/{bnum}") //조회
	public List<Reply> list(@PathVariable int bnum){
		List<Reply> rlist = replyService.selectList(bnum);
		return rlist;
	}
	
	//댓글삭제
	//@PathVariable : 받아온 url값을 읽겠다
	//리턴값 한글패치 : produces = "application/text;charset=utf-8"
	@DeleteMapping(value = "{rnum}", produces = "application/text;charset=utf-8")
	public String delete(@PathVariable int rnum) {
		replyService.delete(rnum);
		return "삭제 완료";
	}
	
	//댓글수정
	//@RequestBody : json형태의 값을 바인딩
	@PutMapping(value="/", produces="aplication/text;charset=utf-8") //수정
	public String modify(@RequestBody Reply reply, HttpServletRequest request) {
		reply.setIp(request.getRemoteAddr());
		replyService.update(reply);
		return "수정 완료";
	}
	
	

}

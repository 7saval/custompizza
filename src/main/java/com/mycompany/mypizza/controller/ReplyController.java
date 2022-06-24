package com.mycompany.mypizza.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

}

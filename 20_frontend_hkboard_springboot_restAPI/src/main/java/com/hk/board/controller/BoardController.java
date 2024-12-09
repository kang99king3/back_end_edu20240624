package com.hk.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

	@GetMapping("/")
	public String home() {
		System.out.println("HOME 페이지입니다.");
		return "home";
	}
	
	@GetMapping("/board")
	public String board() {
		System.out.println("게시판 페이지입니다.");
		return "board/boardList2";
	}
}






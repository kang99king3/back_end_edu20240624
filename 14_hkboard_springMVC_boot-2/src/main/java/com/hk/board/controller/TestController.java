package com.hk.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TestController {

	@GetMapping("/")
	public String getMethodName() {
		return "thymeleaf/home";
	}
	
}

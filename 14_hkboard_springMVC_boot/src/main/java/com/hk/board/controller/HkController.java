package com.hk.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HkController {

	@GetMapping(value="/")
	public String getMethodName() {
		return "index";
	}
	
}

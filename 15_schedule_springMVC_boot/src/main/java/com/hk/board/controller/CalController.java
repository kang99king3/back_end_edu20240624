package com.hk.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CalController {
	
	@GetMapping("/")
	public String getMethodName() {
		return "index";//  "/templates/index.html"
	}
	
}

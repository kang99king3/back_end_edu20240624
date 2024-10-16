package com.hk.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/schedule")  // client에서 /schedule 요청
public class CalController {
	
	//log를 원하는 위치에 설정해서 디버깅 하기
	Logger logger=LoggerFactory.getLogger(getClass());
	
	@GetMapping("/")
	public String getMethodName() {
		return "index";//  "/templates/index.html"
	}
	
	@GetMapping("/calendar")    // client에서 /schedule/calendar 요청
	public String calendar() {
		logger.info("달력보기");
		return "calboard/calendar";
	}
	
	
}





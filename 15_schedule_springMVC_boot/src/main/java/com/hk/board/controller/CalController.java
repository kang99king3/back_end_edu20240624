package com.hk.board.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hk.board.service.CalServiceImp;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/schedule")  // client에서 /schedule 요청
public class CalController {
	
	//log를 원하는 위치에 설정해서 디버깅 하기
	Logger logger=LoggerFactory.getLogger(getClass());
	
	@Autowired
	private CalServiceImp calService;
	
	@GetMapping("/")
	public String getMethodName() {
		return "index";//  "/templates/index.html"
	}
	
	@GetMapping("/calendar")    // client에서 /schedule/calendar 요청
	public String calendar(Model model,String year, String month) {
		logger.info("달력보기");
		
		Map<String, Integer> map = calService.makeCalendar(year, month);
		model.addAttribute("calMap", map);
		
		return "calboard/calendar";
	}
	
	@GetMapping("/addcalboardform")
	public String addcalboardform() {
		
		return "calboard/addcalboardform";
	}
	
	
	
}





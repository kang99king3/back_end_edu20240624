package com.hk.board.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hk.board.command.InsertCalCommand;
import com.hk.board.service.CalServiceImp;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




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
	public String calendar(Model model,HttpServletRequest request) {
		logger.info("달력보기");
		String year=request.getParameter("year");
		String month=request.getParameter("month");
		Map<String, Integer> map = calService.makeCalendar(year, month);
		model.addAttribute("calMap", map);
		
		return "calboard/calendar";
	}
	
	//일정추가 폼이동
	@GetMapping("/addcalboardform")
	public String addcalboardform(Model model,
								  InsertCalCommand insertCalCommand) {
		                        //입력폼 요청시에도 command객체를 보내야함
		model.addAttribute("insertCalCommand", insertCalCommand);
		
		return "calboard/addcalboardform";
	}
	
	//일정 추가하기
	//유효값처리: @Validated - 유효값처리에 사용할 객체에 선언
	//          BindingResult - 유효값처리 후 결과를 받아줄 객체
	@PostMapping("/addcalboard")
	public String addcalboard(@Validated InsertCalCommand insertCalCommand,
			                  BindingResult result) {
		//유효값처리 결과를 받아 에러가 있는지 확인
		if(result.hasErrors()) {
			System.out.println("글을 모두 입력해야 함");
			return "calboard/addcalboardform";// 요청했던 페이지로 다시 이동
		}
		
		// 일정추가하기 실행 코드 작성
//		calService.insertBoard(insertCalCommand);
		return "redirect:/schedule/calendar";
	}
	
	
}





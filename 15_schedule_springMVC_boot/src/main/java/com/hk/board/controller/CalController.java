package com.hk.board.controller;

import java.util.HashMap;
import java.util.List;
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

import com.hk.board.command.DeleteCalCommand;
import com.hk.board.command.InsertCalCommand;
import com.hk.board.dtos.CalDto;
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
		calService.insertCalBoard(insertCalCommand);
		
		return "redirect:/schedule/calendar?year="+insertCalCommand.getYear()
												  +"&month="+insertCalCommand.getMonth();
	}
	
	//일정목록보기
	@GetMapping("/calboardlist")
	//                     year,month --> Map["year":"2024,"month":"10"]
	public String calboardlist(Model model,
							  @RequestParam Map<String, String> map) {
		
		
		
		String id="hk";//회원관리시 사용될 ID <-- 나중에는 세션에서 가져와야 함
		List<CalDto>list=calService.calBoardList(id, map);
		
		model.addAttribute("list", list);
		
		//일정 목록 페이지에서 유효값처리를 위해 command객체를 사용하고 있어서 
		//비어있는 객체라도 보내줘야 한다.
		model.addAttribute("deleteCalCommand", new DeleteCalCommand());
		             
		return "calboard/calboardlist";
	}
	
	@PostMapping("/calmuldel")
	public String calmuldel(@Validated DeleteCalCommand deleteCalCommand
			                ,BindingResult result
			                ,Model model) {
		
		if(result.hasErrors()) {
			System.out.println("최소 하나 이상 체크해야 함");
			
			//일정목록페이지로 돌아 갈경우 List객체가 필요함
			String id="hk";
	
			Map<String,String>map=new HashMap<>();
			map.put("year", "2024");
			map.put("month", "10");
			map.put("date", "18");
			
			List<CalDto>list=calService.calBoardList(id, map);
			model.addAttribute("list", list);
			
			return "calboard/calboardlist";
		}
		
		calService.calMulDel(deleteCalCommand.getSeq());
		
		//수정했어요
		return "redirect:/schedule/calboardlist?year=2024&month=10&date=18";
	}
	
	
	
	
}











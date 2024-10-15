package com.hk.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hk.board.dtos.HkDto;
import com.hk.board.service.HkServiceImp;

@Controller
@RequestMapping(value = "/thboard")
public class ThController {

	@Autowired  // spring컨테이너가 hkServiceImp객체를 생성해서 주입해줌
	private HkServiceImp hkServiceImp;
	
	//요청 url : localhost:9090/thboard/home 요청했을때 실행
	@GetMapping("/home")
	public String home() {
		
		//thymeleaf 템플릿 리졸버가 동작함
		return "thymeleaf/home";
	}
	
	@GetMapping("/boardlist")
	public String boardList(Model model) {
		List<HkDto> list=hkServiceImp.getAllList();
		model.addAttribute("list", list);
		return "thymeleaf/boardlist";
	}
	
	@GetMapping("/insertboardform")
	public String insertboardform(Model model) {
		
		return "thymeleaf/insertboardform";
	}
	
	@PostMapping("/insertboard")
	public String insertboard(Model model,HkDto dto) {
		System.out.println(dto);
		boolean isS=hkServiceImp.insertBoard(dto);
		if(isS) {
			return "redirect:/thboard/boardlist";
		}else {
			return "error";
		}
	}
}




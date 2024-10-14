package com.hk.board.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hk.board.dtos.HkDto;
import com.hk.board.service.HkServiceImp;

@Controller
public class HkController {

	Logger logger =LoggerFactory.getLogger(getClass());
	
	@Autowired
	private HkServiceImp hkServiceImp;
	
	@GetMapping(value="/")
	public String getMethodName() {
		logger.info("index페이지");
		return "index";
	}
	
	//글목록조회
	@GetMapping("/boardlist")
	public String boardList(Model model) {
		
		logger.info("글목록조회");
		
		List<HkDto> list=hkServiceImp.getAllList();
		
		model.addAttribute("list", list);
		return "boardlist";
	}
	//글상세조회
	
	//글추가폼이동
	@GetMapping("/insertboardform.do")
	public String insertboardform() {
		return "insertboardform";
	}
	
	@PostMapping(value="/insertboard.do")
	public String insertboard(HkDto dto,
			Model model) {
		
		System.out.println("aaa");
		boolean isS=hkServiceImp.insertBoard(dto);
		
		if(isS) {
			return "redirect:boardlist";
		}else {
			model.addAttribute("msg", "글등록실패");
			return "error";
		}
		
	}
	
	//글수정
	
	//글삭제
	
}

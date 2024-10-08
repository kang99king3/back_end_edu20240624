package com.hk.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hk.board.dtos.AnswerDto;
import com.hk.board.service.IAnsService;

@Controller
public class AnsController {

	@Autowired
	private IAnsService ansService;
	
	@RequestMapping(value = "/home.do"
				  ,method = RequestMethod.GET)
	public String home() {
		System.out.println("HOME 페이지로 이동");
		return "home";
	}
	
	@RequestMapping(value = "/boardlist.do"
			      ,method = RequestMethod.GET)
	public String boardList(Model model, String pnum) {
		
		List<AnswerDto> list=ansService.getAllList(pnum);
		model.addAttribute("list", list);
		
		return "boardlist";
	}
}






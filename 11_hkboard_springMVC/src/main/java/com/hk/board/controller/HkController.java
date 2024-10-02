package com.hk.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hk.board.daos.IHkDao;
import com.hk.board.dtos.HkDto;
import com.hk.board.service.IHkService;

@Controller
public class HkController {
	
	@Autowired
	private IHkService hkService;
	
	//command확인 X
	
	@RequestMapping(value = "/boardlist.do",method = RequestMethod.GET)
	public String boardList(Model model) {
		System.out.println("글목록 요청");
		List<HkDto> list=hkService.getAllList();
		
//		request.setAttribute("list",list)와 같은 기능
		model.addAttribute("list", list);
		
		//viewResolver객체가 실행시켜줌
		return "boardlist";//페이지 이름만 써준다.
//		return "redirect:boardlist.do";//redirect 방식
	}
}








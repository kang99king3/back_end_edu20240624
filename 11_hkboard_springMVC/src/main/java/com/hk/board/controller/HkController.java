package com.hk.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	//글추가폼이동
	@RequestMapping(value = "/insertboardform.do"
			      ,method = RequestMethod.GET)
	public String insertBoardForm() {
		System.out.println("글추가폼이동");
		//redirect로 응답하면 페이지를 못찾아줌
//		return "redirect:insertboardform";(X)
		return "insertboardform";//viewResolver객체 실행
	}
	
	//글추가
	@RequestMapping(value="/insertBoard.do",method=RequestMethod.POST)
//	@RequestMapping(value="/insertBoard.do") //get또는 post방식 모두 적용
	
	//restAPI 구현 URL 맵핑방법
//	@GetMapping("/insertBoard.do") // 조회를 요청
//	@PostMapping("/insertBoard.do")// insert 요청
//	@PutMapping("/insertBoard.do")// update요청
//	@DeleteMapping("/insertBoard.do")// delete요청
	public String insertBoard(Model model,HkDto dto) {
		//전달된 파라미터를 메서드의 파라미터변수로 받을 수 있다.
		System.out.println(dto);
		
		boolean isS=hkService.insertBoard(dto);
		
		if(isS) {
			return "redirect:boardlist.do";// "WEB-IN/views/boardList.do.jsp"->404
		}else {
			model.addAttribute("msg", "글추가실패");
			return "error";// return "페이지이름"; --> viewResolver가 실행됨			
		}
	}
	
	//상세보기
}








package com.hk.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hk.board.daos.IHkDao;
import com.hk.board.dtos.HkDto;
import com.hk.board.service.IHkService;

@Controller
//class에 url맵핑 추가할 수 있음 board/boardlist.do
//@RequestMapping(value = "/board")  
public class HkController {
	
	@Autowired
	private IHkService hkService;
	
	//command확인 X
	
	public String login(HttpServletRequest request) {
		HkDto ldto=new HkDto();
		//세션객체 구하기
		HttpSession session=request.getSession();
		session.getAttribute("ldto");
		session.setAttribute("ldto", ldto);
		return "";
	}
	
	
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
	@RequestMapping(value="/insertboard.do",method=RequestMethod.POST)
//	@RequestMapping(value="/insertboard.do") //get또는 post방식 모두 적용
	
	//restAPI 구현 URL 맵핑방법
//	@GetMapping("/insertBoard.do") // 조회를 요청
//	@PostMapping("/insertBoard.do")// insert 요청
//	@PutMapping("/insertBoard.do")// update요청
//	@DeleteMapping("/insertBoard.do")// delete요청
	public String insertBoard(Model model, HkDto dto
							 ,HttpServletRequest request) {
		//전달된 파라미터를 메서드의 파라미터변수로 받을 수 있다.
//		request.getParameter("id");
//		request.getParameter("title");
//		request.getParameter("content");//생략가능
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
	@RequestMapping(value = "/boarddetail.do",method = RequestMethod.GET)
	public String getBoard(Model model, int seq) {
		System.out.println("글 상세조회");
		
		HkDto dto=hkService.getBoard(seq);
		
		model.addAttribute("dto", dto);
		
		return "boarddetail";
	}
	
	//수정폼이동
	@RequestMapping(value = "/boardupdateform.do",method = RequestMethod.GET)
	public String updateBoardForm(Model model, int seq) {
		System.out.println("글 수정폼 이동");
		
		HkDto dto=hkService.getBoard(seq);
		
		model.addAttribute("dto", dto);
		
		return "boardupdateform";
	}
	
	//수정하기
	@RequestMapping(value = "/boardupdate.do",method = RequestMethod.POST)
	public String updateBoard(Model model, HkDto dto) {
		System.out.println("글 수정하기");
		
		boolean isS=hkService.updateBoard(dto);
		if(isS) {
			return "redirect:boarddetail.do?seq="+dto.getSeq();
		}else {
			model.addAttribute("msg", "수정실패");
			return "error";
		}
	}
	
	//삭제하기
	//{RequestMethod.POST,RequestMethod.GET}: post,get 모두 처리 가능
	@RequestMapping(value = "/muldel.do",
			       method = {RequestMethod.POST,RequestMethod.GET})
	public String mulDel(Model model, HkDto dto
			                 ,String[] chk) {  // 배열로 받을 수 있다.
		// chk={1,2,3,4,5,7}
//		String[] chks=request.getParameterValues("chk");
		
		System.out.println("글 삭제하기");
		
		boolean isS=hkService.mulDel(chk);
		if(isS) {
			return "redirect:boardlist.do";
		}else {
			model.addAttribute("msg", "삭제실패");
			return "error";
		}
	}
}








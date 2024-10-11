package com.hk.board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hk.board.util.Paging;
import com.hk.board.dtos.AnswerDto;
import com.hk.board.service.IAnsService;
import org.springframework.web.bind.annotation.RequestParam;


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
	public String boardList(Model model, String pnum,
			               HttpServletRequest request) {
		
		//-- 현재 요청한 페이지 번호 유지를 위한 코드----
		//session 스코프객체 이용--> request 객체로부터 얻어온다.
		//session객체가 개인 장바구니 개념
		HttpSession session=request.getSession();
		if(pnum==null) {
			pnum=(String)session.getAttribute("pnum");
		}else {
//			HttpSession session2=new HttpSession();(X)
			session.setAttribute("pnum", pnum);
		}
		
		List<AnswerDto> list=ansService.getAllList(pnum);
		model.addAttribute("list", list);
		
		//페이지수
		int pcount=ansService.getPCount();
		model.addAttribute("pcount", pcount);
		
		//-----페이지에 페이징 처리 기능을 추가하자
		//필요한 값: pcount(페이지개수), pnum(요청 페이지번호), 페이지범위(페이지수)
		Map<String, Integer> map=Paging.pagingValue(pcount, pnum, 5);
		model.addAttribute("pMap", map);
		
		return "boardlist";
	}
	
	//상세보기
	@RequestMapping(value = "/boarddetail.do", method = RequestMethod.GET)
	public String getBoard(Model model, String seq,String review) {//파라미터는 메서드에 파라미터변수로 받을 수 있음
		
		if(review!=null&&review.equals("y")) {
			ansService.readCount(Integer.parseInt(seq));//조회수 업데이트
			//review값이 y이면 sendRedirect로 seq값만 전송되도록 재요청한다.
			//그럼 글목록에서 상세조회 요청했을때만 조회수가 증가한다.
			return "redirect:boarddetail.do?seq="+seq;
		}else {
			AnswerDto dto = ansService.getBoard(seq);
			model.addAttribute("dto", dto);
			return "detailboard";//viewResolver객체가 페이지를 찾아준다.: forward방식
		}
		
	}
	
	@RequestMapping(value="/replyboard.do", method=RequestMethod.POST)
	public String replyBoard(Model model, AnswerDto dto) {
		
		boolean isS=ansService.replyBoard(dto);
		
		if(isS) {
			return "redirect:boardlist.do";
		}else {
			model.addAttribute("msg", "답글추가실패");
			return "error";
		}
	}
	
	
}
















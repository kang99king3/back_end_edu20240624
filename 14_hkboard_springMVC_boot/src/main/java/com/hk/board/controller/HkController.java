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
	
	//   value="/"(localhost:9090) 보여줄 페이지 경로
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
	@GetMapping("/boarddetail.do")
	public String boardDetail(Model model,int seq) {
		
		logger.info("글상세조회");
		
		HkDto dto=hkServiceImp.getBoard(seq);
		
		model.addAttribute("dto", dto);
		return "boarddetail";
	}
	
	//글추가폼이동
	@GetMapping("/insertboardform.do")
	public String insertboardform() {
		return "insertboardform";
	}
	
	@PostMapping(value="/insertboard.do")
	public String insertboard(HkDto dto,Model model) {
		
		System.out.println("aaa");
		boolean isS=hkServiceImp.insertBoard(dto);
		
		if(isS) {
			return "redirect:boardlist";
		}else {
			model.addAttribute("msg", "글등록실패");
			return "error";
		}
		
	}
	
	//수정폼 이동
	@GetMapping(value="/boardupdateform.do")
	public String updateboardform(int seq,
			Model model) {

		HkDto dto=hkServiceImp.getBoard(seq);
		
		model.addAttribute("dto", dto);
		
		return "boardupdateform";
	}
	
	//글수정
	@PostMapping(value="/boardupdate.do")
	public String updateBoard(HkDto dto,Model model) {

		boolean isS=hkServiceImp.updateBoard(dto);
		
		if(isS) {
			return "redirect:boarddetail.do?seq="+dto.getSeq();
		}else {
			model.addAttribute("msg", "글상세조회실패");
			return "error";
		}
		
	}
	//글삭제
	@RequestMapping(value = "muldel.do")
	public String mulDel(String[] chk,Model model) {

		boolean isS=hkServiceImp.mulDel(chk);
		
		if(isS) {
			return "redirect:boardlist";
		}else {
			model.addAttribute("msg", "글삭제실패");
			return "error";
		}
		
	}
}

package com.hk.board.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hk.board.dtos.HkDto;
import com.hk.board.dtos.HkBoardDetailDto;
import com.hk.board.dtos.HkBoardListDto;
import com.hk.board.feignmapper.BoardFeignMapper;


@Controller
@RequestMapping("/api/board")
public class BoardController {
	
	Logger logger=LoggerFactory.getLogger(getClass());
	
	@Autowired
	private BoardFeignMapper boardFeignMapper;
	
	@GetMapping("/boardlist")
	public String getBoardList(Model model) {
		HkBoardListDto dto = boardFeignMapper.getBoardList();
		logger.info("글목록 보여주기");
		model.addAttribute("list", dto.getList());
		return "board/boardlist";
	}
	
	@GetMapping("/boarddetail/{seq}")
	public String getBoard(@PathVariable("seq") int seq
			,Model model) {
		System.out.println("detail:"+seq);
		HkBoardDetailDto hkBoardDetailDto=boardFeignMapper.getBoard(seq);
		System.out.println(hkBoardDetailDto);
		System.out.println(hkBoardDetailDto.getDto());
		model.addAttribute("dto", hkBoardDetailDto.getDto());
		return "board/boarddetail";
	}
	
	@GetMapping("/updateform/{seq}")
	public String updateFrom(@PathVariable("seq") int seq
			,Model model) {
		HkBoardDetailDto hkBoardDetailDto=boardFeignMapper.getBoard(seq);
		System.out.println(hkBoardDetailDto);
		System.out.println(hkBoardDetailDto.getDto());
		model.addAttribute("dto", hkBoardDetailDto.getDto());
		return "board/updateform";
	}
	
	@PostMapping("/update")
	public String update(HkDto dto) {
		System.out.println("수정하기 파라미터:"+dto);
		boardFeignMapper.updateBoard(dto);
		
		return "redirect:/api/board/boarddetail/"+dto.getSeq();
	}
}

package com.hk.board.feignmapper;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.hk.board.dtos.HkDto;

import feign.Param;

import com.hk.board.dtos.HkBoardDetailDto;
import com.hk.board.dtos.HkBoardListDto;
import com.hk.board.dtos.HkBoardUpdateDto;

@FeignClient(name = "boardFeignMapper",url="http://localhost:8085")
public interface BoardFeignMapper {

	
	@GetMapping("/api/board/boardlist")
	//restAPI에서 json형태로 보내면 받을 때 dto형식으로 받아야 된다.
	// {"list":[dto,dto..]} json데이터형식 ---> dto로 받는다.
	//                                      HkFeignDto에가서 확인바람
	public HkBoardListDto getBoardList();
	
	@GetMapping("/api/board/detail/{seq}")
	public HkBoardDetailDto getBoard(@PathVariable("seq") int seq);

	@PutMapping("/api/board/update")
	public HkBoardUpdateDto updateBoard(@RequestBody HkDto dto);
}

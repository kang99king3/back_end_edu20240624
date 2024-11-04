package com.hk.board.dtos;

import java.util.List;

import lombok.Data;

@Data
public class HkBoardListDto {
	//restAPI에서 응답하는 값: {"list":[hkdto,hkdto,hkdto..]}
	// "list" 이름으로 배열이 저장되어 있음
	private List<HkDto> list;// [hkdto,hkdto,hkdto..] 저장됨
}

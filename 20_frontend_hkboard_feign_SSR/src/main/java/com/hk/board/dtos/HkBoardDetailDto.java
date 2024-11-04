package com.hk.board.dtos;

import lombok.Data;

@Data
public class HkBoardDetailDto {

	//restAPI에서 {"dto":{seq,id,title,content,regdate}} 전달됨
	// --> "dto"라는 이름과 동일한 맴버필드 dto에 저장됨
	private HkDto dto;
}

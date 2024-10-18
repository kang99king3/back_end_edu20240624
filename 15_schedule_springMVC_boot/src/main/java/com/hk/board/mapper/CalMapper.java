package com.hk.board.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.hk.board.dtos.CalDto;

@Mapper
public interface CalMapper {
	
	public int insertCalBoard(CalDto dto);
}





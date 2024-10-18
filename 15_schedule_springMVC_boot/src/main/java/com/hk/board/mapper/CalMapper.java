package com.hk.board.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.hk.board.dtos.CalDto;

@Mapper
public interface CalMapper {
	
	public int insertCalBoard(CalDto dto);
	public List<CalDto> calBoardList(Map<String, String> map);
	public boolean calMulDel(Map<String, String[]> map);
}











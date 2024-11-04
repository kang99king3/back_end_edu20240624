package com.hk.board.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.hk.board.dtos.HkDto;

@Mapper
public interface BoardMapper {
	public List<HkDto> getAllList();
	public HkDto getBoard(int seq);
	public int insertBoard(HkDto dto);
	public int updateBoard(HkDto dto);
	public int deleteBoard(int seq);
	public int mulDel(Map<String,String[]>map);
}








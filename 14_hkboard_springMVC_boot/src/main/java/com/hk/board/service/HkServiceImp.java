package com.hk.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.board.dtos.HkDto;
import com.hk.board.mapper.BoardMapper;

@Service
public class HkServiceImp {

	@Autowired
	private BoardMapper boardMapper;
	
	public List<HkDto> getAllList(){
		return boardMapper.getAllList();
	}
	
	public boolean insertBoard(HkDto dto) {
		return boardMapper.insertBoard(dto);
	}
}







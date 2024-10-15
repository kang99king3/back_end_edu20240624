package com.hk.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public HkDto getBoard(int seq) {
		return boardMapper.getBoard(seq);
	}
	
	public boolean updateBoard(HkDto dto) {
		return boardMapper.updateBoard(dto);
	}
	
	public boolean mulDel(String[] seq) {
		Map<String, String[]>map=new HashMap<String, String[]>();
		map.put("seqs", seq);
		return boardMapper.mulDel(map);
	}
}







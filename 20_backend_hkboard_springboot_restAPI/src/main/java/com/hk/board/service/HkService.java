package com.hk.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.board.dtos.HkDto;
import com.hk.board.mapper.BoardMapper;

@Service
public class HkService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	public List<HkDto> getAllList(){
		return boardMapper.getAllList();
	}
	public HkDto getBoard(int seq) {
		return boardMapper.getBoard(seq);
	}
	public int insertBoard(HkDto dto) {
		return boardMapper.insertBoard(dto);
	}
	public int updateBoard(HkDto dto) {
		return boardMapper.updateBoard(dto);
	}
	public int deleteBoard(int seq) {
		return deleteBoard(seq);
	}
	public int mulDel(String[] seqs) {
		Map<String, String[]>map=new HashMap<>();
		map.put("seqs", seqs);
		return boardMapper.mulDel(map);
	}
}







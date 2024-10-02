package com.hk.board.service;

import java.util.List;

import com.hk.board.dtos.HkDto;

public interface IHkService {

	public List<HkDto> getAllList();
	public boolean insertBoard(HkDto dto);
	public HkDto getBoard(int seq);
	public boolean updateBoard(HkDto dto);
	public boolean delBoard(int seq);
	public boolean mulDel(String[] chks);
}

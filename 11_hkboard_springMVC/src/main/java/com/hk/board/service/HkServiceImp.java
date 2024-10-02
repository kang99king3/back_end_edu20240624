package com.hk.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.board.daos.IHkDao;
import com.hk.board.dtos.HkDto;

@Service
public class HkServiceImp implements IHkService{

	@Autowired
	private IHkDao hkDao;
	
	@Override
	public List<HkDto> getAllList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertBoard(HkDto dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public HkDto getBoard(int seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateBoard(HkDto dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delBoard(int seq) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mulDel(String[] chks) {
		// TODO Auto-generated method stub
		return false;
	}

}

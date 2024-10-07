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
		return hkDao.getAllList();
	}

	@Override
	public boolean insertBoard(HkDto dto) {
		return hkDao.insertBoard(dto);
	}

	@Override
	public HkDto getBoard(int seq) {
		return hkDao.getBoard(seq);
	}

	@Override
	public boolean updateBoard(HkDto dto) {
		return hkDao.updateBoard(dto);
	}

	@Override
	public boolean delBoard(int seq) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mulDel(String[] chks) {
		return hkDao.mulDel(chks);
	}

}

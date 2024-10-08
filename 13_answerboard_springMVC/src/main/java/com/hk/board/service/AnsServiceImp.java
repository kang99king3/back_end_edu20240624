package com.hk.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.board.daos.IAnsDao;
import com.hk.board.dtos.AnswerDto;

@Service
public class AnsServiceImp implements IAnsService{

	@Autowired
	private IAnsDao ansDao;
	
	@Override
	public List<AnswerDto> getAllList(String pnum) {
		return ansDao.getAllList(pnum);
	}

	@Override
	public AnswerDto getBoard(String seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean insertBoard(AnswerDto dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean replyBoard(AnswerDto dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean readCount(int seq) {
		// TODO Auto-generated method stub
		return false;
	}

}

package com.hk.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
		return ansDao.getBoard(seq);
	}

	@Override
	public int getPCount() {
		return ansDao.getPCount();
	}

	@Override
	public boolean insertBoard(AnswerDto dto) {
		return ansDao.insertBoard(dto);
	}

	//transaction 처리 필요
	// - 선언적 처리 방법: 어노테이션 작성 방식
	// - AOP 처리 방법: AOP 적용 처리 방식
//	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public boolean replyBoard(AnswerDto dto) {
		ansDao.replyUpdate(dto);
		int count=ansDao.replyInsert(dto);
		return count>0?true:false;
	}

	@Override
	public boolean readCount(int seq) {
		return ansDao.readCount(seq);
	}

}

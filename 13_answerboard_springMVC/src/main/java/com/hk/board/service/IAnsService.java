package com.hk.board.service;

import java.util.List;

import com.hk.board.dtos.AnswerDto;

public interface IAnsService {
	//1.글목록 조회하기
	public List<AnswerDto> getAllList(String pnum);
	//2.글 상세조회
	public AnswerDto getBoard(String seq);
	//페이지수 구하기
	public int getPCount();
	//새글 추가하기: insert문 실행
	public boolean insertBoard(AnswerDto dto) ;
	//답글추가하기: update문, insert문 실행 --> transaction처리가 필요
	public boolean replyBoard(AnswerDto dto);
	//조회수 올리기: update문
	public boolean readCount(int seq);
}

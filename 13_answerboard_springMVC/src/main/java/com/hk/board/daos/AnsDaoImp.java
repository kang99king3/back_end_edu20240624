package com.hk.board.daos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.board.dtos.AnswerDto;

import lombok.RequiredArgsConstructor;


@Repository
@RequiredArgsConstructor
public class AnsDaoImp implements IAnsDao{

	private String namespace="com.hk.ans.";
	
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<AnswerDto> getAllList(String pnum) {
		Map<String, String>map=new HashMap<>();
		map.put("pnum", pnum);
		return sqlSession.selectList(namespace+"boardlist", map);
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

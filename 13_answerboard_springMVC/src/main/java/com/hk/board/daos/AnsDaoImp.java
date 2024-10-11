package com.hk.board.daos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.board.dtos.AnswerDto;

import lombok.RequiredArgsConstructor;


@Repository
@RequiredArgsConstructor
public class AnsDaoImp implements IAnsDao{
	
//	Logger log=LoggerFactory.getLogger(getClass());
	
	private String namespace="com.hk.ans.";
	
//	@Autowired
	private final SqlSessionTemplate sqlSession;
	
	@Override
	public List<AnswerDto> getAllList(String pnum) {
		Map<String, String>map=new HashMap<>();
		map.put("pnum", pnum);
		return sqlSession.selectList(namespace+"boardlist", map);
	}

	@Override
	public AnswerDto getBoard(String seq) {
		Map<String, String>map=new HashMap<>();
		map.put("seq", seq);
		return sqlSession.selectOne(namespace+"boardlist", map);
	}

	@Override
	public int getPCount() {
		return sqlSession.selectOne(namespace+"getpcount");
	}

	@Override
	public boolean insertBoard(AnswerDto dto) {
		int count=sqlSession.insert(namespace+"insertboard", dto);
		return count>0?true:false;
	}

	//답글추가: update, insert 2개 작업이 실행
	@Override
	public int replyUpdate(AnswerDto dto) {
		return sqlSession.update(namespace+"replyupdate", dto);
	}
	
	@Override
	public int replyInsert(AnswerDto dto) {
		return sqlSession.insert(namespace+"replyinsert", dto);
	}

	@Override
	public boolean readCount(int seq) {
		int count = sqlSession.update(namespace+"readcount", seq);
		return count>0?true:false;
	}


}

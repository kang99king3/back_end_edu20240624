package com.hk.board.daos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.board.dtos.HkDto;

@Repository
public class HkDaoImp implements IHkDao{

	private String namespace="com.hk.board.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<HkDto> getAllList() {
		return sqlSession.selectList(namespace+"boardlist");
	}

	@Override
	public boolean insertBoard(HkDto dto) {
		int count=sqlSession.insert(namespace+"insertboard", dto);
		return count>0?true:false;
	}

	@Override
	public HkDto getBoard(int seq) {
		return sqlSession.selectOne(namespace+"getboard", seq);
	}

	@Override
	public boolean updateBoard(HkDto dto) {
		int count=sqlSession.update(namespace+"updateboard", dto);
		return count>0?true:false;
	}

	@Override
	public boolean delBoard(int seq) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mulDel(String[] chks) {
		Map<String, String[]>map=new HashMap<>();
		map.put("seqs", chks);
		int count=sqlSession.delete(namespace+"muldel", map);
		return count>0?true:false;
	}

}






package com.hk.board.daos;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.board.dtos.HkDto;

@Repository
public class HkDaoImp implements IHkDao{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
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

package com.hk.board.daos;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HkDao {
	
	//DI개념
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List test() {
		return sqlSession.selectList("com.hk.board.testQuery");
	}
}






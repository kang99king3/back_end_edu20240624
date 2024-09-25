package com.hk.ans.daos;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.hk.ans.config.SqlMapConfig;
import com.hk.ans.dtos.AnswerDto;

public class AnswerDao extends SqlMapConfig{

	private String nameSpace="com.hk.ans.";
	
	//1.글목록 조회하기
	public List<AnswerDto> getAllList(){
		List<AnswerDto> list=new ArrayList<>();
		
		SqlSession sqlSession=null;//쿼리 실행을 위한 객체
		
		try {
			//sqlSession객체를 구하려면 openSession()을 통해서 얻어온다.
			//sqlSession객체를 구함: true-autocommit설정
			sqlSession=getSqlSessionFactory().openSession(true);
			list=sqlSession.selectList(nameSpace+"boardlist");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return list;
	}
}






package com.hk.board.daos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hk.board.dtos.AnswerDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"}) 
@WebAppConfiguration
public class AnsDaoImpTest {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Before
	public void beforeMethod() {
		System.out.println("before실행");
	}
	
	@Test
	public void getAllListTest() {
		Map<String, String>map=new HashMap<>();
		map.put("pnum", "1");
		
		List<AnswerDto>list=
		sqlSession.selectList("com.hk.ans.boardlist", map);
		System.out.println("글목록개수:"+list.size());
//		assertEquals(10, list.size());
//		fail("Not yet implemented");
	}
	
	@After
	public void afterMethod() {
		System.out.println("after실행");
	}
	
	
}







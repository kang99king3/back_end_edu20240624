package com.hk.board.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hk.board.daos.IAnsDao;
import com.hk.board.dtos.AnswerDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"}) 
@WebAppConfiguration
public class AnsServiceImpTest {

	@Autowired
	private IAnsDao ansDao;
	
	@Test
	public void testGetAllList() {
		List<AnswerDto> list = ansDao.getAllList("1");
		if(list==null) {
			fail("Not yet implemented");			
		}
	}

	@Test
	public void testGetBoard() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertBoard() {
		fail("Not yet implemented");
	}

	@Test
	public void testReplyBoard() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadCount() {
		fail("Not yet implemented");
	}

}

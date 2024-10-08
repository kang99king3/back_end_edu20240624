package com.hk.board.controller;

import static org.junit.Assert.*;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"}) 
@WebAppConfiguration
public class AnsControllerTest {

	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mock;//가상의 클라이언트 요청을 처리할 객체
	
	@Test
	public void testBoardList() throws Exception {
		//mock객체 생성
		this.mock=MockMvcBuilders.webAppContextSetup(wac).build();
		
		//boardlist.do 요청하기
		MvcResult result=mock.perform(
									  MockMvcRequestBuilders
				                     .get("/boardlist.do")
				                     .param("pnum", "1")
				                     )
				             .andExpect(MockMvcResultMatchers.status().isOk())
							 .andReturn();
		//처리결과내용을 받아옴
		int statusCode=result.getResponse().getStatus();
		System.out.println("status코드:"+statusCode);
		System.out.println("HttpStatus:"+HttpStatus.OK.value());
		//OK는 200코드 == 현재실행된 상태코드와 비교
		assertEquals(HttpStatus.OK.value(), statusCode);
	}

}





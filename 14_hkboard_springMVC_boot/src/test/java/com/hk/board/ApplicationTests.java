package com.hk.board;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hk.board.dtos.HkDto;
import com.hk.board.service.HkServiceImp;

//spring-boot-starter-test 라이브러리 추가시 
//               -> jUnit5가 자동으로 추가됨
@SpringBootTest
class ApplicationTests {
	
	@Autowired
	HkServiceImp hkServiceImp;
	
	@Test
	void contextLoads() {
		List<HkDto> list= hkServiceImp.getAllList();
		System.out.println(list.size());
	}
	@Test
	void insertboard() {
		boolean s=hkServiceImp.insertBoard(
				new HkDto(0,"kk","ttt","dfsfsdf",null));
		System.out.println(s);
	}
}

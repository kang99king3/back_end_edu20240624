package com.hk.board;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hk.board.dtos.HkDto;
import com.hk.board.service.HkServiceImp;

@SpringBootTest
class ApplicationTests {
	
	@Autowired
	HkServiceImp hkServiceImp;
	
	@Test
	void contextLoads() {
		List<HkDto> list= hkServiceImp.getAllList();
		System.out.println(list.size());
	}

}

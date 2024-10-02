package com.hk.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hk.board.service.IHkService;

@Controller
public class HkController {
	
	@Autowired
	private IHkService hkService;
	
}

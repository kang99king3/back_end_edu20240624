package com.hk.board.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice // @Controller 어노테이션이 적용된 곳에서 발생되는 예외를 catch함 -> Spring MVC 기능임
public class ExceptionHandle {
	
//	Logger logger=LoggerFactory.getLogger(getClass());
	
	// 실행중에 Exception이 발생하면 메서드 실행
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e,Model model) {
		log.error("Exception발생:{}",e.getMessage());
		model.addAttribute("msg", "오류가 발생하여 확인중입니다.");
		return "error";// error.html 페이지로 이동
	}
}









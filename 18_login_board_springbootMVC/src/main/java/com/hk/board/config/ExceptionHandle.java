package com.hk.board.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.spel.SpelEvaluationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandle {
	private Logger logger=LoggerFactory.getLogger(getClass());
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e, Model model) {
		logger.error("Exception 발생:{}",e.getMessage());
		model.addAttribute("msg","오류가 발생하여 확인중입니다.");
		return "error";
	}
	
	
}






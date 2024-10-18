package com.hk.board.utils;

import org.springframework.stereotype.Component;

@Component
public class Util {

	//문자열을 2자리로 변환해주는 메서드 
	public String isTwo(String str) {
		return str.length()<2?"0"+str:str;// "5" -> "05"
	}
}

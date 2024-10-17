package com.hk.board.command;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// client: 파라미터 ----> command객체가 받음
// controller -- service --> DTO --> DB
// 클라이언트에서 전달되는 파라미터와 DTO에 선언된 맴버필드가 일치하지 않음
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
public class InsertCalCommand {

	private int seq;
	@NotBlank(message = "아이디를 입력하세요") //문자열만 가능
	private String id;
	@NotBlank(message = "제목을 입력하세요") //문자열만 가능
	private String title;
	@NotBlank(message = "일정내용을 입력하세요") //문자열만 가능
	private String content;
	
	//mdate컬럼에 저장될 값 : 12자리로 조합해야 함
	private int year;
	private int month;
	private int date;
	private int hour;
	private int min;
	
	
}





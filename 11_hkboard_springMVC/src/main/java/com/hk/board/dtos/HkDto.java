package com.hk.board.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HkDto {
	
	private int seq;
	private String id;
	private String title;
	private String content;
	private Date regDate;
}




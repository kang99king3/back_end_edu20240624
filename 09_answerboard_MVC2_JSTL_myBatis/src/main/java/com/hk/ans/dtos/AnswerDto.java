package com.hk.ans.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Setter
//@Getter
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
public class AnswerDto {

	private int seq;
	private String id;
	private String title;
	private String content;
	private Date regDate;
	private int refer;
	private int step;
	private int depth;
	private String readCount;
	private String delflag;
	
	public AnswerDto() {
	
	}

	
	public AnswerDto(String id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public AnswerDto(int seq, String id, String title, String content) {
		super();
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.content = content;
	}
	
	
}





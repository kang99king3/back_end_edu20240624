package com.hk.ans.dtos;

import java.util.Date;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Setter
//@Getter
@Data
@ToString
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
	
	public AnswerDto(int seq, String id, String title, String content, Date regDate, int refer, int step, int depth,
			String readCount, String delflag) {
		super();
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.refer = refer;
		this.step = step;
		this.depth = depth;
		this.readCount = readCount;
		this.delflag = delflag;
	}

	public AnswerDto(String id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}
}





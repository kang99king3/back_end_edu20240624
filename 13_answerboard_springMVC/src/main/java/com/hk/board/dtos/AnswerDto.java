package com.hk.board.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data // getter,setter메서드 구현
@ToString
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class AnswerDto {

	@NonNull
	private int seq;
	@NonNull
	private String id;
	@NonNull
	private String title;
	@NonNull
	private String content;
	private Date regDate;
	private int refer;
	private int step;
	private int depth;
	private String readCount;
	private String delflag;
}

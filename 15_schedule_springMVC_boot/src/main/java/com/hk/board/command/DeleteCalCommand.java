package com.hk.board.command;

import java.util.Arrays;

import jakarta.validation.constraints.NotEmpty;

public class DeleteCalCommand {
	
	//null값이나 길이가 0인경우에 대해 체크
	@NotEmpty(message = "삭제하려면 최소 하나이상 체크하세요")
	private String[] seq;

	public DeleteCalCommand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeleteCalCommand(@NotEmpty(message = "삭제하려면 최소 하나이상 체크하세요") String[] seq) {
		super();
		this.seq = seq;
	}

	public String[] getSeq() {
		return seq;
	}

	public void setSeq(String[] seq) {
		this.seq = seq;
	}

	@Override
	public String toString() {
		return "DeleteCalCommand [seq=" + Arrays.toString(seq) + "]";
	}
	
	
}

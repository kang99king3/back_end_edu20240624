package com.hk.board.command;

import java.util.Arrays;
import jakarta.validation.constraints.NotEmpty;

public class DelBoardCommand {

	@NotEmpty(message = "최소 하나 이상 체크해야 합니다.")
	private String[] seq;

	public DelBoardCommand() {
		super();
		// TODO Auto-generated constructor stub
	}
 
	public DelBoardCommand(@NotEmpty(message = "최소 하나 이상 체크해야 합니다.") String[] seq) {
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
		return "DelBoardCommand [seq=" + Arrays.toString(seq) + "]";
	}
	
	
}

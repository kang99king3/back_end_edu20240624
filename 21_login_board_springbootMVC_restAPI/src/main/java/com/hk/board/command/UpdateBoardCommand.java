package com.hk.board.command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UpdateBoardCommand {


	private int board_seq;
	@NotBlank(message = "제목을 입력하세요")
	private String title;
	@NotBlank(message = "내용을 입력하세요")
	private String content;
	
	public UpdateBoardCommand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UpdateBoardCommand(@NotNull int board_seq, @NotBlank(message = "제목을 입력하세요") String title,
			@NotBlank(message = "내용을 입력하세요") String content) {
		super();
		this.board_seq = board_seq;
		this.title = title;
		this.content = content;
	}
	public int getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "UpdateBoardCommand [board_seq=" + board_seq + ", title=" + title + ", content=" + content + "]";
	}
	
}

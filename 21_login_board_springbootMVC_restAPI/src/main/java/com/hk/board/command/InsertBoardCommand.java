package com.hk.board.command;

import jakarta.validation.constraints.NotBlank;

public class InsertBoardCommand {

	private String id;
	@NotBlank(message = "제목을 입력하세요")
	private String title;
	@NotBlank(message = "내용을 입력하세요")
	private String content;
	public InsertBoardCommand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InsertBoardCommand(String id, @NotBlank(message = "제목을 입력하세요") String title,
			@NotBlank(message = "내용을 입력하세요") String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
		return "insertBoardCommand [id=" + id + ", title=" + title + ", content=" + content + "]";
	}
	
	
}

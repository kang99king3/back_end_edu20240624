package com.hk.board.dtos;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
//@Data
@Alias(value = "boardDto") //mapper.xml에서 사용하는 변수명 설정
public class BoardDto {
	private int board_seq;
	private String id;
	private String title;
	private String content;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date regdate;
	private String delflag;
	
	//Join용 맴버필드
	private List<FileBoardDto> fileBoardList;
	
	public BoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardDto(int board_seq, String id, String title, String content, Date regdate, String delflag,
			List<FileBoardDto> fileBoardList) {
		super();
		this.board_seq = board_seq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.delflag = delflag;
		this.fileBoardList = fileBoardList;
	}

	public int getBoard_seq() {
		return board_seq;
	}

	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
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

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

	public List<FileBoardDto> getFileBoardList() {
		return fileBoardList;
	}

	public void setFileBoardList(List<FileBoardDto> fileBoardList) {
		this.fileBoardList = fileBoardList;
	}

	@Override
	public String toString() {
		return "BoardDto [board_seq=" + board_seq + ", id=" + id + ", title=" + title + ", content=" + content
				+ ", regdate=" + regdate + ", delflag=" + delflag + ", fileBoardList=" + fileBoardList + "]";
	}
	
	
	
}

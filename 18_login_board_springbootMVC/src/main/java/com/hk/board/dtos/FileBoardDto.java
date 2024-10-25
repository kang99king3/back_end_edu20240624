package com.hk.board.dtos;

import org.apache.ibatis.type.Alias;

@Alias(value = "fileBoardDto")
public class FileBoardDto {

	private int file_seq;
	private int board_seq;
	private String origin_filename;
	private String stored_filename;
	
	public FileBoardDto() {
		super();
	}

	public FileBoardDto(int file_seq, int board_seq, String origin_filename, String stored_filename) {
		super();
		this.file_seq = file_seq;
		this.board_seq = board_seq;
		this.origin_filename = origin_filename;
		this.stored_filename = stored_filename;
	}

	public int getFile_seq() {
		return file_seq;
	}

	public void setFile_seq(int file_seq) {
		this.file_seq = file_seq;
	}

	public int getBoard_seq() {
		return board_seq;
	}

	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}

	public String getOrigin_filename() {
		return origin_filename;
	}

	public void setOrigin_filename(String origin_filename) {
		this.origin_filename = origin_filename;
	}

	public String getStored_filename() {
		return stored_filename;
	}

	public void setStored_filename(String stored_filename) {
		this.stored_filename = stored_filename;
	}

	@Override
	public String toString() {
		return "FileBoardDto [file_seq=" + file_seq + ", board_seq=" + board_seq + ", origin_filename="
				+ origin_filename + ", stored_filename=" + stored_filename + "]";
	}
	
}

package com.hk.board.command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// client: 파라미터 ----> command객체가 받음
// controller -- service --> DTO --> DB
// 클라이언트에서 전달되는 파라미터와 DTO에 선언된 맴버필드가 일치하지 않음
// 클라이언트에서 입력되는 값에 대해 유효값처리를 설정
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
public class UpdateCalCommand {

	private int seq;

	private String id;
	@NotBlank(message = "제목을 입력하세요") //문자열만 가능
	private String title;
	@NotBlank(message = "일정내용을 입력하세요") //문자열만 가능
	private String content;
	
	//mdate컬럼에 저장될 값 : 12자리로 조합해야 함
	@NotNull(message = "년도를 입력하세요")
	private int year;
	@NotNull(message = "월을 입력하세요")
	private int month;
	@NotNull(message = "일을 입력하세요")
	private int date;
	@NotNull(message = "시간을 입력하세요")
	private int hour;
	@NotNull(message = "분을 입력하세요")
	private int min;
	
	public void mdateToYMDHM(String mdate) {
		this.year=Integer.parseInt(mdate.substring(0, 4));
		this.month=Integer.parseInt(mdate.substring(4, 6));
		this.date=Integer.parseInt(mdate.substring(6, 8));
		this.hour=Integer.parseInt(mdate.substring(8, 10));
		this.min= Integer.parseInt(mdate.substring(10));
	}
	
	public UpdateCalCommand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UpdateCalCommand(int seq, String id,
			@NotBlank(message = "제목을 입력하세요") String title, @NotBlank(message = "일정내용을 입력하세요") String content,
			@NotNull(message = "년도를 입력하세요") int year, @NotNull(message = "월을 입력하세요") int month,
			@NotNull(message = "일을 입력하세요") int date, @NotNull(message = "시간을 입력하세요") int hour,
			@NotNull(message = "분을 입력하세요") int min) {
		super();
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.year = year;
		this.month = month;
		this.date = date;
		this.hour = hour;
		this.min = min;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	@Override
	public String toString() {
		return "InsertCalCommand [seq=" + seq + ", id=" + id + ", title=" + title + ", content=" + content + ", year="
				+ year + ", month=" + month + ", date=" + date + ", hour=" + hour + ", min=" + min + "]";
	}
	
	
}





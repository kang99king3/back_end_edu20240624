package com.hk.dtos;

import java.io.Serializable;
import java.util.Date;

//DTO객체: 데이터 운반객체--> 은닉화구현
public class HkDto implements Serializable{
//Serializable 인터페이스를 구현 -> 데이터 직렬화 "data"-> [d a t a]
// 데이터를 안정적으로 관리

	//식별 관리 아이디 
	private static final long serialVersionUID = 1L;
	
	private int seq;
	private String id;
	private String title;
	private String content;
	private Date regDate;
	
	public HkDto() {

	}

	//생성자 오버로딩: 맴버필드 초기화 작업할때 사용함
	public HkDto(int seq, String id, String title, String content, Date regDate) {
		super();
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
	}

	public HkDto(String id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
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

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "HkDto [seq=" + seq + ", id=" + id + ", title=" + title + ", content=" + content + ", regDate=" + regDate
				+ "]";
	}
	
}










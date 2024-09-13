package com.hk.dtos;

import java.io.Serializable;
import java.util.Date;

//DTO 만들기 순서
//-맴버필드 작성
//-default생성자
//-생성자 오버로딩:생성자를 통해서 필드 초기화
//-getter, setter 메서드 작성
//-toString() 오버라이딩
// 편하게 작성하기 위해 지원하는 라이브러리--> lombok 라이브러리
public class UserDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String tid;
	private String tpassword;
	private String tname;
	private String taddress;
	private String tphone;
	private String temail;
	private String tenabled;
	private String trole;
	private Date tregDate;
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDto(String tid, String tpassword, String tname, String taddress, String tphone, String temail,
			String tenabled, String trole, Date tregDate) {
		super();
		this.tid = tid;
		this.tpassword = tpassword;
		this.tname = tname;
		this.taddress = taddress;
		this.tphone = tphone;
		this.temail = temail;
		this.tenabled = tenabled;
		this.trole = trole;
		this.tregDate = tregDate;
	}
	
	public UserDto(String tid, String tpassword, String tname, String taddress, String tphone, String temail) {
		super();
		this.tid = tid;
		this.tpassword = tpassword;
		this.tname = tname;
		this.taddress = taddress;
		this.tphone = tphone;
		this.temail = temail;
	}
	
	
	public UserDto(String tid, String taddress, String tphone, String temail) {
		super();
		this.tid = tid;
		this.taddress = taddress;
		this.tphone = tphone;
		this.temail = temail;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getTpassword() {
		return tpassword;
	}
	public void setTpassword(String tpassword) {
		this.tpassword = tpassword;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTaddress() {
		return taddress;
	}
	public void setTaddress(String taddress) {
		this.taddress = taddress;
	}
	public String getTphone() {
		return tphone;
	}
	public void setTphone(String tphone) {
		this.tphone = tphone;
	}
	public String getTemail() {
		return temail;
	}
	public void setTemail(String temail) {
		this.temail = temail;
	}
	public String getTenabled() {
		return tenabled;
	}
	public void setTenabled(String tenabled) {
		this.tenabled = tenabled;
	}
	public String getTrole() {
		return trole;
	}
	public void setTrole(String trole) {
		this.trole = trole;
	}
	public Date getTregDate() {
		return tregDate;
	}
	public void setTregDate(Date tregDate) {
		this.tregDate = tregDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "UserDto [tid=" + tid + ", tpassword=" + tpassword + ", tname=" + tname + ", taddress=" + taddress
				+ ", tphone=" + tphone + ", temail=" + temail + ", tenabled=" + tenabled + ", trole=" + trole
				+ ", tregDate=" + tregDate + "]";
	}
	
}













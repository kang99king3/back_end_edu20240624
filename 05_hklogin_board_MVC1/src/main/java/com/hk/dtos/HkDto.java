package com.hk.dtos;

import java.io.Serializable;
import java.util.Date;

//DTO객체: 데이터 운반객체--> 은닉화구현
public class HkDto implements Serializable{
//Serializable 인터페이스를 구현 -> 데이터 직렬화 "data"-> [d a t a]
// 데이터를 안정적으로 관리

	//식별 관리 아이디 
	private static final long serialVersionUID = 1L;
	
	private int tseq;
	private String tid;
	private String ttitle;
	private String tcontent;
	private Date tregDate;
	private String delflag;
	
	public HkDto() {

	}

	public HkDto(int tseq, String tid, String ttitle, String tcontent, Date tregDate, String delflag) {
		super();
		this.tseq = tseq;
		this.tid = tid;
		this.ttitle = ttitle;
		this.tcontent = tcontent;
		this.tregDate = tregDate;
		this.delflag = delflag;
	}
	
	public HkDto(String tid, String ttitle, String tcontent) {
		super();
		this.tid = tid;
		this.ttitle = ttitle;
		this.tcontent = tcontent;
	}

	
	public HkDto(int tseq, String ttitle, String tcontent) {
		super();
		this.tseq = tseq;
		this.ttitle = ttitle;
		this.tcontent = tcontent;
	}

	public int getTseq() {
		return tseq;
	}

	public void setTseq(int tseq) {
		this.tseq = tseq;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getTtitle() {
		return ttitle;
	}

	public void setTtitle(String ttitle) {
		this.ttitle = ttitle;
	}

	public String getTcontent() {
		return tcontent;
	}

	public void setTcontent(String tcontent) {
		this.tcontent = tcontent;
	}

	public Date getTregDate() {
		return tregDate;
	}

	public void setTregDate(Date tregDate) {
		this.tregDate = tregDate;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "HkDto [tseq=" + tseq + ", tid=" + tid + ", ttitle=" + ttitle + ", tcontent=" + tcontent + ", tregDate="
				+ tregDate + ", delflag=" + delflag + "]";
	}

}










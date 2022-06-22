package com.mycompany.mypizza.dto;

import java.util.Date;

public class Notice {

	private int n_num; 
	private String n_subject; 
	private String n_content;
	private int n_readcnt;
	private Date n_regidate;
	private Date n_modidate;
	
	public Notice() {
		super();
	}
	public Notice(int n_num, String n_subject, String n_content, int n_readcnt, Date n_regidate, Date n_modidate) {
		super();
		this.n_num = n_num;
		this.n_subject = n_subject;
		this.n_content = n_content;
		this.n_readcnt = n_readcnt;
		this.n_regidate = n_regidate;
		this.n_modidate = n_modidate;
	}
	public int getN_num() {
		return n_num;
	}
	public void setN_num(int n_num) {
		this.n_num = n_num;
	}
	public String getN_subject() {
		return n_subject;
	}
	public void setN_subject(String n_subject) {
		this.n_subject = n_subject;
	}
	public String getN_content() {
		return n_content;
	}
	public void setN_content(String n_content) {
		this.n_content = n_content;
	}
	public int getN_readcnt() {
		return n_readcnt;
	}
	public void setN_readcnt(int n_readcnt) {
		this.n_readcnt = n_readcnt;
	}
	public Date getN_regidate() {
		return n_regidate;
	}
	public void setN_regidate(Date n_regidate) {
		this.n_regidate = n_regidate;
	}
	public Date getN_modidate() {
		return n_modidate;
	}
	public void setN_modidate(Date n_modidate) {
		this.n_modidate = n_modidate;
	}
	@Override
	public String toString() {
		return "Notice [n_num=" + n_num + ", n_subject=" + n_subject + ", n_content=" + n_content + ", n_readcnt="
				+ n_readcnt + ", n_regidate=" + n_regidate + ", n_modidate=" + n_modidate + "]";
	}
	
	
	
	
}

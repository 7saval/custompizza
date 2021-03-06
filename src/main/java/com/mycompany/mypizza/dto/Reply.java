package com.mycompany.mypizza.dto;

import java.util.Date;

public class Reply {
	private int rnum;
	private int bnum;
	private String email;
	private String content;
	private String ip;
	private int restep;
	private int relevel;
	private Date regidate;
	private Date modidate;
	public Reply() {
		super();
	}
	public Reply(int rnum, int bnum, String email, String content, String ip, int restep, int relevel, Date regidate,
			Date modidate) {
		super();
		this.rnum = rnum;
		this.bnum = bnum;
		this.email = email;
		this.content = content;
		this.ip = ip;
		this.restep = restep;
		this.relevel = relevel;
		this.regidate = regidate;
		this.modidate = modidate;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getRestep() {
		return restep;
	}
	public void setRestep(int restep) {
		this.restep = restep;
	}
	public int getRelevel() {
		return relevel;
	}
	public void setRelevel(int relevel) {
		this.relevel = relevel;
	}
	public Date getRegidate() {
		return regidate;
	}
	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}
	public Date getModidate() {
		return modidate;
	}
	public void setModidate(Date modidate) {
		this.modidate = modidate;
	}
	

	

}

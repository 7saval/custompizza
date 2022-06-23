package com.mycompany.mypizza.dto;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Board {
	
	private int bnum;
	private String email;
	private String content;
	private String subject;
	private int readcnt;
	private int likecnt;
	private int dislikecnt ;
	private Date regidate;
	private Date modidate;
	
	private List<MultipartFile> files;
	
	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

	public Board() {
		super();
	}

	public Board(int bnum, String email, String content, String subject, int readcnt, int likecnt, int dislikecnt,
			Date regidate, Date modidate) {
		super();
		this.bnum = bnum;
		this.email = email;
		this.content = content;
		this.subject = subject;
		this.readcnt = readcnt;
		this.likecnt = likecnt;
		this.dislikecnt = dislikecnt;
		this.regidate = regidate;
		this.modidate = modidate;
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getReadcnt() {
		return readcnt;
	}

	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}

	public int getLikecnt() {
		return likecnt;
	}

	public void setLikecnt(int likecnt) {
		this.likecnt = likecnt;
	}

	public int getDislikecnt() {
		return dislikecnt;
	}

	public void setDislikecnt(int dislikecnt) {
		this.dislikecnt = dislikecnt;
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

	@Override
	public String toString() {
		return "Board [bnum=" + bnum + ", email=" + email + ", content=" + content + ", subject=" + subject
				+ ", readcnt=" + readcnt + ", likecnt=" + likecnt + ", dislikecnt=" + dislikecnt + ", regidate="
				+ regidate + ", modidate=" + modidate + ", files=" + files + "]";
	}


}

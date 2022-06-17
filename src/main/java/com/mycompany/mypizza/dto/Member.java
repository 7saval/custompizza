package com.mycompany.mypizza.dto;

import java.util.Date;

public class Member {
	private String email;
	private String passwd;
	private String username; 
	private String zipcode;
	private String addrload;
	private String addrdetail;
	private String mobile;
	private String emailauth;
	private String simplejoin;
	private Date regidate;
	private Date modidate;
	
	
	public Member() {
		super();
	}
	public Member(String email, String passwd, String username, String zipcode, String addrload, String addrdetail,
			String mobile, String emailauth, String simplejoin, Date regidate, Date modidate) {
		super();
		this.email = email;
		this.passwd = passwd;
		this.username = username;
		this.zipcode = zipcode;
		this.addrload = addrload;
		this.addrdetail = addrdetail;
		this.mobile = mobile;
		this.emailauth = emailauth;
		this.simplejoin = simplejoin;
		this.regidate = regidate;
		this.modidate = modidate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddrload() {
		return addrload;
	}
	public void setAddrload(String addrload) {
		this.addrload = addrload;
	}
	public String getAddrdetail() {
		return addrdetail;
	}
	public void setAddrdetail(String addrdetail) {
		this.addrdetail = addrdetail;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmailauth() {
		return emailauth;
	}
	public void setEmailauth(String emailauth) {
		this.emailauth = emailauth;
	}
	public String getSimplejoin() {
		return simplejoin;
	}
	public void setSimplejoin(String simplejoin) {
		this.simplejoin = simplejoin;
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
		return "Member [email=" + email + ", passwd=" + passwd + ", username=" + username + ", zipcode=" + zipcode
				+ ", addrload=" + addrload + ", addrdetail=" + addrdetail + ", mobile=" + mobile + ", emailauth="
				+ emailauth + ", simplejoin=" + simplejoin + ", regidate=" + regidate + ", modidate=" + modidate + "]";
	}
	
	

}

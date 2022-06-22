package com.mycompany.mypizza.dto;

public class Lowoption {
	private String hcode;  		//#상위옵션코드(pk)(fk)
	private String lcode;  		//#하위옵션코드(pk)
	private String lname;  		//#하위옵션명
	private int price;	 	    //#가격
	private String filename;	//#이미지파일명
	
	private String hname;		//상위옵션 코드 (뷰에 뿌려주기 위해서..)

	public Lowoption() {
		super();
	}

	public Lowoption(String hcode, String lcode, String lname, int price, String filename, String hname) {
		super();
		this.hcode = hcode;
		this.lcode = lcode;
		this.lname = lname;
		this.price = price;
		this.filename = filename;
		this.hname = hname;
	}

	public String getHcode() {
		return hcode;
	}

	public void setHcode(String hcode) {
		this.hcode = hcode;
	}

	public String getLcode() {
		return lcode;
	}

	public void setLcode(String lcode) {
		this.lcode = lcode;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

	@Override
	public String toString() {
		return "Lowoption [hcode=" + hcode + ", lcode=" + lcode + ", lname=" + lname + ", price=" + price
				+ ", filename=" + filename + ", hname=" + hname + "]";
	}
	
	
	
}

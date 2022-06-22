package com.mycompany.mypizza.dto;

public class Order_detail {
	private int order_no; //주문번호
	private int detail_no; //디테일번호
	private String hcode;
	private String lcode;
	
	private String hname; 	//session에 넣기 위한 상위코드
	private String lname; 	//session에 넣기 위한 하위코드
	private int price;		//session에 넣기 위한 금액
	public Order_detail() {
		super();
	}
	public Order_detail(int order_no, int detail_no, String hcode, String lcode, String hname, String lname,
			int price) {
		super();
		this.order_no = order_no;
		this.detail_no = detail_no;
		this.hcode = hcode;
		this.lcode = lcode;
		this.hname = hname;
		this.lname = lname;
		this.price = price;
	}
	public int getOrder_no() {
		return order_no;
	}
	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
	public int getDetail_no() {
		return detail_no;
	}
	public void setDetail_no(int detail_no) {
		this.detail_no = detail_no;
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
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
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
	@Override
	public String toString() {
		return "Order_detail [order_no=" + order_no + ", detail_no=" + detail_no + ", hcode=" + hcode + ", lcode="
				+ lcode + ", hname=" + hname + ", lname=" + lname + ", price=" + price + "]";
	}
	
	
}

package com.mycompany.mypizza.dto;

import java.util.Date;

public class Order_master {
	private int order_no;
	private Date sales_date; // 판매일
	private String receipt_time; //수령시간 12:00
	private String email;
	private String store; //매장명
	private int price;  //가격 
	private int payment; //결제수단 (0:현금 1:카드 2:네이버페이)
	public Order_master(int order_no, Date sales_date, String receipt_time, String email, String store, int price,
			int payment) {
		super();
		this.order_no = order_no;
		this.sales_date = sales_date;
		this.receipt_time = receipt_time;
		this.email = email;
		this.store = store;
		this.price = price;
		this.payment = payment;
	}
	public Order_master() {
		super();
	}
	public int getOrder_no() {
		return order_no;
	}
	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
	public Date getSales_date() {
		return sales_date;
	}
	public void setSales_date(Date sales_date) {
		this.sales_date = sales_date;
	}
	public String getReceipt_time() {
		return receipt_time;
	}
	public void setReceipt_time(String receipt_time) {
		this.receipt_time = receipt_time;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	@Override
	public String toString() {
		return "Order_master [order_no=" + order_no + ", sales_date=" + sales_date + ", receipt_time=" + receipt_time
				+ ", email=" + email + ", store=" + store + ", price=" + price + ", payment=" + payment + "]";
	}

	
	
	
}

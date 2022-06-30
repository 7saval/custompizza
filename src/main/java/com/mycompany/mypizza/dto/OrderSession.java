package com.mycompany.mypizza.dto;

import java.util.List;
import java.util.Map;

public class OrderSession { //주문 세션	
	private Order_master order_master; 	//주문마스터 (정보)
	private List<Order_detail> details; //피자 디테일
	public OrderSession() {
		super();
	}
	public OrderSession(Order_master order_master, List<Order_detail> details) {
		super();
		this.order_master = order_master;
		this.details = details;
	}
	public Order_master getOrder_master() {
		return order_master;
	}
	public void setOrder_master(Order_master order_master) {
		this.order_master = order_master;
	}
	public List<Order_detail> getDetails() {
		return details;
	}
	public void setDetails(List<Order_detail> details) {
		this.details = details;
	}
	@Override
	public String toString() {
		return "OrderSession [order_master=" + order_master + ", details=" + details + "]";
	}

	
	
}

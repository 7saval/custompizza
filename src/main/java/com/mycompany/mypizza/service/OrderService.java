package com.mycompany.mypizza.service;

import java.util.List;
import java.util.Map;

import com.mycompany.mypizza.dto.Lowoption;
import com.mycompany.mypizza.dto.OrderSession;
import com.mycompany.mypizza.dto.Order_detail;
import com.mycompany.mypizza.dto.Order_master;

public interface OrderService {
	List<Lowoption> selectList_option(); //옵션 리스트 구하기
	void insert_order(OrderSession order); //세션의 order를 db에 저장
	
	Order_master selectOne_master(int order_no); //주문번호의 주문마스터
	List<Order_detail> selectList_detail(int order_no); //주문번호 하나의 detail 리스트 ( 예, 주문번호 2번의 피자디테일..)
	
	
}

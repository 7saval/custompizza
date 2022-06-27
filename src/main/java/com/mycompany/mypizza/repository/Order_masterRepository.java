package com.mycompany.mypizza.repository;

import java.util.List;
import java.util.Map;

import com.mycompany.mypizza.dto.Order_master;

public interface Order_masterRepository {
	int insert (Order_master order_master);
	int update (Order_master order_master);
	int delete (String order_no);
	Order_master selectOne_master (int order_no);
	List<Order_master> selectList (String email);
}

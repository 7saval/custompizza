package com.mycompany.mypizza.repository;

import java.util.List;

import com.mycompany.mypizza.dto.Order_detail;

public interface Order_detailRepository {
	int insert(Order_detail order_detail);
	int update(Order_detail order_detail);
	int delete(int order_no);
	List<Order_detail> selectList_detail (int order_no);
}

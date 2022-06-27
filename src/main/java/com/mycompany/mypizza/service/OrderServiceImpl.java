package com.mycompany.mypizza.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.mypizza.dto.Lowoption;
import com.mycompany.mypizza.dto.OrderSession;
import com.mycompany.mypizza.dto.Order_detail;
import com.mycompany.mypizza.dto.Order_master;
import com.mycompany.mypizza.repository.LowoptionRepository;
import com.mycompany.mypizza.repository.Order_detailRepository;
import com.mycompany.mypizza.repository.Order_masterRepository;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private LowoptionRepository lowoptionRepository;

	@Autowired
	private Order_masterRepository order_masterRepository;
	@Autowired
	private Order_detailRepository order_detailRepository;
	
	@Override
	public List<Lowoption> selectList_option() {
		//옵션리스트 구하기
		return lowoptionRepository.selectList();
	}

	@Override
	public void insert_order(OrderSession order) {
		// TODO Auto-generated method stub
		
		//order_master 넣기
		Order_master order_master = order.getOrder_master();
		order_masterRepository.insert(order_master);
		
		//order_deatail 리스트 넣기
		Order_detail order_detail= new Order_detail();
		order_detail.setOrder_no(order_master.getOrder_no()); 
		
		List<Order_detail> details = order.getDetails();
		int cnt =0;
		for(int i=0; i<details.size(); i++ ) {
			
			if(details.get(i).getLcode() == null) continue;
			
			cnt++;
			order_detail.setDetail_no(cnt);
			order_detail.setHcode(details.get(i).getHcode());
			order_detail.setLcode(details.get(i).getLcode());
			order_detail.setLname(details.get(i).getLname());
			
			System.out.println(order_detail);
			order_detailRepository.insert(order_detail);
		}

	}

	@Override
	public List<Order_detail> selectList_detail(OrderSession order, int order_no) {
		List<Order_detail> dlist = order_detailRepository.selectList_detail(order_no); //피자디테일
		return dlist;
	}

	@Override
	public Order_master selectOne_master(OrderSession order, int order_no) {
		Order_master master = order_masterRepository.selectOne_master(order_no);
		
		return master;
	}

}

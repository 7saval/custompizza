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
	/*
	 * for(MultipartFile file:files) { String filename =
	 * fileService.fileUpload(file); //파일을 저장 if (filename.equals("")) continue;
	 * //파일이름이 공백일경우 저장하지 않는다
	 * 
	 * //게시물파일db저장 BoardFile boardFile = new BoardFile();
	 * boardFile.setBnum(board.getBnum()); //게시물의 bnum세팅
	 * boardFile.setFilename(filename); boardFileRepository.insert(boardFile); }
	 */

	@Override
	public void insert_order(OrderSession order) {
		// TODO Auto-generated method stub
		
		//order_master 넣기
		Order_master order_master = order.getOrder_master();
		order_masterRepository.insert(order_master);
		
		//order_deatail 리스트 넣기
		List<Order_detail> details = order.getDetails();
		for(Order_detail order_detail : details ) {
			/*String lcode = details.lcode();*/
			
			/*
			 * if(lcode.equals(details))
			 */		}
	}

	
	
	private void detailsSave(Order_detail order_detail) {
		//Order_detail를 저장....
		
		
		
		
	}
	
	
	
	
	
	
	
	
	@Override
	public List<Order_detail> selectOne(OrderSession order, int order_no) {
		List<Order_detail> dlist = order_detailRepository.selectOne(order_no); //피자디테일
		
		Map<String, String> details = new HashMap<>();
		
		order.getDetails(); // order_detail의 list형
		
	
		//details.put("hcode", order.getDetails()???? )
		
		
		return null;
	}


	
}

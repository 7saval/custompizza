package com.mycompany.mypizza.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.mypizza.dto.Order_detail;

@Repository
public class Order_detailRepositoryImpl implements Order_detailRepository {
	@Autowired
	private SqlSession sqlsession;
	
	@Override
	public int insert(Order_detail order_detail) {
		return sqlsession.insert("com.mycompany.mypizza.Order_detailMapper.insert",order_detail);
	}

	@Override
	public int update(Order_detail order_detail) {
		return sqlsession.update("com.mycompany.mypizza.Order_detailMapper.update",order_detail);
	}

	@Override
	public int delete(int order_no) {
		return sqlsession.delete("com.mycompany.mypizza.Order_detailMapper.delete",order_no);
	}

	@Override
	public List<Order_detail> selectOne(int order_no) {
		return sqlsession.selectOne("com.mycompany.mypizza.Order_detailMapper.selectOne",order_no);
	}

	@Override
	public List<Order_detail> selectList() {
		return sqlsession.selectList("com.mycompany.mypizza.Order_detailMapper.selectList");

	}
	
}

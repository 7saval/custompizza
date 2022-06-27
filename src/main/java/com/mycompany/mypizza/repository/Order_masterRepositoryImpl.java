package com.mycompany.mypizza.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.mypizza.dto.Order_master;

@Repository
public class Order_masterRepositoryImpl implements Order_masterRepository {
	@Autowired
	private SqlSession sqlsession;
	
	@Override
	public int insert(Order_master order_master) {
		return sqlsession.insert("com.mycompany.mypizza.Order_masterMapper.insert", order_master);
	}

	@Override
	public int update(Order_master order_master) {
		return sqlsession.update("com.mycompany.mypizza.Order_masterMapper.update", order_master);

	}

	@Override
	public int delete(String order_no) {
		return sqlsession.delete("com.mycompany.mypizza.Order_masterMapper.delete", order_no);
	}

	@Override
	public Order_master selectOne_master(int order_no) {
		return sqlsession.selectOne("com.mycompany.mypizza.Order_masterMapper.selectOne", order_no);
	}

	@Override
	public List<Order_master> selectList(Map<String, String> findmap) {
		return sqlsession.selectList("com.mycompany.mypizza.Order_masterMapper.selectList", findmap);
	}

}

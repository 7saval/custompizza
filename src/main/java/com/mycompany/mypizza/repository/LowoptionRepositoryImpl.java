package com.mycompany.mypizza.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.mypizza.dto.Lowoption;

@Repository
public class LowoptionRepositoryImpl implements LowoptionRepository{
	@Autowired
	private SqlSession sqlsession;
	
	@Override
	public int insert(Lowoption lowoption) {
		return sqlsession.insert("com.mycompany.mypizza.LowoptionMapper.insert",lowoption);
	}

	@Override
	public int update(Lowoption lowoption) {
		return sqlsession.update("com.mycompany.mypizza.LowoptionMapper.update",lowoption);
	}

	@Override
	public int delete(Map<String, String> map) {
		return sqlsession.delete("com.mycompany.mypizza.LowoptionMapper.delete",map);
	}

	@Override
	public Lowoption selectOne(Map<String, String> map) {
		return sqlsession.selectOne("com.mycompany.mypizza.LowoptionMapper.selectOne",map);
	}

	@Override
	public List<Lowoption> selectList() {
		return sqlsession.selectList("com.mycompany.mypizza.LowoptionMapper.selectList");
	}


}

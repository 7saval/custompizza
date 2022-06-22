package com.mycompany.mypizza.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.mypizza.dto.Highoption;

@Repository
public class HighoptionRepositoryImpl implements HighoptionRepository {
	@Autowired
	private SqlSession sqlsession;
	
	
	@Override
	public int insert(Highoption highoption) {
		return sqlsession.insert("com.mycompany.mypizza.HighoptionMapper.insert",highoption);
	}

	@Override
	public int update(Highoption highoption) {
		return sqlsession.update("com.mycompany.mypizza.HighoptionMapper.update",highoption);
	}

	@Override
	public int delete(String hcode) {
		return sqlsession.delete("com.mycompany.mypizza.HighoptionMapper.delete",hcode);
	}

	@Override
	public Highoption selectOne(String hcdoe) {
		return sqlsession.selectOne("com.mycompany.mypizza.HighoptionMapper.selectOne",hcdoe);
	}

	@Override
	public List<Highoption> selectList() {
		return sqlsession.selectList("com.mycompany.mypizza.HighoptionMapper.selectList");
	}


}

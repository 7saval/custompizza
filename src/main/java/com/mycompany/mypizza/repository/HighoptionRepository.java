package com.mycompany.mypizza.repository;

import java.util.List;

import com.mycompany.mypizza.dto.Highoption;

public interface HighoptionRepository {
	int insert (Highoption highoption);
	int update (Highoption highoption);
	int delete (String hcode);
	Highoption selectOne(String hcdoe);
	List<Highoption> selectList();

}

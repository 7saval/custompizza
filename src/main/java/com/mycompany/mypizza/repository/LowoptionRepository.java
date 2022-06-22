package com.mycompany.mypizza.repository;

import java.util.List;
import java.util.Map;

import com.mycompany.mypizza.dto.Highoption;
import com.mycompany.mypizza.dto.Lowoption;

public interface LowoptionRepository {
	int insert (Lowoption lowoption);
	int update (Lowoption lowoption);
	int delete (Map<String, String> map);
	Lowoption selectOne(Map<String, String> map);
	List<Lowoption> selectList();
}

package com.icia.ex.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.ex.dto.ExDTO;

@Repository
public class ExDAO {
	// DAO : Data Access Object
	// DTO : Data Transfer Object
	
	@Autowired
	private SqlSessionTemplate sql;
	
	public void insert(ExDTO dto) {
		sql.insert("ex.insertDB", dto);
	}

	public List<ExDTO> select() {
		return sql.selectList("ex.selectDB");
	}

}

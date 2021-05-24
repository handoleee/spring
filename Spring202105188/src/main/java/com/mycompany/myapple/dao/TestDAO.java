package com.mycompany.myapple.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestDAO {
	@Autowired
	private SqlSessionTemplate sql;

	public void daoMethod1(String data1) {
		System.out.println("TestDAO호출");
		System.out.println(data1);
		
		sql.insert("table.insertDB",data1);
	}
}

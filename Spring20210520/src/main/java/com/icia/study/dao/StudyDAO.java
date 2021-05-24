package com.icia.study.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudyDAO {

	@Autowired
	private SqlSessionTemplate sql; // mapper부르기 위해
	
	public void insertDB(String param1) {
		sql.insert("study.insertDB", param1);
	}

	public List<String> selectDB() {
		// 넘겨주는 데이터는 없기 때문에 mapper 호출하는 부분만 작성함
		// mapper를 통해 조회한 데이터를 List에 담아서 StudyService로 리턴
		// select*from 을 쓸때는 selectList 메소드 사용
		return sql.selectList("study.selectDB");
	}

}

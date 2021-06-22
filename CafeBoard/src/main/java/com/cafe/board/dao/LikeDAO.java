package com.cafe.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe.board.dto.LikeDTO;

@Repository
public class LikeDAO {
	
	@Autowired
	private SqlSessionTemplate sql;
	
	public List<LikeDTO> likeList(String lwriter) {
		return sql.selectList("lm.likelist", lwriter);
	}

}

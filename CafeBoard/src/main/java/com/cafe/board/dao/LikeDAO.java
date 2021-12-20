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

	/*
	 * public List<LikeDTO> likeList(String lid) { return
	 * sql.selectList("lm.likelist"); }
	 */
	
	
//	public int addLikeList(LikeDTO like) {
//		return sql.insert("lm.addlikelist", like);
//	}
//	
//	public int addLikeListProcess(LikeDTO like) {
//		return sql.update("lm.addlikelistprocess", like);
//	}
	
//	public List<LikeDTO> likeList(String lid) {
//		return sql.selectList("lm.likelist", lid);
//	}
//
	public int like(LikeDTO like) {
		return sql.insert("lm.like", like);
	}

	public List<LikeDTO> likeList(String lid) {
		return sql.selectList("lm.likelist", lid);
	}

	

	

}

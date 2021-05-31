package com.icia.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.board.dto.BoardDTO;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	public int boardWrite(BoardDTO board) {
		return sql.insert("bm.boardwrite", board);
	}
	
	public List<BoardDTO> boardList() {
		return sql.selectList("bm.boardlist");
	}
	
	public BoardDTO boardView(int bnumber) {
		return sql.selectOne("bm.boardview", bnumber);
	}
	
	public void boardHits(int bnumber) {
		sql.update("bm.boardhits", bnumber);
	}
	
	public BoardDTO update(int bnumber) { 
		 return sql.selectOne("bm.boardupdate", bnumber); 
	 }

	public int updateProcess(BoardDTO board) {
		return sql.update("bm.updateprocess", board);
	}

	public int boardDelete(int bnumber) {
		return sql.delete("bm.boarddelete", bnumber);
		
	}

	public void boardWriteFile(BoardDTO board) {
		sql.insert("bm.boardwritefile", board);
	}

}

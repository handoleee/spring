package com.cafe.board.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe.board.dto.BoardDTO;
import com.cafe.board.dto.BoardPageDTO;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	public void boardWrite(BoardDTO board) {
		sql.insert("bm.boardwrite", board);
	}

	public List<BoardDTO> boardList() {
		return sql.selectList("bm.boardlist");
	}
	
	public void boardHits(int bnumber) {
		sql.update("bm.boardhits", bnumber);
	}

	public BoardDTO boardView(int bnumber) {
		return sql.selectOne("bm.boardview", bnumber);
	}

	public int listCount() {
		return sql.selectOne("bm.listcount");
	}

	public List<BoardDTO> boardPaging(BoardPageDTO paging) {
		return sql.selectList("bm.boardpaging", paging);
	}

	public int boardUpdateProcess(BoardDTO board) {
		return sql.update("bm.boardupdateprocess", board);
	}

	public int boardDelete(int bnumber) {
		return sql.delete("bm.boarddelete", bnumber);
	}

	public List<BoardDTO> boardSearch(Map<String, String> searchMap) {
		return sql.selectList("bm.boardsearch", searchMap);
	}

}

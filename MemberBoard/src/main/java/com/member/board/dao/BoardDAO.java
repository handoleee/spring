package com.member.board.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.member.board.dto.BoardDTO;
import com.member.board.dto.PageDTO;

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

	public List<BoardDTO> boardPaging(PageDTO paging) {
		return sql.selectList("bm.boardpaging", paging);
	}

	public List<BoardDTO> boardSearch(Map<String, String> searchMap) {
		System.out.println("dao search ok");
		return sql.selectList("bm.boardsearch", searchMap);	
	}

	public int boardDelete(int bnumber) {
		return sql.delete("bm.boarddelete", bnumber);
	}

	public BoardDTO update(int bnumber) { 
		 return sql.selectOne("bm.boardupdate", bnumber); 
	 }
	
	public int updateProcess(BoardDTO board) {
		System.out.println("dao.up");
		return sql.update("bm.updateprocess", board);
	}

}

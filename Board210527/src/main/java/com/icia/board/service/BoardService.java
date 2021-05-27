package com.icia.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.board.dao.BoardDAO;
import com.icia.board.dto.BoardDTO;

@Service
public class BoardService {

	@Autowired
	private BoardDAO bdao;
	
	private ModelAndView mav;
	
	public ModelAndView boardWrite(BoardDTO board) {
		mav = new ModelAndView();
		bdao.boardWrite(board);
		return mav;
	}

	public ModelAndView boardList() {
		mav = new ModelAndView();
		List<BoardDTO> boardList = bdao.boardList();
		mav.addObject("boardList", boardList);
		mav.setViewName("boardlist");
		return mav;
	}
}

package com.icia.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.icia.board.dto.BoardDTO;
import com.icia.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService bs;
	
	private ModelAndView mav;
	
	@RequestMapping(value="/bwpage")
	public String bwPage() {
		return "boardwrite";
	}
	
	@RequestMapping(value="/boardwrite")
	public ModelAndView boardWrite(@ModelAttribute BoardDTO board) {
		mav = bs.boardWrite(board);
		System.out.println(board);
		return mav;
	}
	
	@RequestMapping(value="/boardlist")
	public ModelAndView boardList() {
		mav = bs.boardList();
		return mav;
	}
	
}

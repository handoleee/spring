package com.icia.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icia.board.dto.BoardDTO;
import com.icia.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService bs;
	
	private ModelAndView mav;
	
	// 글쓰기 화면 띄우는 메소드
	@RequestMapping(value="/writepage")
	public String writePage() {
		return "boardwrite";
	}
	
	// 글쓰기 처리를 하는 메소드
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
	
	/*
	 * // 글 조회 기능
	 * 
	 * @RequestMapping(value="/boardview") public ModelAndView
	 * boardView(@RequestParam("bnumber") int bnumber) { mav =
	 * bs.boardView(bnumber); return mav; }
	 * 
	 * // 글 수정 기능
	 * 
	 * @RequestMapping(value="/boardupdate") public ModelAndView
	 * update(@RequestParam("bnumber") int bnumber) { mav = bs.update(bnumber);
	 * return mav; }
	 */
}


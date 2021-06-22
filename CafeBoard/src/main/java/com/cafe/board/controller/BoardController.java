package com.cafe.board.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cafe.board.dto.BoardDTO;
import com.cafe.board.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService bs;
	
	private ModelAndView mav;
	
	// 게시글 등록 이동
	@RequestMapping(value="/writepage")
	public String writePage() {
		return "boardwrite";
	}
	
	// 게시글 등록
	@RequestMapping(value="/boardwrite")
	public ModelAndView boardWrite(@ModelAttribute BoardDTO board) throws IllegalStateException, IOException {
		mav = bs.boardWrite(board);
		return mav;
	}
	// 게시글 목록
	@RequestMapping(value="/boardlist")
	public ModelAndView boardList(@RequestParam(value="page", required=false, defaultValue="1") int page) {
		mav = bs.boardList(page);
		return mav;
	}
	// 게시글 조회
	@RequestMapping(value="/boardview")
	public ModelAndView boardView(@RequestParam("bnumber") int bnumber,
									@RequestParam(value="page", required=false, defaultValue="1") int page) {
		mav = bs.boardView(bnumber, page); 
		return mav;
	}
	// 게시글 수정
	@RequestMapping(value="/boardupdate")
	public ModelAndView boardUpdate(@RequestParam("bnumber") int bnumber) {
		mav = bs.boardUpdate(bnumber);
		return mav;
	}
	
	// 게시글 수정 처리
	@RequestMapping(value="/boardupdateprocess")
	public ModelAndView boardUpdateProcess(@ModelAttribute BoardDTO board) {
		mav = bs.boardUpdateProcess(board);
		return mav;
	}
	// 게시글 삭제
	@RequestMapping(value="/boarddelete")
	public ModelAndView boardDelete(@RequestParam("bnumber") int bnumber) {
		mav = bs.boardDelete(bnumber);
		return mav;
	}
	
	// 게시글 검색
	@RequestMapping(value="/boardsearch")
	public ModelAndView boardSearch(@RequestParam("searchtype") String searchType,
									@RequestParam("keyword") String keyword) {
		mav = bs.boardSearch(searchType, keyword);
		return mav;
	}
}

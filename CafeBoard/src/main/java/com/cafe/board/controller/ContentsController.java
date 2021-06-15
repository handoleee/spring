package com.cafe.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cafe.board.dto.ContentsDTO;
import com.cafe.board.service.ContentsService;

@Controller
public class ContentsController {

	@Autowired 
	private ContentsService cs;
	
	private ModelAndView mav;
	
	// 메뉴 목록
	@RequestMapping(value="/contentslist")
	public ModelAndView contentsList() {
		mav = cs.contentsList();
		return mav;
	}
	
	@RequestMapping(value="/adminmenupage")
	public String adminmenuPage() {
		return "adminmenu";
	}
	// 메뉴 등록 페이지 이동(관리자)
	@RequestMapping(value="/adminmenu")
	public ModelAndView adminMenu(@ModelAttribute ContentsDTO contents) {
		mav = cs.adminMenu(contents);
		return mav;
	}
	
	// 메뉴 리스트
	@RequestMapping(value="/adminmenulist")
	public ModelAndView adminMenuList() {
		mav = cs.adminMenuList();
		return mav;
	}
	
	// 메뉴 추가
	@RequestMapping(value="/addmenu")
	public ModelAndView addmenu() {
		mav = cs.addmenu();
		return mav;
	}
	
	// 메뉴 추가 과정
	@RequestMapping(value="/addmenuprocess")
	public ModelAndView addmenuProcess(@ModelAttribute ContentsDTO contents) {
		mav = cs.addmenuProcess(contents);
		return mav;
	}
	
	// 메뉴 삭제(관리자)
	@RequestMapping(value="/adminmenudelete")
	public ModelAndView adminmenuDelete(@RequestParam("cnumber") int cnumber) {
		mav = cs.adminmenuDelete(cnumber);
		return mav;
	}
	// 
}

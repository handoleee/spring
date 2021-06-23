package com.cafe.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cafe.board.dto.BrandDTO;
import com.cafe.board.dto.ContentsDTO;
import com.cafe.board.service.ContentsService;

@Controller
public class ContentsController {

	@Autowired 
	private ContentsService cs;
	
	private ModelAndView mav;
	
	
	// 메뉴 목록
	@RequestMapping(value="/contentslist")
	public ModelAndView contentsList(@RequestParam(value="page", required=false, defaultValue="1") int page) {
		mav = cs.contentsList(page);
	
		return mav;
	}
	
	
	// 체크박스
	@RequestMapping(value="/contentslist/brandlist")
	public ModelAndView brandList(@RequestParam ContentsDTO contents) {
		mav = cs.brandList(contents);
		return mav;
	}
	// @ResponseBody @RequestParam(value="valueArrCheck[]") List<String> valueArr)
	// 메뉴 등록 페이지 이동(관리자)
	@RequestMapping(value="/adminmenupage")
	public String adminmenuPage() {
		return "adminmenu";
	}
	
//	@RequestMapping(value="/contentspaging")
//	public ModelAndView contentsPaging(@RequestParam(value="page", required=false, defaultValue="1") int page) {
//	mav = cs.contentsPaging(page);
//	return mav;
//	}
	
	// 메뉴 등록
	@RequestMapping(value="/adminmenu")
	public ModelAndView adminMenu(@ModelAttribute ContentsDTO contents) throws IllegalStateException, IOException {
		mav = cs.adminMenu(contents);
		return mav;
	}
	
	// 메뉴 수정
	@RequestMapping(value="/menuupdate")
	public ModelAndView menuUpdate(@RequestParam("cnumber") int cnumber) {
		mav = cs.menuUpdate(cnumber);
		System.out.println("content.update 컨트롤러");
		return mav;
	}
	
	// 메뉴 수정 과정
	@RequestMapping(value="/menuupdateprocess")
	public ModelAndView menuUpdateProcess(@ModelAttribute ContentsDTO contents) {
		mav = cs.menuUpdateProcess(contents);
		return mav;
	}

	// 메뉴 삭제(관리자)
	@RequestMapping(value="/menudelete")
	public ModelAndView menuDelete(@RequestParam("cnumber") int cnumber) {
		mav = cs.menuDelete(cnumber);
		return mav;
	}
	
	// 메뉴 조회
	@RequestMapping(value="/menuview")
	public ModelAndView menuView(@RequestParam("cnumber") int cnumber,
						@RequestParam(value="page", required=false, defaultValue="1") int page) {
		mav = cs.menuView(cnumber, page);
		return mav;
	}
	
	// 메뉴 검색
	@RequestMapping(value="/menusearch")
	public ModelAndView menuSearch(@RequestParam("searchtype") String searchType,
									@RequestParam("keyword") String keyword) {
		mav = cs.menuSearch(searchType, keyword);
		return mav;
	}
	
}

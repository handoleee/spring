package com.cafe.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContentsController {

	//메뉴 조회 
	@RequestMapping(value="/contentslist")
	public String contentslistPage() {
		return "contentslist";
	}
	// 메뉴 등록
	
	// 메뉴 삭제
}

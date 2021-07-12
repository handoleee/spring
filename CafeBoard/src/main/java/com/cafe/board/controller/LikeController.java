package com.cafe.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cafe.board.dto.LikeDTO;
import com.cafe.board.dto.MemberDTO;
import com.cafe.board.service.LikeService;

@Controller
public class LikeController {

	@Autowired
	private LikeService ls;
	
	private ModelAndView mav;
	
	// 찜목록 이동
	@RequestMapping(value="/likelistpage")
	public String likeListPage() {
		return "likelist";
	}
	// 찜목록
	@RequestMapping(value="/likelist")
	public ModelAndView likeList(String lid) {
		mav = ls.likeList(lid);
		return mav;
	}

//	// 장바구니 추가
//	@RequestMapping(value="/addlikelist")
//	public ModelAndView addLikeList(@ModelAttribute LikeDTO like) {
//		mav = ls.addLikeList(like);
//		return mav;
//	}
	
//	@ResponseBody
//	@RequestMapping(value="/likelist")
//	public void likeList(LikeDTO like, HttpSession Session) throws Exception {
//		MemberDTO member = (MemberDTO)session.getAttribute("member");
//		like.setLwriter(like.getLwriter());
//		LikeService.likelist(like);
//		
//	}
//	
//	@RequestMapping(value="/likelist")
//	public void ModelAndView likeList(@RequestParam()){
//		MemberDTO member = (MemberDTO)session.getAttribute("member");
//		like.setLwriter(like.getLwriter());
//		
//		return mav;
//	}
	
//	@RequestMapping(value="/addlikelist")
//	public ModelAndView addLikeList() {
//		mav = ls.addLikeList();
//		return mav;
//	}
//	
//	@RequestMapping(value="/addlikelistprocess")
//	public ModelAndView addLikeListProcess(@ModelAttribute LikeDTO like) {
//		mav = ls.addLikeListProcess(like);
//		return mav;
//	}
	

}

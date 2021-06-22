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
	
	@RequestMapping(value="/likelist")
	public ModelAndView likeList(@RequestParam("lwriter") String lwriter) {
		mav = ls.likeList(lwriter);
		return mav;
	}
}

package com.cafe.board.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.cafe.board.dao.LikeDAO;
import com.cafe.board.dto.LikeDTO;

@Service
public class LikeService {
	
	@Autowired
	private LikeDAO ldao;
	
	@Autowired
	private HttpSession session;

	private ModelAndView mav;
	
//	public ModelAndView addLikeList() {
//		mav = new ModelAndView();
//		String loginId = (String) session.getAttribute("loginMember");
//		LikeDTO addLikeList = ldao.addLikeList(loginId);
//		
//		mav.addObject("addlikelist", addLikeList);
//		mav.setViewName("addlikelist");
//		return mav;
//		
//	}
//	
//	public ModelAndView addLikeListProcess(LikeDTO like) {
//		mav = new ModelAndView();
//		int addprocess = ldao.addLikeListProcess(like);
//		if(addprocess > 0) {
//			mav.setViewName("redirect:/likelist");
//		} else {
//			mav.setViewName("redirect:/mypage");
//		}
//		return mav;
//	}
	
//	public ModelAndView likeList(String lid) {
//		mav = new ModelAndView();
//		List<LikeDTO> likeList = ldao.likeList(lid);
//		mav.addObject("likelist", likeList);
//		mav.setViewName("likelist");
//		return mav;
//	}
//
	/*
	 * public ModelAndView likeList(String lid) { mav = new ModelAndView();
	 * List<LikeDTO> likeList = new ArrayList<LikeDTO>(); likeList =
	 * ldao.likeList(lid); mav.addObject("like", likeList);
	 * 
	 * return mav; // int likeResult = 0; // likeResult = ldao.likeList(like); //
	 * if(likeResult > 0) { // mav.setViewName("redirect:/likelist?lid"); // } else
	 * { // mav.setViewName("mypage"); // } // return mav; }
	 */


//	public ModelAndView addLikeList(LikeDTO like) {
//		mav = new ModelAndView();
//		int loginId = ldao.addLikeList(like);
//		if(loginId != null) {
//			session.setAttribute("addlike", loginId);
//			mav.setViewName("redirect:/mypage");
//		} else {
//			mav.setViewName("redirect:/contentslist");
//		}
//		return mav;
//	}

	public ModelAndView like(LikeDTO like) {
		mav = new ModelAndView();
		
		int insertResult = 0;
		insertResult = ldao.like(like);
		if(insertResult > 0) {
			mav.setViewName("redirect:/contentslist");
		} else {
			mav.setViewName("home");
		}
		return mav;
	}

	public ModelAndView likeList(String lid) {
		mav = new ModelAndView();
		List<LikeDTO> likelist = ldao.likeList(lid);
		mav.addObject("likeList", likelist);
		mav.setViewName("likelist");
		return mav;
	}
}


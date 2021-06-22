package com.cafe.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.cafe.board.dao.LikeDAO;
import com.cafe.board.dto.LikeDTO;

@Service
public class LikeService {
	
	@Autowired
	private LikeDAO ldao;

	private ModelAndView mav;
	
	public ModelAndView likeList(String lwriter) {
		mav = new ModelAndView();
		List<LikeDTO> likeList = ldao.likeList(lwriter);
		mav.addObject("likeList", likeList);
		mav.setViewName("likelist");
		return mav;
	}

}


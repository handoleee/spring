package com.cafe.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.cafe.board.dao.ContentsDAO;
import com.cafe.board.dto.ContentsDTO;

@Service
public class ContentsService {

	@Autowired
	private ContentsDAO cdao;
	
	private ModelAndView mav;
	
	public ModelAndView adminMenu(ContentsDTO contents) {
		mav = new ModelAndView();
		int insertResult = 0;
		insertResult = cdao.adminMenu(contents);
		if(insertResult > 0) {
			mav.setViewName("adminmenu");
		} else {
			mav.setViewName("contentslist");
		}
		return mav;
	}

	public ModelAndView adminMenuList() {
		mav = new ModelAndView();
		List<ContentsDTO> menuList = cdao.adminMenuList();
		for(int i=0; i<menuList.size(); i++) {
			System.out.println(menuList.get(i));
		}
		mav.addObject("menulist", menuList);
		mav.setViewName("menulist");
		return mav;
	}

	public ModelAndView addmenu() {
		mav = new ModelAndView();
		ContentsDTO addMenu = cdao.addmenu();
		mav.addObject("addmenu", addMenu);
		mav.setViewName("addmenu");
		return mav;
	}

	public ModelAndView addmenuProcess(ContentsDTO contents) {
		mav = new ModelAndView();
		int updateResult = cdao.addmenuProcess(contents);
		if(updateResult > 0) {
			mav.setViewName("addmenu");
		} else {
			mav.setViewName("contentslist");
		}
		return mav;
	}

	public ModelAndView adminmenuDelete(int cnumber) {
		mav = new ModelAndView();
		cdao.adminmenuDelete(cnumber);
		mav.setViewName("redirect:/contentslist");
		return mav;
	}
	

}

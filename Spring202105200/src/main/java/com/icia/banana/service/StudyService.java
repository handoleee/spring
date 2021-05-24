package com.icia.banana.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.banana.dao.StudyDAO;

@Service
public class StudyService {

	@Autowired
	private StudyDAO sdao;
	
	private ModelAndView mav;
	
	public void insertDB(String param1) {
		sdao.insertDB(param1);
	}

	public ModelAndView selectDB() {
		mav = new ModelAndView();
		List<String> dbList = sdao.selectDB();
		
		System.out.println("dbList 확인");
		for(int i=0; i<dbList.size(); i++) {
			System.out.println(dbList.get(i));
		}
		
		mav.addObject("dbList", dbList);
		
		mav.setViewName("select");
		return mav;
	}
	
}

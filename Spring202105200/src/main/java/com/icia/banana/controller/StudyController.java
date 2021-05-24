package com.icia.banana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icia.banana.service.StudyService;

@Controller
public class StudyController {
	
	@Autowired
	private StudyService ss;
	
	private ModelAndView mav;
	
//	@RequestMapping(value="/")
//	public String homepage() {
//		return "home";
//	}

	@RequestMapping(value="/insertpage")
	public String insertPage() {
		return "insert";
	}
	
	@RequestMapping(value="/insert")
	public void insertDB(@RequestParam("param1") String param1) {
		System.out.println(param1);
		ss.insertDB(param1);
	}
	
	@RequestMapping(value="/select")
	public ModelAndView selectDB() {
		System.out.println("컨트롤러");
		mav = ss.selectDB();
		return mav;
	}
}

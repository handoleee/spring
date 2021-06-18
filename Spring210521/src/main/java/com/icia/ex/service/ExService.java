package com.icia.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.ex.dao.ExDAO;
import com.icia.ex.dto.ExDTO;

@Service
public class ExService {

	@Autowired
	private ExDAO edao;
	
	private ModelAndView mav;
	
	/*
	 * // 매개변수를 각각 전달하는 방법 public void insert1(String col1, String col2, String
	 * col3) {
	 * 
	 * }
	 */
	// dto객체에 담아서 전달하는 방법
	public void insert2(ExDTO dto) {
		edao.insert(dto);
	}
	
	public ModelAndView select() {
		mav = new ModelAndView();
		// 전체데이터를 조회할때는 List객체를 사용하며,
		// List에 저장되는 타입은 DTO타입을 사용한다.		
		List<ExDTO> dataList = edao.select();

		System.out.println("ExService.select()");
		for(int i=0; i<dataList.size(); i++) {
			System.out.println(dataList.get(i));
		}
		
		//조회결과를 select.jsp로 가지고 가기
		mav.addObject("selectList",dataList);
		mav.setViewName("select");
		
		return mav;
	}

	
	}


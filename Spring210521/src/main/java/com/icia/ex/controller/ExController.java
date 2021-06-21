package com.icia.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.icia.ex.dto.ExDTO;
import com.icia.ex.service.ExService;

@Controller
public class ExController {
	
	@Autowired
	private ExService es;
	
	private ModelAndView mav;

	@RequestMapping(value="/insertpage")
	public String insertPage(){
		return "insert";
}

/*
 * @RequestMapping(value="/insert") public void insert(@RequestParam("col1")
 * String col1, @RequestParam("col2") String col2,
 * 
 * @RequestParam("col3") String col3) { System.out.println(col1);
 * System.out.println(col2); System.out.println(col3); // 회원가입 : 아이디, 비밀번호, 이름,
 * 전화번호, 이메일, 성별 ~~ // 매개변수를 그대로 전달하는 방법 es.insert1(col1, col2, col3);
 * 
 * // dto를 이용하여 ExService.insert2 메소드로 전달하는 방법 ExDTO dto = new ExDTO();
 * dto.setCol1(col1); dto.setCol2(col2); dto.setCol3(col3);
 * 
 * es.insert2(dto);
 */
	// @ModelAttribute : dto 필드값을 알아서 담아줌.
@RequestMapping(value="/insert")
public void insert(@ModelAttribute ExDTO dto) {
	// dto에 값이 제대로 담겼는지 확인
	System.out.println(dto.toString());
	es.insert2(dto);
}

@RequestMapping(value="/select")
public ModelAndView select() {
	mav = es.select();
	return mav;
}


}

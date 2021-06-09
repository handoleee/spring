package com.cafe.board.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cafe.board.dto.MemberDTO;
import com.cafe.board.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService ms;
	
	private ModelAndView mav;
	
	@RequestMapping(value="/joinpage")
	public String joinPage() {
		return "memberjoin";
	}
	
	@RequestMapping(value="/memberjoin")
	public ModelAndView memberJoin(@ModelAttribute MemberDTO member) {
		mav = ms.memberJoin(member);
		return mav;
	}
	
	@RequestMapping(value="/idcheck")
	public @ResponseBody String idCheck(@RequestParam("mid") String mid) {
		System.out.println("idcheck 호출");
		String idresult = ms.idCheck(mid);
		return idresult;
	}
	
//	@RequestMapping(value="/pwcheck")
//	public @ResponseBody String pwCheck(@RequestParam("mpassword") String mpassword) {
//		System.out.println("pwcheck 호출");
//		String pwresult = ms.pwCheck(mpassword);
//		return pwresult;
//	}
}

package com.cafe.board.controller;


import javax.servlet.http.HttpSession;

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
	
	@Autowired
	private HttpSession session;
	
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
		String result = ms.idCheck(mid);
		return result;
	}
	
//	@RequestMapping(value="/pwcheck")
//	public @ResponseBody String pwCheck(@RequestParam("mpassword") String mpassword) {
//		System.out.println("pwcheck 호출");
//		String pwresult = ms.pwCheck(mpassword);
//		return pwresult;
//	}
	
	@RequestMapping(value="/loginpage")
	public String loginPage() {
		return "memberlogin";
	}
	
	@RequestMapping(value="/memberlogin")
	public ModelAndView memerLogin(@ModelAttribute MemberDTO member) {
		System.out.println("login메소드"+member.toString());
		mav = ms.memberlogin(member);
		return mav;
	}
	
	public String logout() {
		session.invalidate();
		return "home";
	}
}

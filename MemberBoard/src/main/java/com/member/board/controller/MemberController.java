package com.member.board.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.member.board.dto.MemberDTO;
import com.member.board.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService ms;
	
	private ModelAndView mav;
	
	@Autowired
	private HttpSession session;
	
	//OK
	@RequestMapping(value="/joinpage")
	public String joinPage() {
		return "memberjoin";
	}
	//OK
	@RequestMapping(value="/memberjoin")
	public ModelAndView memberJoin(@ModelAttribute MemberDTO member) throws IllegalStateException, IOException {
		mav = ms.memberJoin(member);
		return mav;
	}
	
	// OK중복확인
	@RequestMapping(value="/idcheck")
	public @ResponseBody String idCheck(@RequestParam("mid") String mid) {
		System.out.println("idCheck 메소드 호출됨");
		String result = ms.idCheck(mid);
		return result;
	}
	//OK
	@RequestMapping(value="/loginpage")
	public String loginPage() {
		return "memberlogin";
	}
	//OK
	@RequestMapping(value="/login")
	public ModelAndView memberLogin(@ModelAttribute MemberDTO member) {
		System.out.println("login 메소드"+member.toString());
		mav = ms.memberlogin(member);
		return mav;
	}
	
	public String logout() {
		session.invalidate();
		return "home";
	}
	//ok
	@RequestMapping(value="/memberupdate")
	public ModelAndView update() {
		mav = ms.update();
		return mav;
	}
	//ok
	@RequestMapping(value="/mupdateprocess")
	public ModelAndView updateProcess(@ModelAttribute MemberDTO member) {
		mav = ms.updateProcess(member);
		return mav;
	}
	//ok
	@RequestMapping(value="/memberlist")
	public ModelAndView memberList() {
		mav = ms.memberList();
		return mav;
	}
	//ok
	@RequestMapping(value="/memberview")
	public ModelAndView memberView(@RequestParam("mid") String mid) {
		mav= ms.memberView(mid);
		return mav;
	}
	//관리자 ok
	@RequestMapping(value="/memberdelete")
	public ModelAndView memberDelete(@RequestParam("mid") String mid) {
		mav = ms.memberDelete(mid);
		return mav;
	}
	
	 // ajax로 상세조회
	@RequestMapping(value="/memberviewajax")
	public @ResponseBody MemberDTO memberViewAjax(
			@RequestParam("mid") String mid) {
		System.out.println("memberViewAjax 메소드 호출됨");
		System.out.println("전달 id값 "+mid);
		MemberDTO member = ms.memberViewAjax(mid);
		System.out.println(member);
		return member;
	}
	
	// ok mypage
	@RequestMapping(value="/mypage")
	public String myPage() {
		return "mypage";
	}
		
}



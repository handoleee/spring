package com.member.board.controller;

import java.io.IOException;

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
	
	@RequestMapping(value="/joinpage")
	public String joinPage() {
		return "memberjoin";
	}
	
	@RequestMapping(value="/memberjoin")
	public ModelAndView memberJoin(@ModelAttribute MemberDTO member) throws IllegalStateException, IOException {
		mav = ms.memberJoin(member);
		return mav;
	}
	
	// 중복확인 - 안되는중
	@RequestMapping(value="/idcheck")
	public @ResponseBody String idCheck(@RequestParam("mid") String mid) {
		System.out.println("idCheck 메소드 호출됨");
		String result = ms.idCheck(mid);
		return result;
	}
	
	@RequestMapping(value="/loginpage")
	public String loginPage() {
		return "memberlogin";
	}
	
	@RequestMapping(value="/login")
	public ModelAndView memberLogin(@ModelAttribute MemberDTO member) {
		System.out.println("login 메소드"+member.toString());
		mav = ms.memberlogin(member);
		return mav;
	}
	
	@RequestMapping(value="/boardlist")
	public ModelAndView boardlist() {
		mav = ms.boardList();
		return mav;
	}
	
	@RequestMapping(value="/memberupdate")
	public ModelAndView update() {
		mav = ms.update();
		return mav;
	}
	
	@RequestMapping(value="/updateprocess")
	public ModelAndView updateProcess(@ModelAttribute MemberDTO member) {
		mav = ms.updateProcess(member);
		return mav;
	}
	
	@RequestMapping(value="/memberlist")
	public ModelAndView memberList() {
		mav = ms.memberList();
		return mav;
	}
	
	@RequestMapping(value="/memberview")
	public ModelAndView memberView(@RequestParam("mid") String mid) {
		mav= ms.memberView(mid);
		return mav;
	}
	
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
}



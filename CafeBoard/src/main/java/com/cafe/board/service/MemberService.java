package com.cafe.board.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.cafe.board.dao.MemberDAO;
import com.cafe.board.dto.MemberDTO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO mdao;
	
	@Autowired
	private HttpSession session;
	
	private ModelAndView mav;
	
	public ModelAndView memberJoin(MemberDTO member) {
		mav = new ModelAndView();
		
		int insertResult = 0;
		insertResult = mdao.memberJoin(member);
		if(insertResult > 0) {
			mav.setViewName("memberlogin");
		} else {
			mav.setViewName("memberjoin");
		}
		return mav;
	}

	public String idCheck(String mid) {
		String CheckResult = mdao.idCheck(mid);
		String result="";
		if(CheckResult == null ) {
			result = "ok";
		} else {
			result = "no";
		}
		System.out.println("서비스클래스 아이디 결과"+result);
		return result;
	}

//	public String pwCheck(String mpassword) {
//		String pwCheckResult = mdao.pwCheck(mpassword);
//		String result="";
//		if(pwCheckResult == mpassword) {
//			result = "ok";
//		} else {
//			result = "no";
//		}
//		System.out.println("서비스클래스 비밀번호 결과"+result);
//		return result;
//	}
	
	public ModelAndView memberlogin(MemberDTO member) {
		mav = new ModelAndView();
		String loginId = mdao.memberLogin(member);
		if(loginId != null) {
			session.setAttribute("loginMember", loginId);
			mav.setViewName("redirect:/contentslist");
		} else {
			mav.setViewName("memberlogin");
			//로그인안한 상태여도 로그인 상태가 되어 있는지..?
		}
		return mav;
	}
	
	public ModelAndView mypage() {
		mav = new ModelAndView();
		String loginId = (String) session.getAttribute("loginMember");
		MemberDTO mypage = mdao.mypage(loginId);
		mav.addObject("mypage", mypage);
		mav.setViewName("mypage");
		return mav;
	}

	public ModelAndView memberList() {
		mav = new ModelAndView();
		List<MemberDTO> memberList = mdao.memberList();
		
		mav.addObject("memberList", memberList);
		mav.setViewName("memberlist");
		return mav;
	}

	public ModelAndView memberUpdate() {
		mav = new ModelAndView();
		String loginId = (String) session.getAttribute("loginMember");
		MemberDTO memberUpdate = mdao.memberUpdate(loginId);
		
		mav.addObject("memberUpdate", memberUpdate);
		mav.setViewName("memberupdate");
		return mav;
	}

	public ModelAndView memberUpdateProcess(MemberDTO member) {
		mav = new ModelAndView();
		int updateResult = mdao.memberUpdateProcess(member);
		if(updateResult > 0) {
			mav.setViewName("redirect:/memberupdate");
		} else {
			mav.setViewName("redirect:/mypage");
		}
		return mav;
	}

}

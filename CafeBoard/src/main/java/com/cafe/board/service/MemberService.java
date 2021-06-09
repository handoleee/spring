package com.cafe.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.cafe.board.dao.MemberDAO;
import com.cafe.board.dto.MemberDTO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO mdao;
	
	private ModelAndView mav;
	
	public ModelAndView memberJoin(MemberDTO member) {
		mav = new ModelAndView();
		
		int insertResult = 0;
		insertResult = mdao.memberJoin(member);
		if(insertResult > 0) {
			mav.setViewName("memberlogin");
		} else {
			mav.setViewName("joinfail");
		}
		return mav;
	}

	public String idCheck(String mid) {
		String idCheckResult = mdao.idCheck(mid);
		String result="";
		if(idCheckResult == null ) {
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
//		if(pwCheckResult == null) {
//			result = "ok";
//		} else {
//			result = "no";
//		}
//		System.out.println("서비스클래스 비밀번호 결과"+result);
//		return result;
//	}

}

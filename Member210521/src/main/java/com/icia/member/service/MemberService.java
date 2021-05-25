package com.icia.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.member.dao.MemberDAO;
import com.icia.member.dto.MemberDTO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO mdao;
	
	private ModelAndView mav;

	public ModelAndView memberJoin(MemberDTO member) {
		mav = new ModelAndView();
		
		// memberJoin 호출 결과를 받아서 insert 성공 여부에 따라 처리
		int insertResult = 0;
		insertResult = mdao.memberJoin(member);
		if(insertResult > 0) {
			// insertReult가 0보다 크다는 것은 insert가 성공했다는 의미이기 때문에 회원가입이 완료된 것으로 판단
			mav.setViewName("memberlogin");
		} else{
			// insertResult가 0이라는 의미는 insert가 실패했다는 의미
			mav.setViewName("joinfail");
		}
		
		return mav;
	}
	
	public ModelAndView memberList() { 
		mav = new ModelAndView();
		List<MemberDTO> memberList = mdao.memberList();
		
		// memberList에 DB 조회 결과를 담아서 memberlist.jsp로 이동
		mav.addObject("memberList", memberList);
		mav.setViewName("memberlist"); 
	 
	 return mav; }

	public ModelAndView memberView(String mid) {
		mav = new ModelAndView();
		// 한명 회원에 대한 정보만 필요하기 때문에 DTO 타입의 객체로 리턴을 받음
		MemberDTO member = mdao.memberView(mid);
		
		// DB 조회 결과를 member에 받았고
		// member를 담아서 memberview.jsp로 가야함
		mav.addObject("memberView", member);
		mav.setViewName("memberview");
		
		return mav;
	}
}

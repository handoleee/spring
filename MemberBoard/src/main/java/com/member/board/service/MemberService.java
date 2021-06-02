package com.member.board.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.member.board.dao.MemberDAO;
import com.member.board.dto.BoardDTO;
import com.member.board.dto.MemberDTO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO mdao;
	
	private ModelAndView mav;
	
	@Autowired
	private HttpSession session;
	
	public ModelAndView memberJoin(MemberDTO member) throws IllegalStateException, IOException {
		mav = new ModelAndView();
//		int insertResult = 0;
//		
////		insertResult = mdao.memberJoin(member);
//		
//		if(insertResult > 0) {
//			mav.setViewName("memberlogin");
//		} else {
//			mav.setViewName("joinfail");
//		}
		
		MultipartFile mprofile = member.getMprofile();
		String mprofilename = mprofile.getOriginalFilename();
		mprofilename = System.currentTimeMillis() + "-" + mprofilename;
		System.out.println("mprofilename " + mprofilename);
		
		String savePath = "D:\\source_phs\\spring\\spring\\MemberBoard\\src\\main\\webapp\\resources\\profile\\"+mprofilename;
		
		if(!mprofile.isEmpty()) {
			mprofile.transferTo(new File(savePath));
		}
		
		member.setMprofilename(mprofilename);
		mdao.memberJoin(member);
		
		mav.setViewName("redirect:/");
		return mav;
	}

	public String idCheck(String mid) {
		String checkResult = mdao.idCheck(mid);
		String result="";
		if(checkResult == null) {
			result = "ok";
		} else {
			result = "no";
		}
		System.out.println("서비스클래스 결과 " + result);
		return result;
	}

	public ModelAndView memberlogin(MemberDTO member) {
		mav = new ModelAndView();
		String loginId = mdao.memberLogin(member);
		if(loginId != null) {
			session.setAttribute("loginMember", loginId);
			mav.setViewName("boardlist");
		} else {
			mav.setViewName("memberlogin");
		}
		return mav;
	}

	public ModelAndView boardList() {
		mav = new ModelAndView();
		List<BoardDTO> boardList = mdao.boardList();
		mav.addObject("boardList", boardList);
		mav.setViewName("boardlist");
		return mav;
	}

	public ModelAndView update() {
		mav = new ModelAndView();
		String loginId = (String) session.getAttribute("loginMember");
		MemberDTO memberUpdate = mdao.update(loginId);
		
		mav.addObject("memberup", memberUpdate);
		mav.setViewName("memberupdate");
		return mav;
	}

	public ModelAndView updateProcess(MemberDTO member) {
		mav = new ModelAndView();
		int updateResult = mdao.updateProcess(member);
		
		if(updateResult > 0) {
			mav.setViewName("boardlist");
		} else {
			mav.setViewName("updatefail");
		}
		return mav;
	}

	public ModelAndView memberList() {
		mav = new ModelAndView();
		List<MemberDTO> memberList = mdao.memberList();
		
		mav.addObject("memberList", memberList);
		mav.setViewName("memberlist");
		return mav;
	}

	public ModelAndView memberView(String mid) {
		mav = new ModelAndView();
		MemberDTO member = mdao.memberView(mid);
		mav.addObject("memberView", member);
		mav.setViewName("memberview");
		return mav; 
	}

	public ModelAndView memberDelete(String mid) {
		mav = new ModelAndView();
		mdao.memberDelete(mid);
		mav.setViewName("redirect:/memberlist");
		return mav;
	}

	public MemberDTO memberViewAjax(String mid) {
		MemberDTO member = mdao.memberView(mid);
		return member;
	}

}

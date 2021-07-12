package recipe.shop.mall.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import recipe.shop.mall.dao.MemberDAO;
import recipe.shop.mall.dto.MemberDTO;

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
		String result = "";
		if(CheckResult == null) {
			result="ok";
		} else {
			result="no";
		}
		return result;
	}
	
	public ModelAndView memberLogin(MemberDTO member) {
		mav = new ModelAndView();
		String loginId = mdao.memberLogin(member);
		if(loginId != null) {
			session.setAttribute("loginMember", loginId);
			mav.setViewName("redirect:/home");
		} else {
			mav.setViewName("memberlogin");
		}
		return mav;
	}

	public ModelAndView memberUpdate() {
		mav = new ModelAndView();
		String loginId = (String) session.getAttribute("loginMember");
		MemberDTO memberUpdate = mdao.memberUpdate(loginId);
		
		mav.addObject("memberupdate", memberUpdate);
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

	public ModelAndView memberDelete(String mid) {
		mav = new ModelAndView();
		mdao.memberDelete(mid);
		mav.setViewName("redirect:/memberlist");
		return mav;
	}

	public ModelAndView memberList() {
		mav = new ModelAndView();
		List<MemberDTO> memberList = mdao.memberList();
		mav.addObject("memberlist", memberList);
		mav.setViewName("memberlist");
		return mav;
	}

	public ModelAndView memberView(String mid) {
		MemberDTO member = mdao.memberView(mid);
		mav.addObject("member", member);
		mav.setViewName("memberview");
		return mav;
	}

	

}

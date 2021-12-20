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
		// ModelAndView 객체 생성
		mav = new ModelAndView();
		// 호출 결과를 담을 변수 선언
		int insertResult = 0;
		// DAO를 호출하여 호출 결과를 insertResult에 담음
		insertResult = mdao.memberJoin(member);
		// insert 성공 여부에 따라 성공하면 memberlogin.jsp 출력, 실패하면 memberjoin.jsp 출력
		if(insertResult > 0) {
			mav.setViewName("memberlogin");
		} else {
			mav.setViewName("memberjoin");
		}
		// ModelAndView 객체 리턴
		return mav;
	}
	
	public String idCheck(String mid) {
		// DAO를 호출하여 호출 결과를 checkResult에 담음
		String checkResult = mdao.idCheck(mid);
		// 
		String result = "";
		if(checkResult == null) {
			result = "ok";
		} else {
			result = "no";
		}
		return result;
	}
	
	public ModelAndView memberLogin(MemberDTO member) {
		// ModelAndView 객체 생성
		mav = new ModelAndView();
		// DAO를 호출하여 호출 결과를 loginId에 담음
		String loginId = mdao.memberLogin(member);
		// DAO 내에 loginId가 있다면 로그인 성공으로 홈페이지 출력, 없다면 로그인 실패로 memberlogin.jsp 출력 
		if(loginId != null) {
			session.setAttribute("loginMember", loginId);
			mav.setViewName("redirect:/");
		} else {
			mav.setViewName("memberlogin");
		}
		// ModelAndView 객체 리턴
		return mav;
	}

	public ModelAndView memberUpdate() {
		// ModelAndView 객체 생성
		mav = new ModelAndView();
		// session에 저장되어있는 아이디와 DAO 내에 있는 loginId 일치여부 판단
		String loginId = (String) session.getAttribute("loginMember");
		// DAO를 호출하여 윗부분이 일치하다면 memberUpdate에 담음
		MemberDTO memberUpdate = mdao.memberUpdate(loginId);
		mav.addObject("memberupdate", memberUpdate);
		// memberupdate.jsp 출력
		mav.setViewName("memberupdate");
		return mav;
	}

	public ModelAndView memberUpdateProcess(MemberDTO member) {
		// ModelAndView 객체 생성
		mav = new ModelAndView();
		// DAO를 호출하여 호출결과를 updateResult에 담음
		int updateResult = mdao.memberUpdateProcess(member);
		// update 성공 여부에 따라 성공하면 memberupdate.jsp 출력, 실패하면 mypage.jsp 출력
		if(updateResult > 0) {
			mav.setViewName("redirect:/memberupdate");
		} else {
			mav.setViewName("redirect:/mypage");
		}
		// ModelAndView 객체 리턴
		return mav;
	}

	public ModelAndView memberDelete(String mid) {
		// ModelAndView 객체 생성
		mav = new ModelAndView();
		// session에 저장되어있는 아이디와 DAO 내에 있는 loginId 일치여부 판단
		String loginId = (String) session.getAttribute("loginMember");
		// DAO를 호출
		mdao.memberDelete(mid);
		// loginId가 admin(관리자)일 경우 membrelist.jsp 출력, 아닐 경우 홈페이지로 이동
		if(loginId == "admin") {
			mav.setViewName("redirect:/memberlist");
		}
		else {
			mav.setViewName("redirect:/");
		}
		// session 삭제
		session.invalidate();
		// ModelAndView 객체 리턴
		return mav;
	}
	
	// 여기부터 관리자페이지
	
	public ModelAndView memberList() {
		// ModelAndView 객체 생성
		mav = new ModelAndView();
		// DAO 호출해서 memberList에 담음
		List<MemberDTO> memberList = mdao.memberList();
		mav.addObject("memberlist", memberList);
		// memberlist.jsp 출력
		mav.setViewName("memberlist");
		// ModelAndView 객체 리턴
		return mav;
	}

	public ModelAndView memberView(String mid) {
		// ModelAndView 객체 생성
		// DAO 호출해서 member에 담음
		MemberDTO member = mdao.memberView(mid);
		mav.addObject("member", member);
		// memberview.jsp 출력
		mav.setViewName("memberview");
		// ModelAndView 객체 리턴
		return mav;
	}
	
	public ModelAndView adminPoint(String mid) {
		// ModelAndView 객체 생성
		// DAO 호출해서 adminPoint에 담음
		MemberDTO adminPoint = mdao.adminPoint(mid);
		mav.addObject("adminpoint", adminPoint);
		// adminpoint.jsp 출력
		mav.setViewName("adminpoint");
		// ModelAndView 객체 리턴
		return mav;
	}

	public ModelAndView adminPointProcess(MemberDTO member) {
		// ModelAndView 객체 생성
		mav = new ModelAndView();
		// DAO를 호출하여 호출결과를 pointResult에 담음
		int pointResult = mdao.adminPointProcess(member);
		// 성공하면 memberlist.jsp 출력, 실패하면 adminpage.jsp 출력
		if(pointResult > 0) {
			mav.setViewName("redirect:/memberlist");
		} else {
			mav.setViewName("redirect:/adminpage");
		}
		// ModelAndView 객체 리턴
		return mav;
	}
}

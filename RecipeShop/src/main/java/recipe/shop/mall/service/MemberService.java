package recipe.shop.mall.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import recipe.shop.mall.dao.MemberDAO;
import recipe.shop.mall.dto.MemberDTO;
import recipe.shop.mall.dto.PurchaserDTO;
import recipe.shop.mall.dto.RecipeDTO;
import recipe.shop.mall.dto.ReportDTO;

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
			result = "ok";
		} else {
			result = "no";
		}
		return result;
	}
	
	public ModelAndView memberLogin(MemberDTO member) {
		mav = new ModelAndView();
		String loginId = mdao.memberLogin(member);
		if(loginId != null) {
			session.setAttribute("loginMember", loginId);
			mav.setViewName("redirect:/");
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
		String loginId = (String) session.getAttribute("loginMember");
		mdao.memberDelete(mid);
		if(loginId == "admin") {
			mav.setViewName("memberlist");
		}
		else {
			mav.setViewName("redirect:/");
		}
		session.invalidate();
		return mav;
	}

	public ModelAndView myReport() {
		mav = new ModelAndView();
		String loginId = (String) session.getAttribute("loginMember");
		List<ReportDTO> myReport = mdao.myReport(loginId);
		mav.addObject("myreport", myReport);
		mav.setViewName("myreport");
		return mav;
	}

	public ModelAndView myRecipeList() {
		mav = new ModelAndView();
		List<RecipeDTO> myRecipeList = mdao.myRecipeList();
		mav.addObject("myrecipelist", myRecipeList);
		mav.setViewName("myrecipelist");
		return mav;
	}

	public ModelAndView myBuyRecipe() {
		mav = new ModelAndView();
		String loginId = (String) session.getAttribute("loginMember");
		List<PurchaserDTO> myBuyRecipe = mdao.myBuyRecipe(loginId);
		mav.addObject("mybuyrecipe", myBuyRecipe);
		mav.setViewName("mybuyrecipe");
		return mav;
	}
	
	// 여기부터 관리자페이지
	
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

	public ModelAndView totalReport() {
		mav = new ModelAndView();
		List<ReportDTO> totalReport = mdao.totalReport();
		mav.addObject("totalreport", totalReport);
		mav.setViewName("reportlist");
		return mav;
	}
	
	public ModelAndView adminPoint(String mid) {
		MemberDTO adminPoint = mdao.adminPoint(mid);
		mav.addObject("adminpoint", adminPoint);
		mav.setViewName("adminpoint");
		return mav;
	}

	public ModelAndView adminPointProcess(MemberDTO member) {
		mav = new ModelAndView();
		int pointResult = mdao.adminPointProcess(member);
		if(pointResult > 0) {
			mav.setViewName("redirect:/memberlist");
		} else {
			mav.setViewName("redirect:/adminpage");
		}
		return mav;
	}

	public MemberDTO memberViewAjax(String mid) {
		MemberDTO member = mdao.memberView(mid);
		return member;
	}
}

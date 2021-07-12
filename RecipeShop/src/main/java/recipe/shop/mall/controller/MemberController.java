package recipe.shop.mall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import recipe.shop.mall.dto.MemberDTO;
import recipe.shop.mall.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService ms;
	
	private ModelAndView mav;
	
	//회원가입페이지
	@RequestMapping(value="/memberjoinform")
	public String joinForm() {
		return "memberjoin";
	}
	
	//회원가입
	@RequestMapping(value="/memberjoin")
	public ModelAndView memberJoin(@ModelAttribute MemberDTO member) {
		mav = ms.memberJoin(member);
		return mav;
	}
	
	//아이디 중복체크
	@RequestMapping(value="/idcheck")
	public @ResponseBody String idCheck(@RequestParam("mid") String mid) {
		String result = ms.idCheck(mid);
		return result;
	}
	
	//로그인 페이지 이동
	@RequestMapping(value="/memberloginform")
	public String loginForm() {
		return "memberlogin";
	}
	
	//로그인
	@RequestMapping(value="/memberlogin")
	public ModelAndView memberLogin(@ModelAttribute MemberDTO member) {
		mav = ms.memberLogin(member);
		return mav;
	}
	
	//마이페이지
	@RequestMapping(value="/mypage")
	public String myPage() {
		return "mypage";
	}
	
	//회원정보수정
	@RequestMapping(value="/memberupdate")
	public ModelAndView memberUpdate() {
		mav = ms.memberUpdate();
		return mav;
	}
	
	//회원정보수정 처리
	@RequestMapping(value="/memberupdateprocess")
	public ModelAndView memberUpdatdProcess(@ModelAttribute MemberDTO member) {
		mav= ms.memberUpdateProcess(member);
		return mav;
	}
	
	//회원탈퇴
	@RequestMapping(value="/memberdelete")
	public ModelAndView memberDelete(@RequestParam("mid") String mid) {
		mav = ms.memberDelete(mid);
		return mav;
	}
	
	//내 신고내역
//	@RequestMapping(value="/myreport")
//	public ModelAndView myReport(@RequestParam("mid") String mid) {
//		mav = ms.myReport(mid);
//		return mav;
//	}
	
	//내가 작성한 레시피 목록
//	@RequestMapping(value="/myrecipelist")
//	public ModelAndView myRecipeList(@RequestParam("mid") String mid) {
//		mav = ms.myRecipeList(mid);
//		return mav;
//	}
	
	//내가 구매한 레시피 목록
	
	//관리자페이지화면 이동
	@RequestMapping(value="/adminpage")
	public String adminPage() {
		return "adminPage";
	}
	
	//회원목록 조회
	@RequestMapping(value="/memberlist")
	public ModelAndView memberList() {
		mav = ms.memberList();
		return mav;
	}
	
	//회원 상세조회
	@RequestMapping(value="/memberview")
	public ModelAndView memberView(@RequestParam("mid") String mid) {
		mav = ms.memberView(mid);
		return mav;
	}
	
	//회원신고내역
//	@RequestMapping(value="/")
	//포인트지급(조회수 기준)
	//포인트지급(조회수 기준) 처리
	//로그아웃
	@RequestMapping(value="/memberlogout")
	public ModelAndView memberLogout(HttpSession session) {
		session.invalidate();
		ModelAndView mav = new ModelAndView("redirect:/");
		return mav;
	}
}

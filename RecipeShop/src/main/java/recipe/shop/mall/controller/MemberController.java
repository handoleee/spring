package recipe.shop.mall.controller;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
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
	
	@Autowired
	private JavaMailSenderImpl mailSender;
	
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
		System.out.println("중복확인호출");
		String result = ms.idCheck(mid);
		return result;
	}
	
	//이메일 인증
	@RequestMapping(value="/checkemail")
	@ResponseBody
	public String sendEmail(String email) throws Exception {
		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;
		
		String setFrom = "phss0603@gmail.com";
		String toMail = email;
		String title="회원가입 인증 이메일입니다.";
		String content =  "홈페이지를 방문해주셔서 감사합니다." +
                "<br><br>" + 
                "인증 번호는 " + checkNum + "입니다." + 
                "<br>" + 
                "해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
		
		try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom(setFrom);
            helper.setTo(toMail);
            helper.setSubject(title);
            helper.setText(content,true);
            mailSender.send(message);
            
        }catch(Exception e) {
            e.printStackTrace();
        }
		String num = Integer.toString(checkNum);
		return num;
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
	@RequestMapping(value="/myreport")
	public ModelAndView myReport() {
		mav = ms.myReport();
		return mav;
	}
	
	//내가 작성한 레시피 목록
	@RequestMapping(value="/myrecipelist")
	public ModelAndView myRecipeList() {
		mav = ms.myRecipeList();
		return mav;
	}
	
	//내가 구매한 레시피 목록
	@RequestMapping(value="/mybuyrecipe")
	public ModelAndView myBuyRecipe() {
		mav = ms.myBuyRecipe();
		return mav;
	}
	
	//관리자페이지화면 이동
	@RequestMapping(value="/adminpage")
	public String adminPage() {
		return "adminpage";
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
	@RequestMapping(value="/reportlist")
	public ModelAndView totalReport() {
		mav = ms.totalReport();
		return mav;
	}
	
	@RequestMapping(value="/memberviewajax")
	public @ResponseBody MemberDTO memberViewAjax(
			@RequestParam("mid") String mid) {
		MemberDTO member = ms.memberViewAjax(mid);
		return member;
	}
	
	//포인트지급(조회수 기준)
	@RequestMapping(value="/adminpoint")
	public ModelAndView adminPoint(@RequestParam("mid") String mid) {
		mav = ms.adminPoint(mid);
		return mav;
	}
	
	//포인트지급(조회수 기준) 처리
	@RequestMapping(value="/adminpointprocess")
	public ModelAndView adminPointProcess(@ModelAttribute MemberDTO member) {
		mav = ms.adminPointProcess(member);
		return mav;
	}
	
	//로그아웃
	@RequestMapping(value="/memberlogout")
	public ModelAndView memberLogout(HttpSession session) {
		session.invalidate();
		ModelAndView mav = new ModelAndView("redirect:/");
		return mav;
	}
}

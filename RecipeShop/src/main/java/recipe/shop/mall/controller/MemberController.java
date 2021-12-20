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
	// memberjoin.jsp로 이동
	public String joinForm() {
		return "memberjoin";
	}
	
	//회원가입
	@RequestMapping(value="/memberjoin")
	// memberjoin.jsp에서 입력한 내용을 MemberDTO 객체에 담음
	public ModelAndView memberJoin(@ModelAttribute MemberDTO member) {
		// 서비스클래스의 memberJoin 메소드를 호출하고 호출 결과를 ModelAndView 객체에 담음
		mav = ms.memberJoin(member);
		// ModelAndView 객체를 리턴함
		return mav;
	}
	
	//아이디 중복확인
	@RequestMapping(value="/idcheck")
	public @ResponseBody String idCheck(@RequestParam("mid") String mid) {
		// 입력한 mid를 담아오기
		String result = ms.idCheck(mid);
		// result에 아이디 담고 DB에서 중복확인 후 리턴
		return result;
	}
	
	//이메일 인증
	@RequestMapping(value="/checkemail")
	@ResponseBody
	public String sendEmail(String email) throws Exception {
		// 6자리 랜덤 숫자를 생성
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
			// mailSender 사용
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
		// 6자리 랜덤숫자 메일로 보낸 숫자 = num
		String num = Integer.toString(checkNum);
		// num에 랜덤숫자 담고 리턴
		return num;
	}

	//로그인 페이지 이동
	@RequestMapping(value="/memberloginform")
	// memberlogin.jsp로 이동
	public String loginForm() {
		return "memberlogin";
	}
	
	//로그인
	@RequestMapping(value="/memberlogin")
	// memberlogin.jsp에서 입력한 내용을 MemberDTO 객체에 담음
	public ModelAndView memberLogin(@ModelAttribute MemberDTO member) {
		// 서비스클래스의 memberLogin 메소드를 호출하고 호출결과를 ModelAndView 객체에 담음
		mav = ms.memberLogin(member);
		// ModelAndView 객체를 리턴
		return mav;
	}
	
	//마이페이지
	@RequestMapping(value="/mypage")
	// mypage.jsp로 이동
	public String myPage() {
		return "mypage";
	}
	
	//회원정보수정
	@RequestMapping(value="/memberupdate")
	public ModelAndView memberUpdate() {
		// 서비스클래스의 memberUpdate 메소드를 호출하고 호출결과를 ModelAndView 객체에 담음
		mav = ms.memberUpdate();
		// ModelAndView 객체를 리턴
		return mav;
	}
	
	//회원정보수정 처리
	@RequestMapping(value="/memberupdateprocess")
	// memberupdate.jsp에서 입력한 내용을 MemberDTO 객체에 담음
	public ModelAndView memberUpdateProcess(@ModelAttribute MemberDTO member) {
		// 서비스클래스의 memberUpdateProcess 메소드를 호출하고 호출결과를 ModelAndView 객체에 담음
		mav = ms.memberUpdateProcess(member);
		// ModelAndView 객체를 리턴
		return mav;
	}
	
	//회원탈퇴
	@RequestMapping(value="/memberdelete")
	// 로그인한 아이디 또는 관리자가 선택한 아이디를 선택
	public ModelAndView memberDelete(@RequestParam("mid") String mid) {
		// 서비스클래스의 memberDelete 메소드를 호출하고 호출결과를 ModelAndView 객체에 담음
		mav = ms.memberDelete(mid);
		// ModelAndView 객체를 리턴
		return mav;
	}
	
	//관리자페이지화면 이동
	@RequestMapping(value="/adminpage")
	// adminpage.jsp로 이동
	public String adminPage() {
		return "adminpage";
	}
	
	//회원목록 조회
	@RequestMapping(value="/memberlist")
	// 관리자가 회원목록을 조회할 수 있도록 함
	public ModelAndView memberList() {
		// 서비스클래스의 memberList 메소드를 호출하고 호출결과를 ModelAndView 객체에 담음
		mav = ms.memberList();
		// ModelAndView 객체를 리턴
		return mav;
	}
	
	//회원 상세조회
	@RequestMapping(value="/memberview")
	public ModelAndView memberView(@RequestParam("mid") String mid) {
		// 서비스 클래스의 memberView 메소드를 호출하고 ModelAndView 객체에 담음
		mav = ms.memberView(mid);
		// ModelAndView 객체를 리턴
		return mav;
	}
	
	
	//포인트지급
	@RequestMapping(value="/adminpoint")
	public ModelAndView adminPoint(@RequestParam("mid") String mid) {
		// 서비스 클래스의 adminPoint 메소드를 호출하고 ModelAndView 객체에 담음
		mav = ms.adminPoint(mid);
		// ModelAndView 객체를 리턴
		return mav;
	}
	
	//포인트지급 처리
	@RequestMapping(value="/adminpointprocess")
	// adminpoint.jsp에서 입력한 포인트를 부여함
	public ModelAndView adminPointProcess(@ModelAttribute MemberDTO member) {
		// 서비스 클래스의 adminPointProcess 메소드를 호출하고 ModelAndView 객체에 담음
		mav = ms.adminPointProcess(member);
		return mav;
	}
	
	//로그아웃
	@RequestMapping(value="/memberlogout")
	public ModelAndView memberLogout(HttpSession session) {
		// session을 이용하여 로그아웃
		session.invalidate();
		ModelAndView mav = new ModelAndView("redirect:/");
		return mav;
	}
}

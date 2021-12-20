package recipe.shop.mall.service;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;


import recipe.shop.mall.dao.CartDAO;
import recipe.shop.mall.dto.CartDTO;

@Service
public class CartService {
	
	@Autowired
	private CartDAO cdao;

	private ModelAndView mav;
	
	@Autowired
	private HttpSession session;
	
	// 장바구니 담기
	public ModelAndView cart(CartDTO cart) {
		mav = new ModelAndView();
		
		int insertResult = 0;
		insertResult = cdao.cart(cart);
		if(insertResult > 0) {
			mav.setViewName("redirect:/shoplist");
		} else {
			mav.setViewName("home");
		}
		return mav;
	}

	// 내 장바구니
	public ModelAndView BaskList(String loginMember) {
		mav = new ModelAndView();
		List<CartDTO> basklist = cdao.yeyagList(loginMember);
		
		mav.addObject("BaskList", basklist);
		mav.setViewName("basklist");
		
		return mav;
	}

	// 조회
	public ModelAndView cartView(int sbnumber) {
		mav = new ModelAndView();
			
		CartDTO cartview = cdao.cartView(sbnumber);
		mav.addObject("cartview", cartview);

		mav.setViewName("cartview");
		return mav;
	}	

	// 장바구니 취소
	public ModelAndView cartDelete(int sbnumber) {
		mav = new ModelAndView();
		
		cdao.cartDelete(sbnumber);
		String id = (String) session.getAttribute("loginMember");
		mav.setViewName("redirect:/basklist?loginMember="+id);
		
		return mav;
	}

	// 수량 수정 화면
	public ModelAndView cartUpdate(int sbnumber) {
		mav = new ModelAndView();
		CartDTO cartupdate = cdao.cartView(sbnumber);
		mav.addObject("cartUpdate", cartupdate);
		mav.setViewName("cartupdate");
		return mav;
	}
		
	// 수정처리
	public ModelAndView cartupdateProcess(CartDTO cart) {
		mav = new ModelAndView();
		String id = (String) session.getAttribute("loginMember");
		int updateResult = cdao.cartupdateProcess(cart);
		if(updateResult > 0) {
			mav.setViewName("redirect:/basklist?loginMember="+id);
		}
		return mav;
		}


}

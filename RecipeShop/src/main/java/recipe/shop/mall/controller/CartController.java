package recipe.shop.mall.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import recipe.shop.mall.dto.CartDTO;
import recipe.shop.mall.service.CartService;

@Controller
public class CartController {
		
	@Autowired
	private CartService cs;
	
	private ModelAndView mav;
	
	
	// 장바구니 담기
	@RequestMapping(value="/cart")
	public ModelAndView cart(@ModelAttribute CartDTO cart) {
		mav = cs.cart(cart);
		
		return mav;
	}	
	
	//내 장바구니
	@RequestMapping(value="/basklist")
	public ModelAndView basklist(@RequestParam("loginMember") String loginMember) {
		mav = cs.BaskList(loginMember);		
		return mav;
	}
	
	// 장바구니 조회
	@RequestMapping(value="/cartview")
	public ModelAndView cartreView(@RequestParam("sbnumber") int sbnumber) {
		mav = cs.cartView(sbnumber);
		return mav;	
	}	
	
	// 장바구니 취소
	@RequestMapping(value="/cartdelete")
	public ModelAndView cartDelete(@RequestParam("sbnumber") int sbnumber) {
		mav = cs.cartDelete(sbnumber);
		return mav;
	}
	
	// 수량 수정 요청
	@RequestMapping(value="/cartupdate")
	public ModelAndView	cartUpdate(@RequestParam("sbnumber") int sbnumber) {
		mav = cs.cartUpdate(sbnumber);
		return mav;
	}	
	
	//수정 처리
	@RequestMapping(value="/cartupdateprocess")
	public ModelAndView cartupdateProcess(@ModelAttribute CartDTO cart)  {
		mav = cs.cartupdateProcess(cart);
		return mav;
	}	
	
}

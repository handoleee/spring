package recipe.shop.mall.controller;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import recipe.shop.mall.dto.ShopDTO;
import recipe.shop.mall.service.ShopService;

@Controller
public class ShopController {
	
	
	@Autowired
	private ShopService ss;
	
	private ModelAndView mav;
	
	// 재료 등록 화면
	@RequestMapping(value="/addshoppage")
	public String addshopPage() {
		return "addshop";
	}
	
	// 재료 등록 처리
	@RequestMapping(value="/shopadd")
	public ModelAndView ShopAdd(@ModelAttribute ShopDTO shopadd) throws IllegalStateException, IOException {
		mav = ss.ShopAdd(shopadd);
		
		return mav;
	}
	

	//상품 목록
	@RequestMapping(value="/shoplist")
	public ModelAndView shoplist() {
	mav = ss.ShopList();		
		return mav;
	}	
	
	// 리뷰 상세조회
	@RequestMapping(value="/shopview")
	public ModelAndView reView(@RequestParam("snumber") int snumber) {
	mav = ss.ShopView(snumber);
		return mav;
		
	}	
	
	
	// 수정화면 요청
	@RequestMapping(value="/shopupdate")
	public ModelAndView shopUpdate(@RequestParam("snumber") int snumber) {
		mav = ss.shopUpdate(snumber);
		return mav;
	}
	
	
	//수정 처리
	@RequestMapping(value="/shopupdateprocess")
	public ModelAndView shopupdateProcess(@ModelAttribute ShopDTO shop) throws IllegalStateException, IOException {
		mav = ss.updateProcess(shop);
		return mav;
	}	
	
	// 재료 삭제
	@RequestMapping(value="/shopdelete")
	public ModelAndView shopDelete(@RequestParam("snumber") int snumber) {
		mav = ss.shopDelete(snumber);
		return mav;
	}
	
	// 테스트
		@RequestMapping(value="/testpage")
		public String testPage() {
			return "test";
		}
	
		
		// 재료 검색
		@RequestMapping(value="/shopsearch")
		public ModelAndView shopSearch(@RequestParam("keyword") String keyword) {
			mav = ss.shopSearch(keyword);
			return mav;
		}		

		
		
		
		
		
		
		

		
		
}

package recipe.shop.mall.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import recipe.shop.mall.dto.MaterialDTO;
import recipe.shop.mall.dto.OrderDTO;
import recipe.shop.mall.dto.RecipeDTO;
import recipe.shop.mall.dto.ReportDTO;
import recipe.shop.mall.dto.ShopDTO;
import recipe.shop.mall.service.RecipeService;

@Controller
public class RecipeController {

	@Autowired
	private RecipeService rs;
	
	private ModelAndView mav;
	
	// 레시피 목록
	@RequestMapping(value="/recipelist")
	public ModelAndView recipeList(@RequestParam(value="page", required=false, defaultValue="1") int page) {
		mav = rs.recipeList(page);
		
		return mav;
	}
	
	// 레시피 등록 페이지
	@RequestMapping(value="/recipewritepage")
	public String recipeWritePage() {
		return "recipewrite";
	}
	
	// 레시피 등록 처리
	@RequestMapping(value="/recipewrite")
	public ModelAndView recipeWrite(@ModelAttribute RecipeDTO recipe,
									@ModelAttribute MaterialDTO material,
									@ModelAttribute OrderDTO order) throws IllegalStateException, IOException {
		mav = rs.recipeWrite(recipe, material, order);
		
		return mav;
	}
	
	// 레시피 상세 조회
	@RequestMapping(value="/recipeview")
	public ModelAndView recipeView(@RequestParam("rnumber") int rnumber) {
		mav = rs.recipeView(rnumber);
		
		return mav;
	}
	
	// 레시피 신고 페이지
	@RequestMapping(value="/recipereport")
	public ModelAndView recipeReport(@RequestParam("rnumber") int rnumber) {
		mav = rs.recipeReport(rnumber);
		
		return mav;
	}
	
	// 레시피 신고 처리
	@RequestMapping(value="/recipereportprocess")
	public ModelAndView recipeReportProcess(@ModelAttribute ReportDTO report) {
		mav = rs.recipeReportProcess(report);
		
		return mav;
	}
	
	// 레시피 삭제
	@RequestMapping(value="/recipedelete")
	public ModelAndView recipeDelete(@RequestParam("rnumber") int rnumber) {
		mav = rs.recipeDelete(rnumber);
		
		return mav;
	}
	
	// 레시피 수정
	@RequestMapping(value="/recipeupdate")
	public ModelAndView recipeUpdate(@RequestParam("rnumber") int rnumber) {
		mav = rs.recipeUpdate(rnumber);
		
		return mav;
	}
	
	// 레시피 수정 처리
	@RequestMapping(value="/recipeupdateprocess")
	public ModelAndView recipeUpdateProcess(@ModelAttribute RecipeDTO recipe,
											@ModelAttribute MaterialDTO material,
											@ModelAttribute OrderDTO order) throws IllegalStateException, IOException {
		
		mav = rs.recipeUpdateProcess(recipe, material, order);
		
		return mav;
	}
	
	// 레시피 랭킹
	@RequestMapping(value="/reciperanking")
	public ModelAndView recipeRanking() {
		mav = rs.recipeRanking();
		
		return mav;
	}
	
	// 레시피 검색
	@RequestMapping(value="/recipesearch")
	public ModelAndView recipeSearch(@RequestParam("keyword") String keyword) {
		mav = rs.recipeSearch(keyword);
		return mav;
	}
	
	// 카테고리 선택
	@RequestMapping(value="/categorysearch")
	public ModelAndView categorySearch(@RequestParam("keyword") String keyword) {
		mav = rs.categorySearch(keyword);
		return mav;
	}
	
	//회원신고내역
	@RequestMapping(value="/reportlist")
	public ModelAndView totalReport() {
		// 서비스클래스의 totalReport 메소드를 호출하고 호출결과를 ModelAndView 객체에 담음
		mav = rs.totalReport();
		// ModelAndView 객체를 리턴
		return mav;
	}
	
	//내 레시피목록
	@RequestMapping(value="/myrecipelist")
	public ModelAndView myRecipeList(@RequestParam("rname") String rname) {
		// 서비스클래스의 myRecipeList 메소드를 호출하고 호출결과를 ModelAndView 객체에 담음
		mav = rs.myRecipeList(rname);
		// ModelAndView 객체를 리턴
		return mav;
	}
	
	//내 신고내역
	@RequestMapping(value="/myreport")
	public ModelAndView myReport(@RequestParam("rpname") String rpname) {
		// 서비스클래스의 myReport 메소드를 호출하고 호출결과를 ModelAndView 객체에 담음
		mav = rs.myReport(rpname);
		// ModelAndView 객체를 리턴
		return mav;
	}
	
//	//내가 구매한 레시피 목록
//	@RequestMapping(value="/mybuyrecipe")
//	public ModelAndView myBuyRecipe() {
//		mav = rs.myBuyRecipe();
//		return mav;
//	}

// 신고 상세조회
	@RequestMapping(value="/reportview")
	public ModelAndView reportView(@RequestParam("rpnumber") int rpnumber) {
		mav = rs.reportView(rpnumber);
		return mav;
	}
	
// 수정화면 요청
	@RequestMapping(value="/reportupdate")
	public ModelAndView reportUpdate(@RequestParam("rpnumber") int rpnumber) {
		mav = rs.reportUpdate(rpnumber);
		return mav;
	}
		
//수정 처리
	@RequestMapping(value="/reportupdateprocess")
	public ModelAndView reportUpdateProcess(@ModelAttribute ReportDTO report) {
		mav = rs.reportUpdateProcess(report);
		return mav;
	}	
}

package recipe.shop.mall.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import recipe.shop.mall.dao.RecipeCommentDAO;
import recipe.shop.mall.dao.RecipeDAO;
import recipe.shop.mall.dto.CommentDTO;
import recipe.shop.mall.dto.MaterialDTO;
import recipe.shop.mall.dto.OrderDTO;
import recipe.shop.mall.dto.PageDTO;
import recipe.shop.mall.dto.RecipeDTO;
import recipe.shop.mall.dto.ReportDTO;

@Service
public class RecipeService {

	@Autowired
	private RecipeDAO rdao;
	
	@Autowired
	private RecipeCommentDAO rcdao;
	
	private ModelAndView mav;
	
	// 페이징 처리에 활용할 상수
	private static final int PAGE_LIMIT = 5; // 한페이지에 보여질 글 개수
	private static final int BLOCK_LIMIT = 5; // 한화면에 보여질 페이지 개수
	
	public ModelAndView recipeList(int page) {
		
		mav = new ModelAndView();
		
		int listCount = rdao.listCount();
		
		int startRow = (page-1) * PAGE_LIMIT + 1;
		int endRow = page * PAGE_LIMIT;
		
		PageDTO paging = new PageDTO();
		paging.setStartRow(startRow);
		paging.setEndRow(endRow);
		
		List<RecipeDTO> recipeList = rdao.recipeList(paging);
		
		int maxPage = (int)(Math.ceil((double)listCount / PAGE_LIMIT));
		int startPage = (((int)(Math.ceil((double)page / BLOCK_LIMIT))) - 1) * BLOCK_LIMIT + 1;
		int endPage = startPage + BLOCK_LIMIT - 1;
		
		if(endPage > maxPage)
			endPage = maxPage;
		
		paging.setPage(page);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
		paging.setMaxPage(maxPage);
		
		mav.addObject("paging", paging);
		mav.addObject("recipeList", recipeList);
		mav.setViewName("recipelist");
		
		return mav;
	}

	public ModelAndView recipeWrite(RecipeDTO recipe, MaterialDTO material, OrderDTO order) throws IllegalStateException, IOException {
		mav = new ModelAndView();
		
		System.out.println("recipeDto : "+recipe);
		System.out.println("materialDTO : "+material);
		System.out.println("orderDTO : "+order);
				
		MultipartFile rfile = recipe.getRfile();
		MultipartFile ofile1 = order.getOfile1();
		MultipartFile ofile2 = order.getOfile2();
		MultipartFile ofile3 = order.getOfile3();
		MultipartFile ofile4 = order.getOfile4();
		MultipartFile ofile5 = order.getOfile5();

		String rfilename = rfile.getOriginalFilename();
		String ofilename1 = ofile1.getOriginalFilename();
		String ofilename2 = ofile1.getOriginalFilename();
		String ofilename3 = ofile3.getOriginalFilename();
		String ofilename4 = ofile4.getOriginalFilename();
		String ofilename5 = ofile5.getOriginalFilename();
		
		rfilename = System.currentTimeMillis() + "-" + rfilename;
		ofilename1 = System.currentTimeMillis() + "-" + ofilename1;
		ofilename2 = System.currentTimeMillis() + "-" + ofilename2;
		ofilename3 = System.currentTimeMillis() + "-" + ofilename3;
		ofilename4 = System.currentTimeMillis() + "-" + ofilename4;
		ofilename5 = System.currentTimeMillis() + "-" + ofilename5;
		
		String rsavePath = "D:\\2021_academy\\source_phs\\spring\\spring\\RecipeShop\\src\\main\\webapp\\resources\\upload\\recipe_b\\"+rfilename;
		String osavePath1 = "D:\\2021_academy\\source_phs\\spring\\spring\\RecipeShop\\src\\main\\webapp\\resources\\upload\\recipe_b\\"+ofilename1;
		String osavePath2 = "D:\\2021_academy\\source_phs\\spring\\spring\\RecipeShop\\src\\main\\webapp\\resources\\upload\\recipe_b\\"+ofilename2;
		String osavePath3 = "D:\\2021_academy\\source_phs\\spring\\spring\\RecipeShop\\src\\main\\webapp\\resources\\upload\\recipe_b\\"+ofilename3;
		String osavePath4 = "D:\\2021_academy\\source_phs\\spring\\spring\\RecipeShop\\src\\main\\webapp\\resources\\upload\\recipe_b\\"+ofilename4;
		String osavePath5 = "D:\\2021_academy\\source_phs\\spring\\spring\\RecipeShop\\src\\main\\webapp\\resources\\upload\\recipe_b\\"+ofilename5;
		
		if(!rfile.isEmpty()) {
			rfile.transferTo(new File(rsavePath));
		}
		
		if(!ofile1.isEmpty()) {
			ofile1.transferTo(new File(osavePath1));
		}
		
		if(!ofile2.isEmpty()) {
			ofile2.transferTo(new File(osavePath2));
		}
		
		if(!ofile3.isEmpty()) {
			ofile3.transferTo(new File(osavePath3));
		}
		
		if(!ofile4.isEmpty()) {
			ofile4.transferTo(new File(osavePath4));
		}
		
		if(!ofile5.isEmpty()) {
			ofile5.transferTo(new File(osavePath5));
		}
		
		recipe.setRfilename(rfilename);
		order.setOfilename1(ofilename1);
		order.setOfilename2(ofilename2);
		order.setOfilename3(ofilename3);
		order.setOfilename4(ofilename4);
		order.setOfilename5(ofilename5);
		
		rdao.recipeWrite(recipe);
		
		int rwn = 0;
		rwn = rdao.recipeWriteNumber();
		
		System.out.println("등록한 레시피 번호 : " + rwn);
		
		material.setMtrnumber(rwn);
		order.setOrnumber(rwn);
		
		System.out.println("레시피번호 가져온 후");
		System.out.println("materialDTO : "+material);
		System.out.println("orderDTO : "+order);
		
		rdao.materialWrite(material);
		rdao.orderWrite(order);
		
		mav.setViewName("redirect:/recipelist");
				
		return mav;
	}

	public ModelAndView recipeView(int rnumber) {
		mav = new ModelAndView();
		
		RecipeDTO recipeView = rdao.recipeView(rnumber);
		recipeView.setRhits(recipeView.getRhits()+1);
		rdao.updateHits(recipeView);
		
		MaterialDTO materialView = rdao.materialView(rnumber);
		OrderDTO orderView = rdao.orderView(rnumber);
		
		List<CommentDTO> commentList = rcdao.recipeCommentList(rnumber);
				
		mav.addObject("recipeView", recipeView);
		mav.addObject("materialView", materialView);
		mav.addObject("orderView", orderView);
		mav.addObject("commentList", commentList);
		
		mav.setViewName("recipeview");
		
		return mav;
	}

	public ModelAndView recipeReport(int rnumber) {
		mav = new ModelAndView();
		RecipeDTO recipeReport = rdao.recipeView(rnumber);
		
		mav.addObject("recipeReport", recipeReport);
		mav.setViewName("recipereport");
		
		return mav;
	}

	public ModelAndView recipeReportProcess(ReportDTO report) {
		mav = new ModelAndView();
		
		rdao.recipeReportProcess(report);
		mav.setViewName("redirect:/recipeview?rnumber="+report.getRprnumber());
		
		return mav;
	}

	public ModelAndView recipeDelete(int rnumber) {
		mav = new ModelAndView();
		rdao.recipeDelete(rnumber);
		
		mav.setViewName("redirect:/recipelist");		
		return mav;
	}

	public ModelAndView recipeUpdate(int rnumber) {
		mav = new ModelAndView();
		
		RecipeDTO recipe = rdao.recipeView(rnumber);
		MaterialDTO material = rdao.materialView(rnumber);
		OrderDTO order = rdao.orderView(rnumber);
		
		mav.addObject("recipeUpdate", recipe);
		mav.addObject("materialUpdate", material);
		mav.addObject("orderUpdate", order);
		mav.setViewName("recipeupdate");
		return mav;
	}

	public ModelAndView recipeUpdateProcess(RecipeDTO recipe, MaterialDTO material, OrderDTO order) throws IllegalStateException, IOException {

		mav = new ModelAndView();
		
		MultipartFile rfile = recipe.getRfile();
		MultipartFile ofile1 = order.getOfile1();
		MultipartFile ofile2 = order.getOfile2();
		MultipartFile ofile3 = order.getOfile3();
		MultipartFile ofile4 = order.getOfile4();
		MultipartFile ofile5 = order.getOfile5();

		String rfilename = rfile.getOriginalFilename();
		String ofilename1 = ofile1.getOriginalFilename();
		String ofilename2 = ofile1.getOriginalFilename();
		String ofilename3 = ofile3.getOriginalFilename();
		String ofilename4 = ofile4.getOriginalFilename();
		String ofilename5 = ofile5.getOriginalFilename();
		
		rfilename = System.currentTimeMillis() + "-" + rfilename;
		ofilename1 = System.currentTimeMillis() + "-" + ofilename1;
		ofilename2 = System.currentTimeMillis() + "-" + ofilename2;
		ofilename3 = System.currentTimeMillis() + "-" + ofilename3;
		ofilename4 = System.currentTimeMillis() + "-" + ofilename4;
		ofilename5 = System.currentTimeMillis() + "-" + ofilename5;
		
		String rsavePath = "D:\\2021_academy\\source_phs\\spring\\spring\\RecipeShop\\src\\main\\webapp\\resources\\upload\\recipe_b\\"+rfilename;
		String osavePath1 = "D:\\2021_academy\\source_phs\\spring\\spring\\RecipeShop\\src\\main\\webapp\\resources\\upload\\recipe_b\\"+ofilename1;
		String osavePath2 = "D:\\2021_academy\\source_phs\\spring\\spring\\RecipeShop\\src\\main\\webapp\\resources\\upload\\recipe_b\\"+ofilename2;
		String osavePath3 = "D:\\2021_academy\\source_phs\\spring\\spring\\RecipeShop\\src\\main\\webapp\\resources\\upload\\recipe_b\\"+ofilename3;
		String osavePath4 = "D:\\2021_academy\\source_phs\\spring\\spring\\RecipeShop\\src\\main\\webapp\\resources\\upload\\recipe_b\\"+ofilename4;
		String osavePath5 = "D:\\2021_academy\\source_phs\\spring\\spring\\RecipeShop\\src\\main\\webapp\\resources\\upload\\recipe_b\\"+ofilename5;

		if(!rfile.isEmpty()) {
			rfile.transferTo(new File(rsavePath));
			recipe.setRfilename(rfilename);
		}
		
		if(!ofile1.isEmpty()) {
			ofile1.transferTo(new File(osavePath1));
			order.setOfilename1(ofilename1);
		}
		
		if(!ofile2.isEmpty()) {
			ofile2.transferTo(new File(osavePath2));
			order.setOfilename2(ofilename2);
		}
		
		if(!ofile3.isEmpty()) {
			ofile3.transferTo(new File(osavePath3));
			order.setOfilename3(ofilename3);
		}
		
		if(!ofile4.isEmpty()) {
			ofile4.transferTo(new File(osavePath4));
			order.setOfilename4(ofilename4);
		}
		
		if(!ofile5.isEmpty()) {
			ofile5.transferTo(new File(osavePath5));
			order.setOfilename5(ofilename5);
		}
		
		System.out.println("수정");
		System.out.println(recipe);
		System.out.println(material);
		System.out.println(order);
		
		rdao.recipeUpdate(recipe);
		rdao.materialUpdate(material);
		rdao.orderUpdate(order);
		
//		mav.setViewName("redirect:/recipeview?rnumber="+recipe.getRnumber());
		mav.setViewName("redirect:/recipelist");
		return mav;
	}

	public ModelAndView recipeRanking() {
		mav = new ModelAndView();
		
		List<RecipeDTO> recipeRanking = rdao.recipeRanking();
		
		mav.addObject("recipeRanking", recipeRanking);
		mav.setViewName("reciperanking");
		return mav;
	}

	public ModelAndView recipeSearch(String keyword) {
		mav = new ModelAndView();
		
		List<RecipeDTO> recipeList = rdao.recipeSearch(keyword);
		
		mav.addObject("recipeList", recipeList);
		mav.setViewName("recipelist");
		return mav;
	}
	
	public ModelAndView totalReport() {
		// ModelAndView 객체 생성
		mav = new ModelAndView();
		// DAO 호출해서 reportList에 담음
		List<ReportDTO> reportList = rdao.totalReport();
		mav.addObject("totalreport", reportList);
		// reportlist.jsp 출력
		mav.setViewName("reportlist");
		// ModelAndView 객체 리턴
		return mav;
	}
	
	public ModelAndView myRecipeList(String rname) {
		// ModelAndView 객체 생성
		mav = new ModelAndView();
		// DAO 호출해서 myRecipeList에 담음
		List<RecipeDTO> myRecipeList = rdao.myRecipeList(rname);
		mav.addObject("myrecipelist", myRecipeList);
		// myrecipelist.jsp 출력
		mav.setViewName("myrecipelist");
		// ModelAndView 객체 리턴
		return mav;
	}
	
	public ModelAndView myReport(String rpname) {
		// ModelAndView 객체 생성
		mav = new ModelAndView();
		// DAO 호출해서 reportList에 담음
		List<ReportDTO> reportList = rdao.myReport(rpname);
		mav.addObject("myreport", reportList);
		// myreport.jsp 출력
		mav.setViewName("myreport");
		// ModelAndView 객체 리턴
		return mav;
	}

	public ModelAndView reportView(int rpnumber) {
		mav = new ModelAndView();
		ReportDTO reportView = rdao.reportView(rpnumber);
		mav.addObject("reportview", reportView);
		mav.setViewName("reportview");
		return mav;
	}
	
	public ModelAndView reportUpdate(int rpnumber) {
		mav = new ModelAndView();
		ReportDTO reportUpdate = rdao.reportView(rpnumber);
		mav.addObject("reportupdate", reportUpdate);
		mav.setViewName("reportupdate");
		return mav;
	}

	public ModelAndView reportUpdateProcess(ReportDTO report) {
		mav = new ModelAndView();
		int reportUpdateResult = rdao.reportUpdateProcess(report);
		if(reportUpdateResult > 0) {
			mav.setViewName("redirect:/reportlist");
		} 
		return mav;
	}

	public ModelAndView categorySearch(String keyword) {
		mav = new ModelAndView();
		
		List<RecipeDTO> recipeList = rdao.categorySearch(keyword);
		
		mav.addObject("recipeList", recipeList);
		mav.setViewName("recipelist");
		return mav;
	}

//	public ModelAndView myBuyRecipe() {
//		mav = new ModelAndView();
//		session.getAttribute("loginMember");
//		List<PurchaserDTO> myBuyRecipe = rdao.myBuyRecipe();
//		mav.addObject("mybuyrecipe", myBuyRecipe);		
//		mav.setViewName("mybuyrecipe");
//		return mav;
//	}
	
}

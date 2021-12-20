package recipe.shop.mall.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import recipe.shop.mall.dao.ShopCommentDAO;
import recipe.shop.mall.dao.ShopDAO;
import recipe.shop.mall.dto.ShopCommentDTO;
import recipe.shop.mall.dto.ShopDTO;

@Service
public class ShopService {
	
	
	@Autowired
	private ShopDAO sdao;
	
	private ModelAndView mav;
	
	@Autowired
	private ShopCommentDAO scdao;

	
	
	// 재료 등록 처리
	@SuppressWarnings("unused")
	public ModelAndView ShopAdd(ShopDTO shopadd) throws IllegalStateException, IOException {
		mav = new ModelAndView();
		MultipartFile sfile = shopadd.getSfile();
		String sfilename = sfile.getOriginalFilename();

		
		sfilename = System.currentTimeMillis() + "-" + sfilename;
		System.out.println("boardWriteFile 메소드 " + sfilename);
//		String savePath = "C:\\개발환경IDE\\suoe\\spring\\RecipeShop\\src\\main\\webapp\\resources\\upload\\"+sfilename;
//		String savePath = "D:\\source_phs\\spring\\RecipeShop\\src\\main\\webapp\\resources\\upload\\shop\\"+sfilename;
		String savePath = "D:\\2021_academy\\source_phs\\spring\\spring\\RecipeShop\\src\\main\\webapp\\resources\\upload\\shop_b\\"+sfilename;
//		String savePath = "D:\\2021_academy\\source_phs\\spring\\spring\\RecipeShop\\src\\main\\webapp\\resources\\upload\\shop\\"+sfilename;
		
		if(!sfile.isEmpty()) {
			sfile.transferTo(new File(savePath));
		}
		
		
		
		shopadd.setSfilename(sfilename);
		sdao.shopadd(shopadd);
		
		mav.setViewName("redirect:/shoplist");
		
		return mav;
	}


	// 상품 목록
	public ModelAndView ShopList() {
		mav = new ModelAndView();
		List<ShopDTO> shopList = sdao.ShopList();
		
		mav.addObject("ShopList", shopList);
		mav.setViewName("shoplist");
		
		return mav;
	}

	// 상품목록 상세조회
	public ModelAndView ShopView(int snumber) {
		mav = new ModelAndView();
		
		ShopDTO shopview = sdao.ShopView(snumber);
		mav.addObject("shopview", shopview);

		List<ShopCommentDTO> srcommentList = scdao.ShopCommentList(snumber);
		mav.addObject("srcommentList", srcommentList);
		mav.setViewName("shopview");
		return mav;
	}

	// 재료 수정 화면 요청
	public ModelAndView shopUpdate(int snumber) {
		mav = new ModelAndView();
		ShopDTO shopupdate = sdao.ShopView(snumber);
		mav.addObject("shopUpdate", shopupdate);
		mav.setViewName("shopupdate");
		return mav;
	}


	// 수정 처리
	public ModelAndView updateProcess(ShopDTO shop) throws IllegalStateException, IOException {
		mav = new ModelAndView();
		MultipartFile sfile = shop.getSfile();
		String sfilenameupdate = sfile.getOriginalFilename();
		

		sfilenameupdate = System.currentTimeMillis() + "-" + sfilenameupdate;
		System.out.println("boardWriteFile 메소드 " + sfilenameupdate);
//		String savePath = "C:\\개발환경IDE\\suoe\\spring\\RecipeShop\\src\\main\\webapp\\resources\\upload\\"+sfilenameupdate;
		String savePath = "D:\\2021_academy\\source_phs\\spring\\spring\\RecipeShop\\src\\main\\webapp\\resources\\upload\\shop_b\\"+sfilenameupdate;
		
		//		String savePath = "D:\\2021_academy\\source_phs\\spring\\spring\\RecipeShop\\src\\main\\webapp\\resources\\upload\\shop\\"+sfilenameupdate;
		
		if(!sfile.isEmpty()) {
			sfile.transferTo(new File(savePath));
		}
		
		
		shop.setSfilename(sfilenameupdate);
		sdao.shopupdate(shop);
		
		mav.setViewName("redirect:/shoplist");
		return mav;
	}

	
	// 재료삭제
	public ModelAndView shopDelete(int snumber) {
		mav = new ModelAndView();
		int deleteResult = sdao.shopDelete(snumber);
		if(deleteResult > 0) {
			mav.setViewName("redirect:/shoplist");
		}
		return mav;
	}


	// 재료 검색
		public ModelAndView shopSearch(String keyword) {
			mav = new ModelAndView();
			
			List<ShopDTO> shopList = sdao.shopSearch(keyword);
			
			mav.addObject("ShopList", shopList);
			mav.setViewName("shoplist");
			return mav;
		}
//	public ModelAndView shop() {
//		mav = new ModelAndView();
//		List<ShopDTO> shopList = sdao.Shop();
//		
//		mav.addObject("ShopList", shopList);
//		mav.setViewName("shop");
//		
//		return mav;
//	}






}

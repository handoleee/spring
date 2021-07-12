package com.cafe.board.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cafe.board.dao.ContentsDAO;
import com.cafe.board.dto.BrandDTO;
import com.cafe.board.dto.ContentsDTO;
import com.cafe.board.dto.ContentsPageDTO;

@Service
public class ContentsService {

	@Autowired
	private ContentsDAO cdao;
	
	private ModelAndView mav;
	
	
	private static final int PAGE_LIMIT = 3;
	private static final int BLOCK_LIMIT = 3;
	
	public ModelAndView contentsList(int page) {
		mav = new ModelAndView();
		ContentsPageDTO paging = new ContentsPageDTO();
		
		int listCount = cdao.listCount();
		int startRow = (page-1) * PAGE_LIMIT + 1;
		int endRow = page * PAGE_LIMIT;
		
		paging.setStartRow(startRow);
		paging.setEndRow(endRow);
		List<ContentsDTO> contentsList = cdao.contentsList(paging);
		
		int maxPage = (int)(Math.ceil((double)listCount / PAGE_LIMIT));
		int startPage = (((int)(Math.ceil((double)page / BLOCK_LIMIT))) - 1) * BLOCK_LIMIT + 1;
		int endPage = startPage + BLOCK_LIMIT - 1;
		if(endPage > maxPage)
			endPage = maxPage;
		
		
		paging.setPage(page);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
		paging.setMaxPage(maxPage);
		
		
		
		mav.addObject("contents", contentsList);
		mav.setViewName("contentslist");
		mav.addObject("paging", paging);
		return mav;
	}
	
	public ModelAndView brandList(ContentsDTO contents) {
		List<BrandDTO> brandList = new ArrayList<BrandDTO>();
		brandList = cdao.brandList(contents);
		
		mav.addObject("brand", brandList);
//		mav.setViewName("redirect:/brandlist");
		return mav;
	}
	
	public ModelAndView adminMenu(ContentsDTO contents) throws IllegalStateException, IOException {
		mav = new ModelAndView();
		
		MultipartFile cpic = contents.getCpic();
		String cpicname = cpic.getOriginalFilename();
		cpicname = System.currentTimeMillis() + "-" + cpicname;
		System.out.println("메뉴 추가 "+cpicname);
//		String savePath = "D:\\source_phs\\spring\\spring\\CafeBoard\\src\\main\\webapp\\resources\\menupicture\\"+cpicname;
		String savePath = "D:\\phs\\source_phs\\spring\\spring\\CafeBoard\\src\\main\\webapp\\resources\\menupicture\\"+cpicname;
		if(!cpic.isEmpty()) {
			cpic.transferTo(new File(savePath));
		}
		contents.setCpicname(cpicname);
		cdao.adminMenu(contents);
		mav.setViewName("redirect:/contentslist");
		return mav;
		}

	public ModelAndView menuDelete(int cnumber) {
		mav = new ModelAndView();
		cdao.menuDelete(cnumber);
		mav.setViewName("redirect:/contentslist");
		return mav;
	}

	public ModelAndView menuUpdate(int cnumber) {
		mav = new ModelAndView();
		ContentsDTO contents = cdao.menuView(cnumber);
		mav.addObject("menuUpdate", contents);
		mav.setViewName("menuupdate");
		return mav;
	}

	public ModelAndView menuUpdateProcess(ContentsDTO contents) {
		mav = new ModelAndView();
		int updateResult = cdao.menuUpdateProcess(contents);
		
		if(updateResult > 0) {
//			일단, contentslist로 하고, view 
			mav.setViewName("redirect:/menuview?cnumber="+contents.getCnumber());
		} 
		return mav;
	}

	public ModelAndView menuView(int cnumber, int page) {
		ContentsDTO contents = cdao.menuView(cnumber);
		mav.addObject("page", page);
		
		mav.addObject("contents", contents);
		mav.setViewName("menuview");
		return mav;
	}

	public ModelAndView menuSearch(String searchType, String keyword) {
		mav = new ModelAndView();
		
		Map<String, String> searchMap = new HashMap<String, String>();
		searchMap.put("type", searchType);
		searchMap.put("word", keyword);
		
		List<ContentsDTO> contentsList = cdao.menuSearch(searchMap);
		mav.addObject("contents", contentsList);
		mav.setViewName("contentslist");
		return mav;
	}
}

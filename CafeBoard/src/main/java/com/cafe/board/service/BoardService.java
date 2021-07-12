package com.cafe.board.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cafe.board.dao.BoardDAO;
import com.cafe.board.dto.BoardDTO;
import com.cafe.board.dto.BoardPageDTO;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO bdao;

	private ModelAndView mav;

	public ModelAndView boardWrite(BoardDTO board) throws IllegalStateException, IOException {
		mav= new ModelAndView();
		
		MultipartFile bpic = board.getBpic();
		String bpicname = bpic.getOriginalFilename();
		bpicname = System.currentTimeMillis() + "-" + bpicname;
		System.out.println("boardwrite:"+bpicname);
//		String savePath = "D:\\source_phs\\spring\\spring\\CafeBoard\\src\\main\\webapp\\resources\\boardpicture\\"+bpicname;
		String savePath = "D:\\phs\\source_phs\\spring\\spring\\CafeBoard\\src\\main\\webapp\\resources\\boardpicture\\"+bpicname;
		
		if(!bpic.isEmpty()) {
			bpic.transferTo(new File(savePath));
		}
		
		board.setBpicname(bpicname);
		bdao.boardWrite(board);
		
		mav.setViewName("redirect:/boardlist");
		return mav;
	}
	
	private static final int PAGE_LIMIT = 3;
	private static final int BLOCK_LIMIT = 3;

	public ModelAndView boardList(int page) {
		mav = new ModelAndView();
		
		BoardPageDTO paging = new BoardPageDTO();
		
		int listCount = bdao.listCount();
		int startRow = (page-1) * PAGE_LIMIT + 1;
		int endRow = page * PAGE_LIMIT;
		
		paging.setStartRow(startRow);
		paging.setEndRow(endRow);
		List<BoardDTO> boardList = bdao.boardList(paging);
		
		int maxPage = (int)(Math.ceil((double)listCount / PAGE_LIMIT));
		int startPage = (((int)(Math.ceil((double)page / BLOCK_LIMIT))) -1) * BLOCK_LIMIT + 1;
		int endPage = startPage + BLOCK_LIMIT - 1;
		if(endPage > maxPage)
			endPage = maxPage;
		
		paging.setPage(page);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
		paging.setMaxPage(maxPage);
		
		mav.addObject("board", boardList);
		mav.setViewName("boardlist");
		mav.addObject("paging", paging);
		System.out.println("페이징값"+paging);
		return mav;
	}

	public ModelAndView boardView(int bnumber, int page) {
		bdao.boardHits(bnumber);
		BoardDTO board = bdao.boardView(bnumber);
		mav.addObject("page", page);
		
		mav.addObject("board", board);
		mav.setViewName("boardview");
		return mav;
		
	}

	public ModelAndView boardUpdate(int bnumber) {
		mav = new ModelAndView();
		BoardDTO board = bdao.boardView(bnumber);
		mav.addObject("boardUpdate", board);
		mav.setViewName("boardupdate");
		return mav;
	}

	public ModelAndView boardUpdateProcess(BoardDTO board) {
		mav = new ModelAndView();
		int updateResult = bdao.boardUpdateProcess(board);
		if(updateResult > 0) {
			mav.setViewName("redirect:/boardview?bnumber="+board.getBnumber());
		}
		return mav;
	}

	public ModelAndView boardDelete(int bnumber) {
		mav = new ModelAndView();
		int deleteResult = bdao.boardDelete(bnumber);
		if(deleteResult > 0) {
			mav.setViewName("redirect:/boardlist");
		}
		return mav;
	}

	public ModelAndView boardSearch(String searchType, String keyword) {
		mav = new ModelAndView();
		
		Map<String, String> searchMap = new HashMap<String, String>();
		searchMap.put("type", searchType);
		searchMap.put("word", keyword);
		
		List<BoardDTO> boardList = bdao.boardSearch(searchMap);
		mav.addObject("board", boardList);
		mav.setViewName("boardlist");
		return mav;
	}
	

}

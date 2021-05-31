package com.icia.board.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icia.board.dao.BoardDAO;
import com.icia.board.dto.BoardDTO;

@Service
public class BoardService {

	@Autowired
	private BoardDAO bdao;
	
	private ModelAndView mav;
	
	public ModelAndView boardWrite(BoardDTO board) {
		mav = new ModelAndView();
		int writeResult = bdao.boardWrite(board);
		
		// 글쓰기 성공 : 목록 출력(목록출력을 담당하는 컨트롤러의 주소를 요청해야함)
		// 글쓰기 실패 : boardwrite.jsp를 띄움
		if(writeResult > 0) {
			mav.setViewName("redirect:/boardlist");
		} else {
			mav.setViewName("boardwrite");
		}
		return mav;
		}
	
	public ModelAndView boardList() {
		mav = new ModelAndView();
		List<BoardDTO> boardList = bdao.boardList();
		
		mav.addObject("boardList", boardList);
		mav.setViewName("boardlist");
		
		return mav;
	}
	
	public ModelAndView boardView(int bnumber) {
		mav = new ModelAndView();
		// 1. 해당 글의 조회수 값 1증가(update 쿼리)
		// 2. 해당 글의 내용 가져오기(select 쿼리)
		bdao.boardHits(bnumber);
		BoardDTO board = bdao.boardView(bnumber);
		
		mav.addObject("boardView", board);
		mav.setViewName("boardview");
		return mav;
	}
	
	 public ModelAndView boardUpdate(int bnumber) {
			mav = new ModelAndView(); 
			//DB에서 bnumber 해당 데이터 가져와서 boardupdate.jsp 를 목적지로 지정
			BoardDTO board = bdao.boardView(bnumber); 
			mav.addObject("boardUpdate", board);
			mav.setViewName("boardupdate"); 
			return mav; 
		}

		 public ModelAndView updateProcess(BoardDTO board) {
			mav = new ModelAndView();
			int updateResult = bdao.updateProcess(board);
			if(updateResult > 0) {
				
			mav.setViewName("redirect:/boardlist"); // boardlist.jsp
			} else {
				// 2. 해당 글의 상세화면 출력
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

		public ModelAndView boardWriteFile(BoardDTO board) throws IllegalStateException, IOException {
			mav = new ModelAndView();
			// dto에 담긴 파일을 가져옴
			MultipartFile bfile = board.getBfile();
			// 파일 이름을 가져옴(파일이름을 DB에 저장하기 위해)
			String bfilename = bfile.getOriginalFilename();
			// 파일명 중복을 피하기 위해 파일이름앞에 현재 시간값을 붙임(자바 기본 메소드)
			bfilename = System.currentTimeMillis() + "-" + bfilename;
			System.out.println("boardWriteFile 메소드 " + bfilename);
			// 파일 저장하기
			/*String savePath = "D:\\source_phs\\spring\\spring\\Board210527\\src\\main\\webapp\\resources\\upload\\"+bfilename;*/
			String savePath = "D:\\한솔\\source_phs\\spring\\spring\\Board210527\\src\\main\\webapp\\resources\\upload\\"+bfilename;
			// bfile이 비어있지 않다면(즉 파일이 있으면) savePath에 저장을 하겠다.
			if(!bfile.isEmpty()) {
				bfile.transferTo(new File(savePath));
			}
			// throw 어쩌구 : 예외처리방식
			// 여기까지의 내용은 파일을 저장하는 과정(DB연결된거 아님)
			
			board.setBfilename(bfilename);
			bdao.boardWriteFile(board);
			
			mav.setViewName("redirect:/boardlist");
			return mav;
		}

}

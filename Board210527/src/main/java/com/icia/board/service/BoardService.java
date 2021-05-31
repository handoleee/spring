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
		
		// �۾��� ���� : ��� ���(�������� ����ϴ� ��Ʈ�ѷ��� �ּҸ� ��û�ؾ���)
		// �۾��� ���� : boardwrite.jsp�� ���
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
		// 1. �ش� ���� ��ȸ�� �� 1����(update ����)
		// 2. �ش� ���� ���� ��������(select ����)
		bdao.boardHits(bnumber);
		BoardDTO board = bdao.boardView(bnumber);
		
		mav.addObject("boardView", board);
		mav.setViewName("boardview");
		return mav;
	}
	
	 public ModelAndView boardUpdate(int bnumber) {
			mav = new ModelAndView(); 
			//DB���� bnumber �ش� ������ �����ͼ� boardupdate.jsp �� �������� ����
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
				// 2. �ش� ���� ��ȭ�� ���
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
			// dto�� ��� ������ ������
			MultipartFile bfile = board.getBfile();
			// ���� �̸��� ������(�����̸��� DB�� �����ϱ� ����)
			String bfilename = bfile.getOriginalFilename();
			// ���ϸ� �ߺ��� ���ϱ� ���� �����̸��տ� ���� �ð����� ����(�ڹ� �⺻ �޼ҵ�)
			bfilename = System.currentTimeMillis() + "-" + bfilename;
			System.out.println("boardWriteFile �޼ҵ� " + bfilename);
			// ���� �����ϱ�
			/*String savePath = "D:\\source_phs\\spring\\spring\\Board210527\\src\\main\\webapp\\resources\\upload\\"+bfilename;*/
			String savePath = "D:\\�Ѽ�\\source_phs\\spring\\spring\\Board210527\\src\\main\\webapp\\resources\\upload\\"+bfilename;
			// bfile�� ������� �ʴٸ�(�� ������ ������) savePath�� ������ �ϰڴ�.
			if(!bfile.isEmpty()) {
				bfile.transferTo(new File(savePath));
			}
			// throw ��¼�� : ����ó�����
			// ��������� ������ ������ �����ϴ� ����(DB����Ȱ� �ƴ�)
			
			board.setBfilename(bfilename);
			bdao.boardWriteFile(board);
			
			mav.setViewName("redirect:/boardlist");
			return mav;
		}

}

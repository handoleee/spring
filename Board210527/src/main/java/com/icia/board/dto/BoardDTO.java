package com.icia.board.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
// getter, setter, toString, 생성자를 자동으로 만들어줌
// Getter, Setter, ToString 선택해서 넣기도 가능 data가 제일 큼
public class BoardDTO {
	
	private int bnumber;
	private String btitle;
	private String bpassword;
	private String bwriter;
	private String bcontents;
	private String bdate;
	private int bhits;
	
	// 파일을 담기 위한 필드(boardwrite.jsp에서 Controller로 전달할 때)
	private MultipartFile bfile;
	
	// 파일명을 담기 위한 필드
	private String bfilename;
}
	
	
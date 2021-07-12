package com.cafe.board.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BoardDTO {
	private int bnumber;
	private String bwriter;
	private String btitle;
	private String bcontents;
	private int bhits;
	private String bdate;
	private MultipartFile bpic;
	private String bpicname;
	
}

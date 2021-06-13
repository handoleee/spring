package com.cafe.board.dto;

import lombok.Data;

@Data
public class BoardDTO {
	private int bnumber;
	private String bwriter;
	private String btitle;
	private String bcontents;
	private String bdate;
	private int bhits;
	
}

package com.icia.board.dto;

import lombok.Data;

//@Data
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
	
}
	
	
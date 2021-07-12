package com.cafe.board.dto;

import lombok.Data;

@Data
public class BoardPageDTO {
	private int page;
	private int maxPage;
	private int startPage;
	private int endPage;
	private int startRow;
	private int endRow;
}
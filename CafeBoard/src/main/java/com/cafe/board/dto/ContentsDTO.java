package com.cafe.board.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ContentsDTO {
	private String cbrand;
	private int cnumber;
	private String cname;
	private int cprice;
	private String csize;
	private String call;
	private String cscri;
	private MultipartFile cpic;
	private String cpicname;
}

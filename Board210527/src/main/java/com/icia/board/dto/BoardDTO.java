package com.icia.board.dto;

import org.springframework.web.multipart.MultipartFile;


//getter, setter, toString, 생성자를 자동으로 만들어줌
//Getter, Setter, ToString 선택해서 넣기도 가능 data가 제일 큼

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

	public int getBnumber() {
		return bnumber;
	}

	public void setBnumber(int bnumber) {
		this.bnumber = bnumber;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBpassword() {
		return bpassword;
	}

	public void setBpassword(String bpassword) {
		this.bpassword = bpassword;
	}

	public String getBwriter() {
		return bwriter;
	}

	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}

	public String getBcontents() {
		return bcontents;
	}

	public void setBcontents(String bcontents) {
		this.bcontents = bcontents;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public int getBhits() {
		return bhits;
	}

	public void setBhits(int bhits) {
		this.bhits = bhits;
	}

	public MultipartFile getBfile() {
		return bfile;
	}

	public void setBfile(MultipartFile bfile) {
		this.bfile = bfile;
	}

	public String getBfilename() {
		return bfilename;
	}

	public void setBfilename(String bfilename) {
		this.bfilename = bfilename;
	}

	@Override
	public String toString() {
		return "BoardDTO [bnumber=" + bnumber + ", btitle=" + btitle + ", bpassword=" + bpassword + ", bwriter="
				+ bwriter + ", bcontents=" + bcontents + ", bdate=" + bdate + ", bhits=" + bhits + ", bfile=" + bfile
				+ ", bfilename=" + bfilename + "]";
	}
}

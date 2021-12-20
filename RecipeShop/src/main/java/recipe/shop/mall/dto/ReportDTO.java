package recipe.shop.mall.dto;

import lombok.Data;

@Data
public class ReportDTO {
	private int rpnumber;
	private int rprnumber;
	private String rpname;
	private String rpcontents;
	private String rpcheck;
	private String rpanswer;
	public int getRpnumber() {
		return rpnumber;
	}
	public void setRpnumber(int rpnumber) {
		this.rpnumber = rpnumber;
	}
	public int getRprnumber() {
		return rprnumber;
	}
	public void setRprnumber(int rprnumber) {
		this.rprnumber = rprnumber;
	}
	public String getRpname() {
		return rpname;
	}
	public void setRpname(String rpname) {
		this.rpname = rpname;
	}
	public String getRpcontents() {
		return rpcontents;
	}
	public void setRpcontents(String rpcontents) {
		this.rpcontents = rpcontents;
	}
	public String getRpcheck() {
		return rpcheck;
	}
	public void setRpcheck(String rpcheck) {
		this.rpcheck = rpcheck;
	}
	public String getRpanswer() {
		return rpanswer;
	}
	public void setRpanswer(String rpanswer) {
		this.rpanswer = rpanswer;
	}
	
	
	
	
}

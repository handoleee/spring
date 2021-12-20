package recipe.shop.mall.dto;

import lombok.Data;

@Data
public class PurchaserDTO {
	private int pnumber;
	private int prnumber;
	private String pname;
	public int getPnumber() {
		return pnumber;
	}
	public void setPnumber(int pnumber) {
		this.pnumber = pnumber;
	}
	public int getPrnumber() {
		return prnumber;
	}
	public void setPrnumber(int prnumber) {
		this.prnumber = prnumber;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	
}

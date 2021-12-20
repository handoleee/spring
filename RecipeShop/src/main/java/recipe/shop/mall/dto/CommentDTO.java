package recipe.shop.mall.dto;

import lombok.Data;

@Data
public class CommentDTO {

	private int cnumber;
	private int crnumber;
	private String cname;
	private String ccontents;
	private String cgrade;
	public int getCnumber() {
		return cnumber;
	}
	public void setCnumber(int cnumber) {
		this.cnumber = cnumber;
	}
	public int getCrnumber() {
		return crnumber;
	}
	public void setCrnumber(int crnumber) {
		this.crnumber = crnumber;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCcontents() {
		return ccontents;
	}
	public void setCcontents(String ccontents) {
		this.ccontents = ccontents;
	}
	public String getCgrade() {
		return cgrade;
	}
	public void setCgrade(String cgrade) {
		this.cgrade = cgrade;
	}
	
}

package recipe.shop.mall.dto;

import lombok.Data;

@Data
public class MemberDTO {
	private String mid;
	private String mpassword;
	private String mname;
	private String mphone;
	private String maddr1;
	private String maddr2;
	private String maddr3;
	private int mpoint;
	private String memail;
}
package recipe.shop.mall.dto;

import lombok.Data;

@Data
public class CartDTO {
		
		private int sbnumber;
		private String sbmid;
		private String sbname;
		private int sbsnumber;
		private int sbquantity;
		private int sbprice;
		private int sum;	
}

package recipe.shop.mall.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class RecipeDTO {
	private int rnumber;
	private String rname;
	private String rtitle;
	private String rcontents;
	private String rcategory;
	private String rperson;
	private String rtag;
	private int rprice;
	private MultipartFile rpic;
	private String rpicname;
	private String rlevel;
}

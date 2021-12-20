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
	private String rprice;
	private MultipartFile rfile;
	private String rfilename;
	private String rlevel;
	private int rhits;
	private int rlikes;
}

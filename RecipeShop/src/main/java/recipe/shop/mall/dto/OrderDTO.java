package recipe.shop.mall.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class OrderDTO {

	private int onumber;
	private int ornumber;
	private String ofilename1;
	private String ocontents1;
	private MultipartFile ofile1;
	
	private String ofilename2;
	private String ocontents2;
	private MultipartFile ofile2;
	
	private String ofilename3;
	private String ocontents3;
	private MultipartFile ofile3;
	
	private String ofilename4;
	private String ocontents4;
	private MultipartFile ofile4;
	
	private String ofilename5;
	private String ocontents5;
	private MultipartFile ofile5;
	
}

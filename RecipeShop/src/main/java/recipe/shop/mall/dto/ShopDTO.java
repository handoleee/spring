 package recipe.shop.mall.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ShopDTO {
	private int snumber; // 재료번호
	private String sname; // 재료이름
	private int sprice; // 가격
	private int sstock; // 재고
	private String sorigin; // 원산지
	private String smake; // 제조사
	private String sbox; // 구성
	private String stime; // 유통기한
	private String scontents; // 상세정보
	private MultipartFile sfile; // 대표사진
	private String sfilename; // 파일을 담긴 위한 필드

}

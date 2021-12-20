package recipe.shop.mall.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import recipe.shop.mall.dao.ShopCommentDAO;
import recipe.shop.mall.dto.ShopCommentDTO;

@Service
public class ShopCommentService {

	@Autowired
	private ShopCommentDAO scdao;
	
	private ModelAndView mav;
	
	public List<ShopCommentDTO> ShopCommentWrite(ShopCommentDTO srcomment) {

		int writeResult = scdao.ShopCommentWrite(srcomment);
		List<ShopCommentDTO> srcommentList = new ArrayList<ShopCommentDTO>();
		
		if(writeResult > 0)
			srcommentList = scdao.ShopCommentList(srcomment.getSrsnumber());
		else
			srcommentList = null;
		
		return srcommentList;
	}
	
	
//	List<ShopCommentDTO> srcommentList = scdao.ShopCommentList(snumber);
//	mav.addObject("srcommentList", srcommentList);
	


	



}

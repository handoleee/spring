package recipe.shop.mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import recipe.shop.mall.dto.ShopCommentDTO;
import recipe.shop.mall.service.ShopCommentService;

@Controller

public class ShopCommentController {
	
	@Autowired
	private ShopCommentService scs;
	
	private ModelAndView mav;
	
	@RequestMapping(value = "srcommentwrite")
	public @ResponseBody List<ShopCommentDTO> shopCommentWrite(@ModelAttribute ShopCommentDTO srcomment) {
		List<ShopCommentDTO> srcommentList = scs.ShopCommentWrite(srcomment);
		return srcommentList;
	}
	
	

}

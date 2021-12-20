package recipe.shop.mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import recipe.shop.mall.dto.CommentDTO;
import recipe.shop.mall.service.RecipeCommentService;

@Controller
@RequestMapping("/comment/*")
public class RecipeCommentController {
	
	@Autowired
	private RecipeCommentService rcs;
	
	private ModelAndView mav;
	
	@RequestMapping(value = "commentwrite")
	public @ResponseBody List<CommentDTO> recipeCommentWrite(@ModelAttribute CommentDTO comment) {
		List<CommentDTO> commentList = rcs.recipeCommentWrite(comment);
		return commentList;
	}
	
	@RequestMapping(value = "rcommentdelete")
	public ModelAndView recipeCommentDelete(@RequestParam("cnumber") int cnumber,
									@RequestParam("rnumber") int rnumber) {
		mav = rcs.recipeCommentDelete(cnumber, rnumber);
		return mav;
	}
	
	@RequestMapping(value = "rcommentupdate")
	public ModelAndView recipeCommentUpdate(@RequestParam("cnumber") int cnumber) {
		mav = rcs.recipeCommentUpdate(cnumber);
		return mav;
	}
	
	@RequestMapping(value = "rcommentupdateprocess")
	public ModelAndView recipeCommentUpdateProcess(@ModelAttribute CommentDTO comment) {
		mav = rcs.recipeCommentUpdateProcess(comment);
		return mav;
	}

}

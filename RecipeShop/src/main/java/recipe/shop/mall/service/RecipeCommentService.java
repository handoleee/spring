package recipe.shop.mall.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import recipe.shop.mall.dao.RecipeCommentDAO;
import recipe.shop.mall.dto.CommentDTO;

@Service
public class RecipeCommentService {

	@Autowired
	private RecipeCommentDAO rcdao;
	
	private ModelAndView mav;
	
	public List<CommentDTO> recipeCommentWrite(CommentDTO comment) {

		int writeResult = rcdao.recipeCommentWrite(comment);
		List<CommentDTO> commentList = new ArrayList<CommentDTO>();
		
		if(writeResult > 0)
			commentList = rcdao.recipeCommentList(comment.getCrnumber());
		else
			commentList = null;
		
		return commentList;
	}

	public ModelAndView recipeCommentDelete(int cnumber, int rnumber) {
		mav = new ModelAndView();
		rcdao.recipeCommentDelete(cnumber);
		
		mav.setViewName("redirect:/recipeview?rnumber="+rnumber);
		
		return mav;
	}

	public ModelAndView recipeCommentUpdate(int cnumber) {
		mav = new ModelAndView();
		
		CommentDTO commentUpdate = rcdao.recipeCommentUpdate(cnumber);
		
		mav.addObject("commentUpdate", commentUpdate);
		mav.setViewName("commentupdate");
		
		return mav;
	}

	public ModelAndView recipeCommentUpdateProcess(CommentDTO comment) {
		mav = new ModelAndView();
		
		int updateResult = 0;
		updateResult = rcdao.recipeCommentUpdateProcess(comment);
		if(updateResult > 0)
			mav.setViewName("redirect:/recipeview?rnumber="+comment.getCrnumber());
		else
			mav.setViewName("updatefail");
		
		return mav;
	}



}

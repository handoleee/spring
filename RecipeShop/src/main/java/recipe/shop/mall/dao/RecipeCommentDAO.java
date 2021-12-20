package recipe.shop.mall.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import recipe.shop.mall.dto.CommentDTO;

@Repository
public class RecipeCommentDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	public int recipeCommentWrite(CommentDTO comment) {
		return sql.insert("rcm.recipecommentwrite", comment);
	}

	public List<CommentDTO> recipeCommentList(int crnumber) {
		return sql.selectList("rcm.recipecommentlist", crnumber);
	}

	public void recipeCommentDelete(int cnumber) {
		sql.delete("rcm.recipecommentdelete", cnumber);		
	}

	public CommentDTO recipeCommentUpdate(int cnumber) {
		return sql.selectOne("rcm.recipecommentupdate", cnumber);
	}

	public int recipeCommentUpdateProcess(CommentDTO comment) {
		return sql.update("rcm.recipecommentupdateprocess", comment);
	}

}

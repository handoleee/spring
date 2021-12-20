package recipe.shop.mall.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import recipe.shop.mall.dto.ShopCommentDTO;

@Repository
public class ShopCommentDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	public int ShopCommentWrite(ShopCommentDTO srcomment) {
		return sql.insert("srcm.shopcommentwrite", srcomment);
	}

	public List<ShopCommentDTO> ShopCommentList(int srnumber) {
		return sql.selectList("srcm.shopcommentlist", srnumber);
	}



	

	
}

package recipe.shop.mall.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import recipe.shop.mall.dto.CartDTO;

@Repository
public class CartDAO {
	
	@Autowired
	private SqlSessionTemplate sql;
	
	
	public int cart(CartDTO cart) {
		return sql.insert("cart.shopcart", cart);
	}

	// 내 장바구니
	public List<CartDTO> yeyagList(String loginMember) {
		return sql.selectList("cart.bsaklist", loginMember);
	}
	
	public CartDTO cartView(int sbnumber) {
		return sql.selectOne("cart.cartview", sbnumber);
	}
	
	// 장바구니 취소
	public void cartDelete(int sbnumber) {
		sql.delete("cart.cartdelete", sbnumber);
	}
	
	// 수량 수정 요청
	public int cartupdateProcess(CartDTO cart) {
		return sql.update("cart.cartupdate", cart);
	}

}

package recipe.shop.mall.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import recipe.shop.mall.dto.ShopDTO;

@Repository
public class ShopDAO {
	
	@Autowired
	private SqlSessionTemplate sql;
	
	
	
	// 재료 등록 처리
	public void shopadd(ShopDTO shopadd) {
		sql.insert("sp.shopadd", shopadd);
	}


	

	// 상품목록
	public List<ShopDTO> ShopList() {
		return sql.selectList("sp.shoplist");
	}

	// 상품상세조회
	public ShopDTO ShopView(int snumber) {
		return sql.selectOne("sp.shopview", snumber);
	}



	// 재료수정
	public void shopupdate(ShopDTO shop) {
		sql.update("sp.shopupdate", shop);
	}



	// 재료삭제
	public int shopDelete(int snumber) {
		return sql.delete("sp.shopdelete", snumber);
	}


	// 재료 검색
		public List<ShopDTO> shopSearch(String keyword) {
			return sql.selectList("sp.shopsearch", keyword);
		}

//	public List<ShopDTO> Shop() {
//		return sql.selectList("sp.shoplist");
//	}





	


	
	

}

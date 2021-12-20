package recipe.shop.mall.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import recipe.shop.mall.dto.MaterialDTO;
import recipe.shop.mall.dto.OrderDTO;
import recipe.shop.mall.dto.PageDTO;
import recipe.shop.mall.dto.PurchaserDTO;
import recipe.shop.mall.dto.RecipeDTO;
import recipe.shop.mall.dto.ReportDTO;

@Repository
public class RecipeDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	public List<RecipeDTO> recipeList(PageDTO paging) {
		return sql.selectList("rm.recipelist", paging);
	}

	public void recipeWrite(RecipeDTO recipe) {
		sql.insert("rm.recipewrite", recipe);
	}

	public int recipeWriteNumber() {
		return sql.selectOne("rm.recipewritenumber");
	}

	public void materialWrite(MaterialDTO material) {
		sql.insert("rm.materialwrite", material);
	}

	public void orderWrite(OrderDTO order) {
		sql.insert("rm.orderwrite", order);
	}

	public RecipeDTO recipeView(int rnumber) {
		return sql.selectOne("rm.recipeview", rnumber);
	}

	public void updateHits(RecipeDTO recipe) {
		sql.update("rm.updatehits", recipe);
	}

	public MaterialDTO materialView(int rnumber) {
		return sql.selectOne("rm.materialview", rnumber);
	}

	public OrderDTO orderView(int rnumber) {
		return sql.selectOne("rm.orderview", rnumber);
	}

	public void recipeReportProcess(ReportDTO report) {
		sql.insert("rm.recipereportprocess", report);
	}

	public void recipeDelete(int rnumber) {
		sql.delete("rm.recipedelete", rnumber);
	}

	public void recipeUpdate(RecipeDTO recipe) {
		sql.update("rm.recipeupdate", recipe);
		
	}

	public void materialUpdate(MaterialDTO material) {
		sql.update("rm.materialupdate", material);
		
	}

	public void orderUpdate(OrderDTO order) {
		sql.update("rm.orderupdate", order);
	}

	public List<RecipeDTO> recipeRanking() {
		return sql.selectList("rm.reciperanking");
	}

	public List<RecipeDTO> recipeSearch(String keyword) {
		return sql.selectList("rm.recipesearch", keyword);
	}

	public List<ReportDTO> totalReport() {
		// mapper의 totalReport 호출하면서 list 넘김
		return sql.selectList("rm.totalreport");
	}
	
	public List<RecipeDTO> myRecipeList(String rname) {
		// mapper의 myRecipeList 호출하면서 rname 넘김
		return sql.selectList("rm.myrecipelist", rname);
	}
	
	public List<ReportDTO> myReport(String rpname) {
		// mapper의 myReport 호출하면서 rpname 넘김
		return sql.selectList("rm.myreport", rpname);
	}

	public ReportDTO reportView(int rpnumber) {
		return sql.selectOne("rm.reportview", rpnumber);
	}

	public int reportUpdateProcess(ReportDTO report) {
		return sql.update("rm.reportupdateprocess", report);
	}

	public int listCount() {
		return sql.selectOne("rm.listcount");
	}

	public List<RecipeDTO> categorySearch(String keyword) {
		return sql.selectList("rm.categorysearch", keyword);
	}
	
//	public List<PurchaserDTO> myBuyRecipe() {
//		return sql.selectList("rm.mybuyrecipe");
//	}
}
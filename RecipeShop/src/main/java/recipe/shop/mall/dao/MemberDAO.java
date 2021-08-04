package recipe.shop.mall.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import recipe.shop.mall.dto.MemberDTO;
import recipe.shop.mall.dto.PurchaserDTO;
import recipe.shop.mall.dto.RecipeDTO;
import recipe.shop.mall.dto.ReportDTO;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate sql;

	public int memberJoin(MemberDTO member) {
		return sql.insert("mm.memberjoin", member);
	}

	public String idCheck(String mid) {
		return sql.selectOne("mm.idcheck", mid);
	}
	
	public String memberLogin(MemberDTO member) {
		return sql.selectOne("mm.memberlogin", member);
	}

	public MemberDTO memberUpdate(String loginId) {
		return sql.selectOne("mm.memberupdate", loginId);
	}

	public int memberUpdateProcess(MemberDTO member) {
		return sql.update("mm.memberupdateprocess", member);
	}

	public void memberDelete(String mid) {
		sql.delete("mm.memberdelete", mid);
	}

	public List<ReportDTO> myReport(String loginId) {
		return sql.selectList("rm.myReport", loginId);
	}

	public List<RecipeDTO> myRecipeList() {
		return sql.selectList("rem.myRecipeList");
	}

	public List<PurchaserDTO> myBuyRecipe(String loginId) {
		return sql.selectList("pm.myBuyRecipe", loginId);
	}
	
	public List<MemberDTO> memberList() {
		return sql.selectList("mm.memberlist");
	}

	public MemberDTO memberView(String mid) {
		return sql.selectOne("mm.memberview", mid);
	}
	
	public List<ReportDTO> totalReport() {
		return sql.selectList("rm.totalreport");
	}

	public MemberDTO adminPoint(String mid) {
		return sql.selectOne("mm.adminpoint", mid);
	}

	public int adminPointProcess(MemberDTO member) {
		return sql.update("mm.adminpointprocess", member);
	}
}

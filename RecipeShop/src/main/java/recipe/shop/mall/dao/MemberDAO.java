package recipe.shop.mall.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import recipe.shop.mall.dto.MemberDTO;


@Repository
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate sql;

	public int memberJoin(MemberDTO member) {
		// mapper의 memberJoin 호출하면서 MemberDTO 객체 넘김
		return sql.insert("mm.memberjoin", member);
	}

	public String idCheck(String mid) {
		// mapper의 idCheck 호출하면서 mid 넘김
		return sql.selectOne("mm.idcheck", mid);
	}
	
	public String memberLogin(MemberDTO member) {
		// mapper의 memberLogin 호출하면서 MemberDTO 객체 넘김
		return sql.selectOne("mm.memberlogin", member);
	}

	public MemberDTO memberUpdate(String loginId) {
		// mapper의 memberUpdate 호출하면서 loginId 넘김
		return sql.selectOne("mm.memberupdate", loginId);
	}

	public int memberUpdateProcess(MemberDTO member) {
		// mapper의 memberUpdateProcess 호출하면서 MemberDTO 객체 넘김
		return sql.update("mm.memberupdateprocess", member);
	}

	public void memberDelete(String mid) {
		// mapper의 memberDelete 호출하면서 mid 넘김
		sql.delete("mm.memberdelete", mid);
	}
	
	public List<MemberDTO> memberList() {
		// mapper의 memberList 호출하면서 list 넘김
		return sql.selectList("mm.memberlist");
	}

	public MemberDTO memberView(String mid) {
		// mapper의 memberView 호출하면서 mid 넘김
		return sql.selectOne("mm.memberview", mid);
	}

	public MemberDTO adminPoint(String mid) {
		// mapper의 adminPoint 호출하면서 mid 넘김
		return sql.selectOne("mm.adminpoint", mid);
	}

	public int adminPointProcess(MemberDTO member) {
		// mapper의 adminPointProcess 호출하면서 MemberDTO 객체 넘김
		return sql.update("mm.adminpointprocess", member);
	}
}

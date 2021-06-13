package com.cafe.board.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe.board.dto.MemberDTO;

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

//	public String pwCheck(String mpassword) {
//		return sql.selectOne("mm.pwcheck", mpassword);
//	}

	public String memberLogin(MemberDTO member) {
		return sql.selectOne("mm.memberlogin", member);
	}

}

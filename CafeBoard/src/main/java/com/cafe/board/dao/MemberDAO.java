package com.cafe.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe.board.dto.ContentsDTO;
import com.cafe.board.dto.LikeDTO;
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

	public MemberDTO mypage(String loginId) {
		return sql.selectOne("mm.mypage", loginId);
	}

	public List<MemberDTO> memberList() {
		return sql.selectList("mm.memberlist");
	}

	public MemberDTO memberUpdate(String loginId) {
		return sql.selectOne("mm.memberupdate", loginId);
	}

	public int memberUpdateProcess(MemberDTO member) {
		return sql.update("mm.memberupdateprocess", member);
	}

//	public MemberDTO myPage(String loginId) {
//		return sql.selectOne("mm.mypage", loginId);
//	}
	
//	public List<ContentsDTO> likeList(MemberDTO member) {
//		return sql.selectList("cm.likelist", member);
//	}

//	public List<LikeDTO> likeList() {
//		return sql.selectOne("mm.likelist");
//	}
//
//	public int likeListProcess(MemberDTO member) {
//		return sql.update("mm.likelistprocess", member);
//	}

}

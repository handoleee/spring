package com.cafe.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe.board.dto.ContentsDTO;
import com.cafe.board.dto.PageDTO;

@Repository
public class ContentsDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	public List<ContentsDTO> contentsList() {
		return sql.selectList("cm.contentslist");
	}
	
	public void adminMenu(ContentsDTO contents) {
		sql.insert("cm.adminmenu", contents);
	}

	public List<ContentsDTO> adminMenuList() {
		return sql.selectList("cm.adminmenulist");
	}

//	public ContentsDTO addmenu() {
//		return sql.selectOne("cm.addmenu");
//	}
//
//	public int addmenuProcess(ContentsDTO contents) {
//		return sql.insert("cm.addmenuprocess", contents);
//	}

	public void menuDelete(int cnumber) {
		sql.delete("cm.menudelete", cnumber);
	}

	public int listCount() {
		return sql.selectOne("cm.listcount");
	}

	public List<ContentsDTO> contentsPaging(PageDTO paging) {
		return sql.selectList("cm.contentspaging", paging);
	}

	public ContentsDTO menuUpdate(int cnumber) {
		return sql.selectOne("cm.menuupdate", cnumber);
	}

	public int menuUpdateProcess(ContentsDTO contents) {
		return sql.update("cm.menuupdateprocess", contents);
	}

	public ContentsDTO menuView(int cnumber) {
		return sql.selectOne("cm.menuview", cnumber);
	}

	

}

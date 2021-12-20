package com.cafe.board.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe.board.dto.BrandDTO;
import com.cafe.board.dto.ContentsDTO;
import com.cafe.board.dto.ContentsPageDTO;

@Repository
public class ContentsDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	public List<ContentsDTO> contentsList(ContentsPageDTO paging) {
		return sql.selectList("cm.contentslist", paging);
	}
	
	public void adminMenu(ContentsDTO contents) {
		sql.insert("cm.adminmenu", contents);
	}

	public List<ContentsDTO> adminMenuList() {
		return sql.selectList("cm.adminmenulist");
	}

	public void menuDelete(int cnumber) {
		sql.delete("cm.menudelete", cnumber);
	}

	public int listCount() {
		return sql.selectOne("cm.listcount");
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

	public List<ContentsDTO> menuSearch(Map<String, String> searchMap) {
		return sql.selectList("cm.menusearch", searchMap);
	}
	
	public List<BrandDTO> brandList(ContentsDTO contents) {
		return sql.selectList("cm.brandlist", contents);
	}

}

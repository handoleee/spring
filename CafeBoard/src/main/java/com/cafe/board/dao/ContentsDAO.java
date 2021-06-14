package com.cafe.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe.board.dto.ContentsDTO;

@Repository
public class ContentsDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	public int adminMenu(ContentsDTO contents) {
		return sql.insert("cm.adminmenu", contents);
	}

	public List<ContentsDTO> adminMenuList() {
		return sql.selectList("cm.adminmenulist");
	}

	public ContentsDTO addmenu() {
		return sql.selectOne("cm.addmenu");
	}

	public int addmenuProcess(ContentsDTO contents) {
		return sql.update("cm.addmenuprocess", contents);
	}

	public void adminmenuDelete(int cnumber) {
		sql.delete("cm.adminmenudelete", cnumber);
		
	}

}

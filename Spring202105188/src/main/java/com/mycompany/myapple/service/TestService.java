package com.mycompany.myapple.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapple.dao.TestDAO;

@Service
public class TestService {
	
	@Autowired
	private TestDAO tdao;
	
	public void method1() {
		System.out.println("method1 호출");
	}
	public void method2(String data1) {
		System.out.println(data1);
		tdao.daoMethod1(data1);
	}
}

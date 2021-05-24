package com.icia.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.example.dao.TestDAO;

@Service
public class TestService {
	
	// TestService 클래스는 com.icia.example.service 패키지에 소속되어 있고,
	// TestDAO 클래스는 com.icia.example.dao 패키지에 소속되어 있음
	// 두 블래스는 서로 다른 패키지에 소속되어 있기 때문에 import를 해줘야 사용이 가능함
	@Autowired
	private TestDAO tdao;
	
	public void method1() {
		System.out.println("method1 호출됨");
	}
	public void method2(String data1) {
		System.out.println(data1);
		//hello.jsp => HomeController로부터 받은 data1을 TestDAO 클래스의 daoMethod()
		tdao.daoMethod1(data1);
	}
}

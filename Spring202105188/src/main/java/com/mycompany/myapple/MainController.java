package com.mycompany.myapple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.myapple.dao.TestDAO;
import com.mycompany.myapple.service.TestService;

@Controller
public class MainController {

	@RequestMapping(value="/")
	public String hello() {
		return "hello";
	}
	
	@RequestMapping(value="/test123")
	public void test123() {
		System.out.println("test123 주소요청");
	}
	
	@RequestMapping(value="/welcome")
	public String welcome() {
		System.out.println("welcome 이동");
		return "welcome";
		}
	
		/* 첫번째 welcomemsg */
//	@RequestMapping(value="/welcomemsg")
//	public void welcomemsg(@RequestParam ("msg") String msg) {
//		System.out.println("welcommemsg 출력");
//		System.out.println(msg);
//	}

//	@RequestMapping(value="/welcomemsg", method=RequestMethod.GET)
//	public void welcome1(@RequestParam("msg") String msg) {
//		System.out.println(msg);
//	}

//	@RequestMapping(value="/welcomemsg", method=RequestMethod.POST)
//	public void welcome1(@RequestParam("msg") String msg) {
//		System.out.println(msg);
//	}
	
	@RequestMapping(value="/welcomemsg")
	public void welcomemsg(
			@RequestParam("msg") String msg,
			@RequestParam("msg2") String msg2) {
		System.out.println("welcomemsg 출력");
		System.out.println(msg);
		System.out.println(msg2);
	}
	
	@RequestMapping(value="/linkmsg")
	public void linkmsg(
			@RequestParam("val1") String val1,
			@RequestParam("val2") String val2) {
		System.out.println(val1);
		System.out.println(val2);
	}
	
	@Autowired
	private TestService ts;
	
	@RequestMapping(value="/insertDB")
	public void insertDB(@RequestParam("data1") String data1) {
		System.out.println(data1);
		
		ts.method1();
		ts.method2(data1);
	}
	
	@Autowired
	private TestDAO tdao;
	public void method2(String data1) {
		System.out.println(data1);
		tdao.daoMethod1(data1);
	}
	
}

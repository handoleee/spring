package com.mycompany.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@RequestMapping(value="/")
	public String home() {
		System.out.println("home 호출");
		return "home";
	}
	
	@RequestMapping(value="/a")
	public void homea() {
		System.out.println("homea 호출");
	}
	
	@RequestMapping(value="/abc")
	public String abc() {
		System.out.println("abc 호출");
		return "abc";
	}
	
	@RequestMapping(value="/paramtest")
	public void home3(@RequestParam("param1") String aaa) {
		System.out.println("home3 메소드 호출");
		System.out.println(aaa);
		
	}
}

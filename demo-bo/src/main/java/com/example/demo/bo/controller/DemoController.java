package com.example.demo.bo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "")
@Controller
public class DemoController {
	
	@RequestMapping(value = "/test")
	public String index_test() {		
		return "index_test";
	}
	
	@RequestMapping(value = "")
	public String index() {		
		return "index";
	}	
	
	@RequestMapping(value = "/sample3")
	public String sample3() {		
		return "sample3";
	}
	

}

package com.example.project.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	  	@RequestMapping("/hello")
	    public String hello() {

//	        이동할 템플릿의 이름
	        return "/hello.html";
	    }
	  	
}

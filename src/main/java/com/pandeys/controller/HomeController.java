package com.pandeys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String getHomePage() {
		System.out.println("home over here");
		return "home.jsp";
	}
}

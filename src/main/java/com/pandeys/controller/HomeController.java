package com.pandeys.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public ModelAndView getHomePage(@RequestParam("name") String name) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("modelViewParam", name);
		mv.setViewName("home");
		return mv;
	}
}

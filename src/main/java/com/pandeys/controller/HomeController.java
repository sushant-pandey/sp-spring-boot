package com.pandeys.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pandeys.model.Alien;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public ModelAndView getHomePage(Alien alien) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("alien", alien);
		mv.setViewName("home");
		return mv;
	}
}

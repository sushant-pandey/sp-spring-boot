package com.pandeys.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String getHomePage(HttpServletRequest req, Model model) {
		String name = req.getParameter("name");
		HttpSession session = req.getSession();
		session.setAttribute("sessionName", name);
		model.addAttribute("modelName", name);
		return "home";
	}
}

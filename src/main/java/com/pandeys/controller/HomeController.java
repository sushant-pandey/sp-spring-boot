package com.pandeys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pandeys.dao.AlienDAO;
import com.pandeys.model.Alien;

@Controller
public class HomeController {
	
	@Autowired
	private AlienDAO alienDAO;
	
	@RequestMapping("/home")
	public ModelAndView getHomePage(Alien alien, Model model) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("alien", alien);
		mv.setViewName("home");
		
		Iterable<Alien> aliens = alienDAO.findAll();
		model.addAttribute("aliens", aliens);
		
		List<Alien> revAliens = alienDAO.fetchDataLatestToOldest();
		model.addAttribute("revAliens", revAliens);
		
		
		
		return mv;
	}
	
	@RequestMapping("/addAlien")
	public String addAlien(@ModelAttribute("alien") Alien alien, Model model) {
		System.out.println("Alien Name = " + alien.getaName());
		alienDAO.save(alien);
		
		Iterable<Alien> aliens = alienDAO.findAll();
		model.addAttribute("aliens", aliens);
		
		List<Alien> revAliens = alienDAO.fetchDataLatestToOldest();
		model.addAttribute("revAliens", revAliens);
		
		return "home";
	}
	
	@RequestMapping("/filterByLanguage")
	public String filterAlienByLanguage(@ModelAttribute("langAlien") Alien langAlien, 
			Model model) {
		return "filter-by-lang";
	}
	
	@RequestMapping("/getAlienByLanguage")
	public String getAlienByLanguage(@RequestParam("lang") String language, 
			Model model) {
		System.out.println("Language to search = " + language);
		List<Alien> langAliens = alienDAO.findByLang(language);
		model.addAttribute("langAliens", langAliens);
		System.out.println("Language 001 aliens");
		System.out.println(langAliens);
		
		return "filter-by-lang";
	}
	
	
}

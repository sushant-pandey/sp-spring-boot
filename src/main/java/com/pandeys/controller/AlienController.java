package com.pandeys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pandeys.dao.AlienDAO;

@Controller
public class AlienController {
	
	@Autowired
	private AlienDAO alienDAO;
	
	/*
	 * This method will return all the Alien objects from the database
	 */
	@RequestMapping("/aliens")
	@ResponseBody
	public String getAllAliens() {
		return alienDAO.findAll().toString();
	}
	
	/*
	 * This method will return all the Alien objects which have the aid as given in path parameter.
	 * One object will be returned at the time
	 * Response will be in string format
	 */
	@RequestMapping("/alien/{aid}")
	@ResponseBody
	public String getAlienById(@PathVariable("aid") Integer alienId) {
		return alienDAO.findById(alienId).toString();
	}
}

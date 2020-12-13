package com.pandeys.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pandeys.dao.AlienDAO;
import com.pandeys.dao.AlienJpaDAO;
import com.pandeys.model.Alien;

@Controller
public class AlienController {
	
	@Autowired
	private AlienDAO alienDAO;
	
	@Autowired
	private AlienJpaDAO alienJpaDao;
	
	/*
	 * This method will return all the Alien objects from the database
	 */
	@RequestMapping("/aliens")
	@ResponseBody
	public List<Alien> getAllAliens() {
		return alienJpaDao.findAll();
	}
	
	/*
	 * This method will return all the Alien objects which have the aid as given in path parameter.
	 * One object will be returned at the time
	 * Response will be in string format
	 */
	@RequestMapping("/alien/{aid}")
	@ResponseBody
	public Optional<Alien> getAlienById(@PathVariable("aid") Integer alienId) {
		return alienJpaDao.findById(alienId);
	}
}

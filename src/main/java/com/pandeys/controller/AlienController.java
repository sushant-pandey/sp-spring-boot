package com.pandeys.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pandeys.dao.AlienJpaDAO;
import com.pandeys.model.Alien;

@Controller
public class AlienController {
	
	@Autowired
	private AlienJpaDAO alienJpaDao;
	
	@RequestMapping(path = "/aliens")
	@ResponseBody
	public List<Alien> getAllAliens() {
		return alienJpaDao.findAll();
	}
	
	@RequestMapping(path = "/alien/{aid}")
	@ResponseBody
	public Optional<Alien> getAlienById(@PathVariable("aid") Integer alienId) {
		return alienJpaDao.findById(alienId);
	}
}

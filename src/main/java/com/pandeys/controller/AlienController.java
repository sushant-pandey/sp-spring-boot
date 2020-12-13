package com.pandeys.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pandeys.dao.AlienJpaDAO;
import com.pandeys.model.Alien;

@RestController
public class AlienController {
	
	@Autowired
	private AlienJpaDAO alienJpaDao;
	
	@GetMapping(path = "/aliens")
	@ResponseBody
	public List<Alien> getAllAliens() {
		return alienJpaDao.findAll();
	}
	
	@PostMapping(path = "/alien", consumes = {"application/json"})
	@ResponseBody
	public Alien addAlien(@RequestBody Alien alien) {
		alienJpaDao.save(alien);
		return alien;
	}
	
	@DeleteMapping(path = "/alien/{aid}")
	public String deleteAlien(@PathVariable Integer aid) {
		alienJpaDao.deleteById(aid);
		return "Alien deleted";
	}
	
	@PutMapping(path = "/alien", consumes = {"application/json"})
	public Alien addOrUpdateAlien(@RequestBody Alien alien) {
		return alienJpaDao.save(alien);
	}
	
	@GetMapping(path = "/alien/{aid}")
	@ResponseBody
	public Optional<Alien> getAlienById(@PathVariable("aid") Integer alienId) {
		return alienJpaDao.findById(alienId);
	}
}

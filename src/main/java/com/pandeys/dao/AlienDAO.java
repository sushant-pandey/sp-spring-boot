package com.pandeys.dao;

import org.springframework.data.repository.CrudRepository;

import com.pandeys.model.Alien;

public interface AlienDAO extends CrudRepository<Alien, Integer> {

}

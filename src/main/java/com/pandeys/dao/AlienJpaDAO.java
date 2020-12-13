package com.pandeys.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pandeys.model.Alien;

public interface AlienJpaDAO extends JpaRepository<Alien, Integer> {

}

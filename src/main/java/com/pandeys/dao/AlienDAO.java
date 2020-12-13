package com.pandeys.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pandeys.model.Alien;

public interface AlienDAO extends CrudRepository<Alien, Integer> {

	@Query("from Alien order by aid desc")
	List<Alien> fetchDataLatestToOldest();
	
	@Query("from Alien where lang = 'Language001'")
	List<Alien> findAliensOfLanguage001();
	
	List<Alien> findByLang(String language);
}

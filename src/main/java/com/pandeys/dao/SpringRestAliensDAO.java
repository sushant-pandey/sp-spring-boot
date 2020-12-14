package com.pandeys.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.pandeys.model.Alien;

@RepositoryRestResource(collectionResourceRel = "aliens", path = "aliens")
public interface SpringRestAliensDAO extends JpaRepository<Alien, Integer> {

}

package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.sql.results.graph.instantiation.internal.ArgumentDomainResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.registration;
import com.example.demo.repository.registrationrepository;

@Service
public class registrationservice {

	@Autowired
	registrationrepository repo;
//	single insertion
	public registration addcusto(registration reg) {
		return repo.save(reg);
	}
//multiple insertion	
	public Iterable<registration> addallcusto(List<registration> reg) {
		return repo.saveAll(reg);
	}
//fetching	
	public List<registration> fetchcusto(){
		return (List<registration>) repo.findAll();
	}
	
	public Optional<registration> fetch(int id) {
		return repo.findById(id);
	}
	
	public String delete(int id) {
		 repo.deleteById(id);
		 return "successfully deleted" +id;
	}
	
	public registration update(registration reg) {
		int id=reg.getId();
		registration reg2=repo.findById(id).get();
		reg2.setEmail(reg.getEmail());
		reg2.setName(reg.getName());
		reg2.setPassword(reg.getPassword());
		return repo.save(reg2);
	}

}

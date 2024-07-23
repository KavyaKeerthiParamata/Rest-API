package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.registration;
import com.example.demo.services.registrationservice;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:4200")
public class registrationcontroller {
	
	@Autowired
	registrationservice service;
	
	@PostMapping("/add")
	public registration addcusto(@RequestBody registration reg) {
		return service.addcusto(reg);
	}
	@PostMapping("/addall")
	public Iterable<registration> addallcusto(@RequestBody List<registration> reg) {
		return service.addallcusto(reg);
	}
	@GetMapping("/fetchall")
	public List<registration> fetchcusto(){
		return service.fetchcusto();
	}
	@GetMapping("/fetch/{id}")
	public Optional<registration> fetch(@PathVariable int id) {
		return service.fetch(id);
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		return service.delete(id);
	}
	@PutMapping("/update")
	public registration updating(@RequestBody registration reg) {
		return service.update(reg);
	}

}

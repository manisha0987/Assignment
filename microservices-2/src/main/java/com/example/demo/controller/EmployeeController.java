package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;

import com.example.demo.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	
	@GetMapping(path="/employees",produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<Employee> viewEmployeeList(){
		List<Employee> emplist=service.listAll();
		return emplist;
	}
	
	@PostMapping("/employees")
	public Employee createNewEmployee(@Valid @RequestBody Employee employee) {
		
		return  service.create(employee);
	}

	@GetMapping(path="/employees/{id}",produces= {MediaType.APPLICATION_JSON_VALUE})
	public Optional<Employee> findEmployee(@PathVariable int id) {
		return service.findEmp(id);
		
	}
	
	@DeleteMapping("/employees/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.delete(id);
	}
	
	
	@PutMapping("/employees/{id}")
	public String updateProduct(@PathVariable(value="id") Integer id, @Valid @RequestBody Employee newEmployee) {
		return service.update(id, newEmployee);
		
		
	}
	
	
	
	
}

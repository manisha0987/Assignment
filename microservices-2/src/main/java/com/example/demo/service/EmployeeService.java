package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;

import com.example.demo.repository.EmployeeRepository;

import jakarta.validation.Valid;

@Service
public class EmployeeService {
	
	
	@Autowired
	EmployeeRepository repo;

	public List<Employee> listAll() {
			
		return repo.findAll();
	
	}

	public Employee create(@Valid Employee employee) {
		// TODO Auto-generated method stub
		
		
		repo.save(employee);
		
		return employee;
	}

	public Optional<Employee> findEmp(int id) {

		return repo.findById(id);
		
	}

	public String delete(int id) {

		 repo.deleteById(id);
		 return "deleted";
		
		
	}

	public String update(Integer id, @Valid Employee newEmployee) {
	
		
		Optional<Employee> existingProduct = repo.findById(id);
		if(existingProduct.isPresent()) {
			Employee foundProduct = existingProduct.get();
			foundProduct.setName(newEmployee.getName());
			foundProduct.setSalary(newEmployee.getSalary());
			repo.save(foundProduct);

			return "product Updated";
		}
		return "product Not Updated";
		
		
	}
		
	}
	
	



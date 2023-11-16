package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;

@RestController
@RequestMapping(path="/api")
public class DepartmentController {
	@Autowired
	DepartmentService service;
	
	
	@GetMapping("/hello")
	public String printHello() {
		return "Hi spring";
	}
	
	@GetMapping(path="/department",produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<Department> viewDepartmentList() {
		List<Department> listdepartments = service.listAll();
		return listdepartments;
	}
	
	@GetMapping("/department/{pid}")
	public Optional<Department> findByDepartment(@PathVariable int pid) {
		return service.getDepartment(pid);
	}
	
	@PostMapping("/department")
	public Department createEmployee(@Validated @RequestBody Department newDepartment) {
		return service.createDepartment(newDepartment);
	}
	
	@DeleteMapping("/department/{id}")
	public Map<String, Boolean> deleteDepartment(@PathVariable(value = "id")Integer departmentId){
		return service.deleteDepartment(departmentId);
	}
	
	@PutMapping("/department/{id}")
	public String updateDepartment(@PathVariable(value="id") Integer id, @Validated @RequestBody Department newDepartment) {
		return service.updateDepartment(id, newDepartment);
	}

}

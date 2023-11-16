package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	DepartmentRepository productRepo;
	public List<Department> listAll() {
	
	return productRepo.findAll();
	
	}
	
	public Optional<Department> getDepartment(int id){
		Optional<Department> p=productRepo.findById(id);
		return p;
	}
	
	public Department createDepartment(Department product) {
		return productRepo.save(product);
	}
	
	public Map<String,Boolean> deleteDepartment(Integer productId){
		productRepo.deleteById(productId);
		Map<String,Boolean> response=new HashMap();
		response.put("product has been deleted", Boolean.TRUE);
		return response;
	}
	
	public String updateDepartment(Integer productId, Department newDepartment) {
		Optional<Department> existingDepartment = productRepo.findById(productId);
		if(existingDepartment.isPresent()) {
			Department foundDepartment = existingDepartment.get();
			foundDepartment.setDeptName(newDepartment.getDeptName());
			foundDepartment.setDeptCode(newDepartment.getDeptCode());
			productRepo.save(foundDepartment);
 
			return "product Updated";
		}
		return "product Not Updated";

	}

}

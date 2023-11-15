package com.cgc.customerservice;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgc.customerrepository.CustomerRepository;
import com.cgc.entity.Customer;


@Service
@Transactional
public class CustomerService {
	
	@Autowired
	private CustomerRepository repo;
	public List<Customer> listAll(){
		List<Customer> customers=repo.findAll();
		System.out.println(customers);
		return customers;
	}
	
	public void save(Customer customer) {
		repo.save(customer);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

	public Customer get(Long id) {
		return repo.findById(id).get();
	}
	
	

}

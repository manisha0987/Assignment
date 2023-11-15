package com.cgc.customerrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cgc.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}

package com.boa.customerapiexternal.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.AbstractQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boa.customerapiexternal.models.Customer;
import com.boa.customerapiexternal.repositories.CustomerRepo;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	//create
	
	public Customer addCustomer(Customer Customer) {
		if(Customer !=null) 		
  		 return this.customerRepo.save(Customer);
		else
			return null;
	}
	
	
	
	public Customer getCustomerById(long customerId) {
		return this.customerRepo.findById(customerId).orElse(null);
	}
	
	
	
	
}

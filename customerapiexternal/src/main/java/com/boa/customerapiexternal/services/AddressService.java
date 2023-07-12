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

import com.boa.customerapiexternal.models.Address;
import com.boa.customerapiexternal.models.Customer;
import com.boa.customerapiexternal.repositories.AddressRepo;


@Service
public class AddressService {
	
	@Autowired
	private AddressRepo addressRepo;
	@Autowired
	private CustomerService customerService;

	@Autowired
	private EntityManager entityManager;
	
	//create
	
	public Address addAddress(long customerId,Address address) {
		
		Customer customer=this.customerService.getCustomerById(customerId);
		if(customer!=null) {
			if(address !=null) 
			{
		      address.setCustomer(customer);
		
  		     return this.addressRepo.save(address);
   
			}
			else
				return null;
		}
		else
			return null;
	}
	
	//retrieve
	public List<Address> getAllAddresss(){
		return this.addressRepo.findAll();
	}
	
	
	
	//non primary key
	public List<Address> findAllByFirstName(long customerId){
    	CriteriaBuilder cb= entityManager.getCriteriaBuilder();
    	AbstractQuery<Address> cq=cb.createQuery(Address.class);
    	
    	Root<Address> AddressObject=cq.from(Address.class);
    	cq.where(cb.equal(AddressObject.get("customer").<Long> get("customerId") ,customerId));
    	
    	CriteriaQuery<Address> selectResult=((CriteriaQuery<Address>)cq).select(AddressObject);
    	TypedQuery<Address> tq=entityManager.createQuery(selectResult);
    	return tq.getResultList();
    }

	
	
	//update
	public Address updateAddress(Address address) {
		
		 if(address!=null) {
			
			this.addressRepo.save(address);
			return address;
		 }
		 else
			 return null;
		 
	}
	
	//delete
	
	public  boolean deleteAddressById(long addressId) {
		
		boolean status=false;
		if(this.addressRepo.findById(addressId)!=null) {
			this.addressRepo.deleteById(addressId);
			status=true;
		}
		return status;
	}
	
}